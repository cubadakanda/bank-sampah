# ================================
# Stage 1: Build dengan Maven
# ================================
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy Maven wrapper dan pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies dulu (cache layer)
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copy source code dan build
COPY src src
RUN ./mvnw package -DskipTests -B

# ================================
# Stage 2: Runtime image (lebih kecil)
# ================================
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy JAR dari stage build
COPY --from=builder /app/target/*.jar app.jar

# Expose port (Railway akan override dengan $PORT)
EXPOSE 8080

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]
