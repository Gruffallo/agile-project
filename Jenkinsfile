enum CommitState {
    ERROR, FAILURE, PENDING, SUCCESS
    public CommitState() {}
}

static String buildStatusMessage(build, CommitState state) {
    switch (state) {
        case CommitState.ERROR:
            return "Build $build.displayName errored in $build.durationString"
        case CommitState.FAILURE:
            return "Build $build.displayName failed in $build.durationString"
        case CommitState.SUCCESS:
            return "$build.displayName succeeded in $build.durationString"
        default:
            return "Build $build.displayName in progress"
    }
}

void githubStatus(build, CommitState state) {
    def repoUrl = scm.userRemoteConfigs[0].url
    def message = buildStatusMessage(build, state)
    step([
            $class: 'GitHubCommitStatusSetter',
            reposSource: [$class: 'ManuallyEnteredRepositorySource', url: repoUrl],
            statusResultSource: [
                    $class: 'ConditionalStatusResultSource',
                    results: [[$class: 'AnyBuildResult', message: message, state: state.name()]]
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
                setBuildStatus currentBuild, CommitState.PENDING
                sh 'mvn test'
            }
        }
    }

    post {
        always { cleanWs() }
        success { githubStatus currentBuild, CommitState.SUCCESS }
        unsuccessful { githubStatus currentBuild, CommitState.FAILURE }
    }
}