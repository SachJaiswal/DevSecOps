pipeline {
    agent any

    stages {

        stage('Trivy Terraform Scan') {
            steps {
                sh '''
                echo "Workspace contents:"
                ls -la

                echo "Terraform directory contents:"
                ls -la terraform

                docker run --rm \
                  -v $(pwd):/project \
                  aquasec/trivy:latest \
                  config /project/terraform || true
                '''
            }
        }

        stage('Terraform Plan') {
            steps {
                echo "Terraform plan will be executed after security fixes"
            }
        }
    }
}