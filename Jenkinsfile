def getRepoURL() {
    sh "git config --get remote.origin.url > .git/remote-url"
    return readFile(".git/remote-url").trim()
}

void setBuildStatus(String message, String state) {
    step([
            $class: "GitHubCommitStatusSetter",
            reposSource: [$class: "ManuallyEnteredRepositorySource", url: getRepoURL()],
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
                setBuildStatus "Build in progress", "PENDING"
                sh 'mvn test'
            }
        }
    }
    post {
        success {
            setBuildStatus "Build succeeded", "SUCCESS"
        }
        unsuccessful {
            setBuildStatus "Build failed", "FAILURE"
        }
        always {
            cleanWs()
        }
    }
}