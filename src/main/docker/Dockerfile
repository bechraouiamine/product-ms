FROM openjdk:17.0.1-jdk-slim
WORKDIR application
COPY maven/${project.build.finalName}.jar ./${project.build.finalName}.jar
ENTRYPOINT ["java","-jar","${project.build.finalName}.jar"]