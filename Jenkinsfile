void setBuildStatus(String message, String state) {
    def repoUrl = scm.userRemoteConfigs[0].url
    step([
            $class: 'GitHubCommitStatusSetter',
            reposSource: [$class: 'ManuallyEnteredRepositorySource', url: repoUrl],
            statusResultSource: [
                    $class: 'ConditionalStatusResultSource',
                    results: [[$class: 'AnyBuildResult', message: message, state: state]]
            ]
    ])
}

void setCommitStatus(String repoUrl) {
    step([
            $class: 'GitHubCommitStatusSetter',
            reposSource: [$class: 'ManuallyEnteredRepositorySource', url: repoUrl]
    ])
}

pipeline {
    agent any

    options {
        timestamps()
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Clean') {
            steps {
                println "Kind: ${currentBuild.changeSets[0].kind}"
                println "Message: ${currentBuild.changeSets[0].items[0].msg}"
                sh 'git clean -xdff'
            }
        }
        stage('Test') {
            steps {
//                setBuildStatus 'Build in progress', 'PENDING'
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            setCommitStatus scm.userRemoteConfigs[0].url
            cleanWs()
        }
//        success {
//            setBuildStatus 'Build succeeded', 'SUCCESS'
//        }
//        unsuccessful {
//            setBuildStatus 'Build failed', 'FAILURE'
//        }
    }
}