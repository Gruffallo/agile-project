void setBuildStatus(String message, String state) {
    step([
            $class: "GitHubCommitStatusSetter",
            reposSource: [$class: "ManuallyEnteredRepositorySource", url: scm.userRemoteConfigs[0].url],
            errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
            statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
    ])
}

pipeline {
    agent any
    triggers {
        githubPush()
    }
    environment {
        REPO_URL = getRepoURL()
    }
    stages {
        stage('Clean') {
            steps {
                sh 'git clean -xdff'
            }
        }
        stage('Test') {
            steps {
                setBuildStatus "Build in progress", "PENDING"
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
        success {
            setBuildStatus "Build succeeded", "SUCCESS"
        }
        unsuccessful {
            setBuildStatus "Build failed", "FAILURE"
        }
    }
}