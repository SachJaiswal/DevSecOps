pipeline {
  agent any

  stages {
    stage('Terraform Security Scan') {
      agent {
        docker {
          image 'aquasec/trivy:latest'
          args '--entrypoint=""'
        }
      }
      steps {
        sh 'trivy config terraform'
      }
    }

    stage('Terraform Plan') {
      agent {
        docker {
          image 'hashicorp/terraform:latest'
          args '--entrypoint=""'
        }
      }
      steps {
        sh '''
          cd terraform
          terraform init
          terraform plan
        '''
      }
    }
  }
}
