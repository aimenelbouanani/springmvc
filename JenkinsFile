pipeline {
    agent any  // Spécifie que le pipeline peut s'exécuter sur n'importe quel agent disponible

    environment {
        // Définir des variables d'environnement globales si nécessaire
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
        MAVEN_HOME = '/opt/maven'
    }

    stages {
        stage('Checkout') {
            steps {
                // Cette étape vérifie le code depuis le repository
                git 'https://github.com/aimenelbouanani/springmvc.git'  // Remplacez avec l'URL de votre repository
            }
        }

        stage('Setup JDK') {
            steps {
                // Étape de configuration du JDK
                script {
                    // Assurez-vous que le JDK 17 est installé sur le serveur Jenkins
                    sh 'java -version'
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                // Installer les dépendances avec Maven
                script {
                    sh '${MAVEN_HOME}/bin/mvn clean install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                // Exécuter les tests Maven
                script {
                    // Lancer les tests avec Maven et générer les rapports
                    sh '${MAVEN_HOME}/bin/mvn test'
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
                // Si tout est ok, on déploie l'application
                script {
                    sh 'echo "Deploying Application"'
                    // Vous pouvez mettre ici la commande réelle de déploiement
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

