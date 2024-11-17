pipeline {
    agent any  // Spécifie que le pipeline peut s'exécuter sur n'importe quel agent disponible

    tools {
        maven 'Maven 3.8.7'  // Assurez-vous que le nom correspond exactement à celui configuré dans Jenkins
    }

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'  // Définir le chemin du JDK
    }

    stages {
        stage('Checkout') {
            steps {
                // Cette étape vérifie le code depuis le repository
                git 'https://github.com/aimenelbouanani/springmvc.git'
            }
        }

        stage('Setup JDK') {
            steps {
                // Vérifiez la version du JDK
                script {
                    sh 'java -version'
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                // Installer les dépendances avec Maven
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                // Exécuter les tests avec Maven
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Archive Test Reports') {
            steps {
                // Archive les rapports de test générés
                archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
            }
        }

        stage('Publish Test Reports') {
            steps {
                // Publier les rapports de test sous forme visuelle dans Jenkins
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Deploy') {
            steps {
                // Déployer l'application
                script {
                    sh 'echo "Deploying Application"'
                    // Commande réelle de déploiement ici
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }

        failure {
            echo 'Pipeline failed!'
        }

        always {
            cleanWs()  // Nettoyer l'espace de travail à la fin de chaque exécution
        }
    }
}

