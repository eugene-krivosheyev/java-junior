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

        stage('code-analysis') {
            agent { node { label 'ci' } }

            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://81.163.25.104:9000 -Dsonar.login=dbe3f1554ad7509551b5494a39dac40578b92fca'
            }
        }
    }
}