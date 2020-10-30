pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage('Clean') {
            steps {
                sh 'git clean -xdff'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}