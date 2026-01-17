pipeline {
  agent any

  stages {
    stage('Terraform Security Scan') {
      steps {
        sh '''
          docker run --rm -v $(pwd):/project aquasec/trivy config /project/terraform
        '''
      }
    }

    stage('Terraform Plan') {
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
