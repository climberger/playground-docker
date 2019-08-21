
docker volume create --name=mongodata

docker run -p 27017-27019:27017-27019 -v mongodata:/data/db --name my-docker-mongo mongo:latest


