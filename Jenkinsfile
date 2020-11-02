enum CommitState {
    ERROR, FAILURE, PENDING, SUCCESS
    CommitState() {}
}

static String buildStatusMessage(build, CommitState state) {
    switch (state) {
        case CommitState.ERROR:
            return "Build $build.displayName errored in ${build.durationString.minus(' and counting')}"
        case CommitState.FAILURE:
            return "Build $build.displayName failed in ${build.durationString.minus(' and counting')}"
        case CommitState.SUCCESS:
            return "$build.displayName succeeded in ${build.durationString.minus(' and counting')}"
        default:
            return "Build $build.displayName in progress"
    }
}

void githubStatus(CommitState state) {
    def repoUrl = scm.userRemoteConfigs[0].url
    def message = buildStatusMessage(currentBuild, state)
    step([
            $class: 'GitHubCommitStatusSetter',
            reposSource: [$class: 'ManuallyEnteredRepositorySource', url: repoUrl],
            statusResultSource: [
                    $class: 'ConditionalStatusResultSource',
                    results: [[$class: 'AnyBuildResult', message: message, state: state.name()]]
            ]
    ])
}

pipeline {
    agent any

    options { timestamps() }

    triggers { githubPush() }

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
                githubStatus CommitState.PENDING
                sh 'mvn test'
            }
        }
    }

    post {
        always { cleanWs() }
        success { githubStatus CommitState.SUCCESS }
        unsuccessful { githubStatus CommitState.FAILURE }
    }
}