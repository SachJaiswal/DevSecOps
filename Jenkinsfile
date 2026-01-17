pipeline {
    agent {
        label 'windows'
    }

    stages {
        stage('Terraform Security Scan') {
            steps {
                bat 'trivy config terraform'
            }
        }

        stage('Terraform Plan') {
            steps {
                bat '''
                cd terraform
                terraform init
                terraform plan -var="project_id=zippy-vigil-453906-u5"
                '''
            }
        }
    }
}
