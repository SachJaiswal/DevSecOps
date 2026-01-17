pipeline {
    agent any

    stages {
        stage('Terraform Security Scan') {
            steps {
                sh 'trivy config terraform/'
            }
        }

        stage('Terraform Plan') {
            steps {
                sh '''
                cd terraform
                terraform init
                terraform plan -var="project_id=zippy-vigil-453906-u5"
                '''
            }
        }
    }
}
