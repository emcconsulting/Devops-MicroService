FROM java:8
#VOLUME /tmp
ADD target/tnt-utilities-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
