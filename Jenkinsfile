pipeline {
  agent any

  stages {

    stage('Terraform Security Scan') {
      steps {
        sh '''
          docker run --rm \
          -v $PWD:/project \
          aquasec/trivy:latest \
          config /project/Terraform
        '''
      }
    }

    stage('Terraform Plan') {
      steps {
        sh '''
          docker run --rm \
          -v $PWD/Terraform:/terraform \
          -w /terraform \
          hashicorp/terraform:latest \
          init

          docker run --rm \
          -v $PWD/Terraform:/terraform \
          -w /terraform \
          hashicorp/terraform:latest \
          plan
        '''
      }
    }
  }
}
