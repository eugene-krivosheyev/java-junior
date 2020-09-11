pipeline {
    agent none
    options {
        skipDefaultCheckout()
        skipStagesAfterUnstable()
    }

    environment {
        groupId = 'com.acme'
        artifactId = "app"
    }

    stages {
        stage('checkout-source') {
            agent { node { label 'ci' } }

            steps {
                checkout scm
            }
        }

        stage('clean-build-test-publish') {
            agent { node { label 'ci' } }

            steps {
                sh 'mvn clean deploy'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}