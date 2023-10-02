#!/bin/bash

API_JAR_PATH="../multi-module-api/build/libs/*.jar"
BUILD_JAR=$(ls $API_JAR_PATH)
JAR_NAME=$(basename $BUILD_JAR)

CURRENT_PID=$(pgrep -f $JAR_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> Not Found Execute App"
else
  kill -9 $CURRENT_PID
fi

DEPLOY_JAR="$DEPLOY_PATH/$JAR_NAME"

nohup java -jar -Dspring.profiles.active=test $API_JAR_PATH &

sleep 3