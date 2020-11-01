void setBuildStatus(String message, String state) {
    def repoUrl = scm.userRemoteConfigs[0].url
    step([
            $class: 'GitHubCommitStatusSetter',
            reposSource: [$class: 'ManuallyEnteredRepositorySource', url: repoUrl],
            errorHandlers: [[$class: 'ChangingBuildStatusErrorHandler', result: 'UNSTABLE']],
            statusResultSource: [
                    $class: 'ConditionalStatusResultSource',
                    results: [[$class: 'AnyBuildResult', message: message, state: state]]
            ]
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
                println "Set kind: ${currentBuild.changeSets[0].kind}"
                println "Commit message: ${currentBuild.changeSets[0].items[0].msg}"
                sh 'git clean -xdff'
            }
        }
        stage('Test') {
            steps {
                setBuildStatus 'Build in progress', 'PENDING'
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            setBuildStatus 'Build succeeded', 'SUCCESS'
        }
        unsuccessful {
            setBuildStatus 'Build failed', 'FAILURE'
        }
    }
}