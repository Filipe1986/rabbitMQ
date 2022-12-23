#!/bin/sh

MAIN_CLASS=com.filipe.rabbitmq.RabbitmqApplication

JAVAAGENTS="";
for f in $(ls /app/agents); do
    JAVAAGENTS=$(echo "${JAVAAGENTS} -javaagent:/app/libs/$f");
done

echo "The application will start now!"

set -x
java ${JAVA_OPTS} ${JAVAAGENTS} -Djava.security.egd=file:/dev/./urandom -cp /app/resources:/app/classes:/app/libs/* "${MAIN_CLASS}"  "$@"

