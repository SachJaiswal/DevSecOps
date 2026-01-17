pipeline {
    agent any

    stages {

        stage('Trivy Terraform Scan') {
            steps {
                sh '''
                echo "Workspace contents:"
                ls -la

                docker run --rm \
                  -v $(pwd):/project \
                  aquasec/trivy:latest \
                  config /project || true
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