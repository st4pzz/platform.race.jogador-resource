pipeline {
    agent any
    stages {
        stage('Build Jogador') {
            steps {
                build job: 'race.jogador', wait: true
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
    }
}