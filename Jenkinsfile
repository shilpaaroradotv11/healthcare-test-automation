
pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out Medicare automation code'
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            junit(
                testResults: 'target/surefire-reports/*.xml',
                allowEmptyResults: true
            )

            archiveArtifacts(
                artifacts: 'test-output/ExtentReport.html',
                allowEmptyArchive: true
            )
        }

        success {
            echo 'Medicare automation pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check the console output and test reports.'
        }
    }
}
