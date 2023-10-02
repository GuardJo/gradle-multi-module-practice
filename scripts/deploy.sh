#!/bin/bash

API_JAR_PATH="/home/ubuntu/code-deploy/gradle-multi-module-practice/multi-module-api/build/libs/*.jar"
DEPLOY_LOG="/home/ubuntu/code-deploy/deploy.log"
DEPLOY_ERR_LOG="/home/ubuntu/code-deploy/deploy-error.log"
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

nohup java -jar -Dspring.profiles.active=test $API_JAR_PATH >> $DEPLOY_LOG 2> $DEPLOY_ERR_LOG &

sleep 3