#!/bin/bash

# placeholder

java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app/application.jar $1
