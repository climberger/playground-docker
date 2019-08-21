rmdir /s /q docker-context
mkdir docker-context
call mvn clean
call mvn package -DskipTests
copy target\spring-docker-0.0.1-SNAPSHOT.jar docker-context\spring-docker-0.0.1-SNAPSHOT.jar
docker stop springdocker
docker rm springdocker
docker build -f DOCKERFILE -t spring-docker docker-context
rmdir /s /q docker-context
mkdir docker-context