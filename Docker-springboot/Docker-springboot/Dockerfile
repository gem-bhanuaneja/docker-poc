FROM maven:3.6.3-openjdk-11
WORKDIR /app
# Copy code
COPY . .
# Build
mvn clean install -DskipTests
# final directory
RUN mkdir -p /finaljar
# Copy built jar
RUN cp target/SpringBootCrud-0.0.1-SNAPSHOT.jar /finaljar/SpringBootCrud-0.0.1-SNAPSHOT.jar
# Remove code
RUN rm -rf /app
ENTRYPOINT ["java", "-jar", "/finaljar/SpringBootCrud-0.0.1-SNAPSHOT.jar"]
EXPOSE 9090