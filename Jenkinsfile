#!groovy
//@Library('JenkinsLibrary') _

//JavaSamplesPipeline {
//    jdk = 'zulu-8'
//}

node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withMaven(jdk: 'zulu-11', publisherStrategy: 'EXPLICIT') {
      withSonarQubeEnv() {
        withCredentials([string(credentialsId: 'kchan-sonar', variable: 'login')]) {
          sh "mvn clean verify sonar:sonar -Dsonar.projectKey=kchan -Dsonar.login=${login}"
        }
      }
    }
  }
  
}
