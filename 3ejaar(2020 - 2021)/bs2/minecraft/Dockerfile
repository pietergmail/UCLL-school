FROM openjdk:8
COPY server.jar /usr/src/myapp
COPY eula.txt /usr/src/eula.txt
WORKDIR /usr/src/

EXPOSE 25565
CMD java -jar myapp
