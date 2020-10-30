properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any
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