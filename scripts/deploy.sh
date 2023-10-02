#!/bin/bash

PROJECT_NAME="github-action"
API_JAR_PATH="../multi-module-api/build/libs/*.jar"
DEPLOY_PATH="/home/ubuntu/$PROJECT_NAME/"
DEPLOY_LOG_PATH="$DEPLOY_PATH/deploy.log"
DEPLOY_ERR_PATH="$DEPLOY_PATH/deploy-error.log"
BUILD_JAR=$(ls $API_JAR_PATH)
JAR_NAME=$(basename $BUILD_JAR)

echo "===== Deploying  Module ($(date +%c)) =====" >> $DEPLOY_LOG_PATH

echo "> Build FileName : $JAR_NAME" >> $DEPLOY_LOG_PATH
echo "> Build File Copies" >> $DEPLOY_LOG_PATH
cp $BUILD_JAR $DEPLOY_PATH

echo "> Check App pid" >> $DEPLOY_LOG_PATH
CURRENT_PID=$(pgrep -f $JAR_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> Not Found Execute App" >> $DEPLOY_LOG_PATH
else
  echo "> Found and Shuntdown Execute App (pid : $CURRENT_PID)" >> $DEPLOY_LOG_PATH
  kill -9 $CURRENT_PID
fi

DEPLOY_JAR=$DEPLOY_PATH$JAR_NAME

nohup java -jar -Dspring.profiles.active=test $DEPLOY_JAR 2> $DEPLOY_ERR_PATH &

sleep 3