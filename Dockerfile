FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/timesheet-devops-10.jar timesheet-devops-10.jar
ENTRYPOINT ["java","-jar","/timesheet-devops-10.jar"]