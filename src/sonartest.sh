#!/usr/bin/env zsh

ssh -L 8080:localhost:9000 ichi@192.168.122.99

./gradlew sonarqube \
  -Dsonar.projectKey=Duckish \
  -Dsonar.host.url=http://localhost:8080 \
  -Dsonar.login=a5728b158edeb54659356dc9d6dd579538004663