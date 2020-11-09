FROM java:8

RUN mkdir -p /data/app/bin /data/app/run

COPY build/libs/options-1.0-SNAPSHOT.jar /data/app/bin/options.jar

ENV JAVA_OPTS "-Djava.security.egd=file:/dev/./urandom -Denv=docker -DenvTarget=docker"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /data/app/bin/options.jar" ]
