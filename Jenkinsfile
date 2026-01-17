pipeline {
  agent any

  stages {

    stage('Terraform Security Scan') {
      steps {
        sh '''
          docker run --rm \
          -v $PWD/terraform:/terraform \
          aquasec/trivy:latest \
          config --exit-code 1 /terraform
        '''
      }
    }

    stage('Terraform Plan') {
      steps {
        sh '''
          docker run --rm \
          -v $PWD/terraform:/terraform \
          -w /terraform \
          hashicorp/terraform:latest \
          init

          docker run --rm \
          -v $PWD/terraform:/terraform \
          -w /terraform \
          hashicorp/terraform:latest \
          plan
        '''
      }
    }
  }
}
