pipeline {
    agent any
    stages {
        stage('Clean') {
            sh 'git clean -xdff'
        }
        stage('Test') {
            sh 'mvn test'
        }
    }
}