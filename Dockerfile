# 1. FÁZE: Build (použijeme JDK a Maven)
FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /app

# Zkopírujeme soubory pro Maven (pom.xml a wrapper, pokud ho máš)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Sestavíme aplikaci (vynecháme testy pro rychlost buildu)
# Pokud nepoužíváš mvnw, nahraď ho 'mvn' (ale musel by být v image)
RUN ./mvnw clean package -DskipTests

# 2. FÁZE: Runtime (lehčí JRE pro běh aplikace)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Maven standardně generuje JAR do složky target/
# Hvězdička ošetří verzi v názvu (např. triage-be1-0.0.1-SNAPSHOT.jar)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]