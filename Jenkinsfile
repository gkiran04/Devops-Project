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
    }
    

}