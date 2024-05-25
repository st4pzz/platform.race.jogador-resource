pipeline {
    agent any
    stages {
        stage('Build Jogador') {
            steps {
                build job: 'race.jogador', wait: true
            }
        }
        stage('Build Redis') {
            steps {
                build job: 'race.redis', wait: true
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean package'
            }
        }      
        stage('Build Image') {
            steps {
                script {
                    jogador = docker.build("weeeveralex/jogador:${env.BUILD_ID}", "-f Dockerfile .")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credential') {
                        jogador.push("${env.BUILD_ID}")
                        jogador.push("latest")
                    }
                }
            }
        }
        stage('Deploy on k8s') {
            steps {
                withCredentials([ string(credentialsId: 'minikube_credentials', variable: 'api_token') ]) {
                    sh 'kubectl --token $api_token --server https://host.docker.internal:59443  --insecure-skip-tls-verify=true apply -f ./k8s/deployment.yaml '
                    sh 'kubectl --token $api_token --server https://host.docker.internal:59443  --insecure-skip-tls-verify=true apply -f ./k8s/service.yaml '
                    sh 'kubectl --token $api_token --server https://host.docker.internal:59443 --insecure-skip-tls-verify=true apply -f ./k8s/configmap.yaml '
                }
            }
        }
    }
}