# ============================
#  Etapa 1: Construcción (Build)
# ============================
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia los archivos de Maven
COPY pom.xml .
COPY src ./src

# Compila el proyecto sin ejecutar los tests
RUN mvn clean package -DskipTests

# ============================
#  Etapa 2: Imagen final (Runtime)
# ============================
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copia el jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto por el que tu aplicación escucha
EXPOSE 8080

# Define el comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
