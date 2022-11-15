#!groovy
def repositoryUrl
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                script{
                    repositoryUrl = 'https://github.com/kalinchan/Java-Samples'
                    revision = checkout([$class: 'GitSCM',
                                  branches: [[name: "master"]],
                                  doGenerateSubmoduleConfigurations: false,
                                  extensions: [[$class: 'CleanCheckout']],
                                  submoduleCfg: [],
                                  userRemoteConfigs: [[url: repositoryUrl]]
                    ])
                }
                echo "Checked out ${repositoryUrl}"
            }

        }
        stage('Build') {
            tools {
                jdk 'zulu-8'
            }
            environment {
                JAVA_HOME = tool("${jdkVer}")
            }
            steps {
                withMaven(jdk: 'zulu-8', maven: 'maven') {
                    sh """mvn -version"""
                    sh """mvn -B -V -ff clean install"""
                }
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