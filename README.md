# DevSecOps Assignment

## Project Overview

### Architecture Explanation
This project implements a secure CI/CD pipeline using Jenkins. It automates the process of checking out code, scanning Infrastructure as Code (IaC) for security vulnerabilities using Trivy, and planning infrastructure changes using Terraform. The pipeline leverages Docker to run these tools in isolated environments.

### Cloud Provider Used
*   **Terraform**: Infrastructure provisioning (Provider configured within Terraform files).

### Tools and Technologies
*   **Jenkins**: CI/CD Orchestrator.
*   **Docker**: Containerization and build environment.
*   **Terraform**: Infrastructure as Code (IaC).
*   **Trivy**: Security scanner for containers and IaC.
*   **Node.js**: Application backend.

## Before & After Security Report

### Initial Failing Jenkins Scan
<img width="1852" height="1078" alt="image" src="https://github.com/user-attachments/assets/f1758b28-5ca5-4173-893d-8cdf52c76409" />

### Final Passing Jenkins Scan
<img width="647" height="510" alt="image" src="https://github.com/user-attachments/assets/661a730e-fe08-487d-82a4-47796654debf" />


## AI Usage Log (Mandatory)

### The Exact AI Prompt Used
> "pipeline { ... } is it compatable for these projet scan the folder"

### Summary of Identified Risks
1.  **Infrastructure Vulnerabilities**: The initial setup lacked automated scanning, leaving the infrastructure prone to misconfigurations (e.g., open ports, unencrypted data).
2.  **Environment Inconsistency**: Running tools directly on the host led to "command not found" errors and potential security exposure.
3.  **Path Configuration Errors**: Incorrect volume mounts prevented the security tools from accessing the source code.

### How the AI-Recommended Changes Improved Security
1.  **Trivy Integration**: Added a mandatory security scanning stage that checks Terraform configuration files for known vulnerabilities before any plan is executed.
2.  **Dockerized Pipeline Steps**: Transitioned to running pipeline steps inside Docker containers (using `aquasec/trivy` and `hashicorp/terraform` images), ensuring a clean, isolated, and reproducible security environment.
3.  **Robust Configuration**: Corrected volume mounting strategies to ensure the scanner correctly analyzes the codebase.
