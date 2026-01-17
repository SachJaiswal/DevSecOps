pipeline {
  agent any

  stages {

    stage('Terraform Security Scan') {
  steps {
    sh '''
      docker run --rm \
      --volumes-from jenkins \
      aquasec/trivy:latest \
      config --exit-code 0 /var/jenkins_home/workspace/devsecops-pipeline/terraform
    '''
  }
}

    stage('Terraform Plan') {
      steps {
        sh '''
          docker run --rm \
          --volumes-from jenkins \
          -w /var/jenkins_home/workspace/devsecops-pipeline/terraform \
          hashicorp/terraform:latest \
          init

          docker run --rm \
          --volumes-from jenkins \
          -w /var/jenkins_home/workspace/devsecops-pipeline/terraform \
          hashicorp/terraform:latest \
          plan
        '''
      }
    }
  }
}
