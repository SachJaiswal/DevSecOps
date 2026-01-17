pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/SachJaiswal/DevSecOps.git'
            }
        }

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
