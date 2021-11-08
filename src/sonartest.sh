#!/usr/bin/env zsh

ssh -L 8080:localhost:9000 ichi@192.168.122.99

./gradlew sonarqube \
  -Dsonar.projectKey=Duckish \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=417d022ee7f66409b7f34b8ec5263b8991cc4c65