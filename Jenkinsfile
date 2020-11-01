void setBuildStatus(String message, String state) {
    def repoUrl = scm.userRemoteConfigs[0].url
    sh 'echo $GIT_URL'
    step([
            $class: "GitHubCommitStatusSetter",
            reposSource: [$class: "ManuallyEnteredRepositorySource", url: repoUrl],
            errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
            statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
    ])
}

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
                sh 'echo $GIT_URL'
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