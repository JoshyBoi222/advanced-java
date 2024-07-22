FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar /app/D387_sample_code.jar
ENTRYPOINT ["java", "-jar", "/app/D387_sample_code.jar"]
EXPOSE 8080