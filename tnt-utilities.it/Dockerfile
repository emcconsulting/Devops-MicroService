FROM java:8
#VOLUME /tmp
RUN apt-get update
RUN apt-get install -y netcat
ADD target/tnt-utilities.it-0.0.1-SNAPSHOT.jar app.jar
ADD wait.sh wait.sh
RUN chmod 777 wait.sh
RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
