pipeline {
  agent any

  stages {

    stage('Terraform Security Scan') {
      steps {
        sh '''
          docker run --rm \
          -v $(pwd):/project \
          aquasec/trivy config /project/terraform
        '''
      }
    }

    stage('Terraform Plan') {
      steps {
        sh '''
          docker run --rm \
          -v $(pwd)/terraform:/terraform \
          hashicorp/terraform init
          
          docker run --rm \
          -v $(pwd)/terraform:/terraform \
          hashicorp/terraform plan
        '''
      }
    }
  }
}
