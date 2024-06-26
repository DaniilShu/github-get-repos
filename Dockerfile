#Stage 1
FROM maven:3.8.1-openjdk-17-slim as build
WORKDIR /app
COPY . /app
RUN ["mvn","clean","package"]

#Stage 2
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/github-get-repos-0.0.1-SNAPSHOT.jar /app
# EXPOSE 8080
ENTRYPOINT ["java", "-jar", "github-get-repos-0.0.1-SNAPSHOT.jar"]