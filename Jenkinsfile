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
    withMaven(jdk: 'zulu-8', publisherStrategy: 'EXPLICIT') {
      withSonarQubeEnv() {
        sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=kchan"
      }
    }
  }
}
