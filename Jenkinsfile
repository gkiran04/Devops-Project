pipeline{
    agent{
        label 'aksnode'
    }
    environment{
        VERSION = "${env.BUILD_ID}"
    }
    stages{
        stage('SOURCE CODE') {
            steps{
                git branch: 'main', url: 'https://github.com/gkiran04/Devops-Project.git'
                
            }
        }
        stage('UNIT TEST'){
            steps {
                sh 'mvn test'
            }
        }

	    stage('INTEGRATION TEST'){
            steps {
                sh 'mvn verify -DskipUnitTests' 
            } 
        }

        stage('BUILD & PUSH IMAGE'){
            environment{
                ACR_REG= "devops2021.azurecr.io"
            }
            steps {
                sh '''
                    docker image build -t $ACR_REG/openmrs:v${VERSION} .
                    az acr login --name devops2021
                    docker push ${ACR_REG}/openmrs:v${VERSION}
                    docker rmi ${ACR_REG}/openmrs:v${VERSION}
                '''
                
            }
        }

        stage ('Terraform Validation'){
            steps{
                dir('terraform-aks-k8s') {
                    sh 'terraform init'
                    sh 'terraform validate'
                }
            }
        }
    }
    

}