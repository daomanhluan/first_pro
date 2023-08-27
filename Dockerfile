FROM java:openjdk-8u111

# Copy the necessary files


ARG JAR_FILE=target*.jar
COPY ./target/first_pro-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# mvn clean install --% -Dmaven.test.skip=true