# Étape 1 : Utiliser Maven pour compiler l'application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Utiliser une image OpenJDK pour exécuter l'application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Spécifier le chemin du fichier JAR généré dans le répertoire target
ARG JAR_FILE=target/springmvc-0.0.1-SNAPSHOT.jar  # Mettez à jour avec le nom exact du fichier .jar
COPY ${JAR_FILE} app.jar

# Exécuter le fichier JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Exposer le port 9090
EXPOSE 9090

