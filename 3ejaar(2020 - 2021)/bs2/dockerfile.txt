FROM maven:3.5-jdk-8 as BUILD
COPY src /usr/src/myapp/src
COPY pom.xml /usr/src/myapp
RUN mvn -f /usr/src/myapp/pom.xml compiler:compile war:war
RUN ls -al /usr/src/myapp/target

FROM tomcat:7.0
COPY --from=BUILD /usr/src/myapp/target/*.war /usr/local/tomcat/webapps/ROOT.war