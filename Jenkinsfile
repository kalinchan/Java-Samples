#!groovy
def repositoryUrl
def jdkVer = 'zulu-8'
pipeline {
    agent none
    options {
        buildDiscarder logRotator(daysToKeepStr: '14')
    }


    stages {
        stage('Checkout') {
            script{
                repositoryUrl = 'https://github.com/kalinchan/Java-Samples'
                revision = checkout changelog: false, poll: false,
                scm: [$class: 'GitSCM',
                      branches: [[name: "master"]],
                      doGenerateSubmoduleConfigurations: false,
                      extensions: [
                              [$class: 'SubmoduleOption',
                               disableSubmodules: false,
                               parentCredentials: true,
                               recursiveSubmodules: true,
                               reference: '',
                               trackingSubmodules: false]],
                      submoduleCfg: [],
                      userRemoteConfigs: repositoryUrl]
            }
            echo "Checked out ${repositoryUrl}"
        }
        stage('Build') {
            tools {
                jdk "${jdkVer}"
            }
            environment {
                JAVA_HOME = tool("${jdkVer}")
            }
            steps {
                sh """mvn -B -V -ff clean install"""
            }
            post {
                success {
                    script {
                        echo "DONE!"
                    }
                }
            }
        }
    }

}