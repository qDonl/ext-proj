#FROM maven:3.8.6-jdk-11
FROM arm64v8/maven:3-openjdk-11-slim
WORKDIR /proj
COPY . /proj
RUN mvn clean compile package -Dmaven.test.skip=true --settings=settings_aliyun_readOnly.xml
WORKDIR /app
RUN cp /proj/server/target/mental-health.jar . && rm -rf /proj
CMD java -jar mental-health.jar
EXPOSE 8866