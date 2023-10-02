#!/usr/bin/env bash

API_JAR_PATH="../multi-module-api/build/libs/*.jar"
BUILD_JAR=$(ls $API_JAR_PATH)
JAR_NAME=$(basename $BUILD_JAR)

CURRENT_PID=$(pgrep -f $JAR_NAME)

kill -9 $CURRENT_PID

nohup java -jar -Dspring.profiles.active=test $API_JAR_PATH &