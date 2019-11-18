pipeline {
agent any
stages {
  stage('Build') {
    steps {
      sh 'JAVA_HOME=/var/jenkins_home/jdk-12/ mvn clean test-compile'
    }
  }
  stage('Test') {
    steps {
      sh 'JAVA_HOME=/var/jenkins_home/jdk-12/ mvn clean test'
    }
  }
}
tools {
  jdk 'jdk-12'
  maven 'maven'
}
}
