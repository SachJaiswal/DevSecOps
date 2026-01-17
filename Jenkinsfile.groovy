pipeline {
    agent any

    stages {
        stage('Terraform Security Scan') {
            steps {
                // We add --severity HIGH,CRITICAL if you only want to block big issues
                // We add --exit-code 1 to FAIL the build if issues are found
                sh '''
                    docker run --rm \
                    -v ${WORKSPACE}:/project \
                    aquasec/trivy:latest \
                    config --exit-code 1 /project
                '''
            }
        }

        stage('Terraform Plan') {
            steps {
                sh '''
                    docker run --rm \
                    -v ${WORKSPACE}:/project \
                    --entrypoint /bin/sh \
                    hashicorp/terraform:latest \
                    -c "cd /project/Terraform || cd /project/terraform; terraform init && terraform plan"
                '''
            }
        }
    }
}