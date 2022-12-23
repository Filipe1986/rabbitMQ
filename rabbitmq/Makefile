docker-up:
	docker-compose -f ./src/main/docker/docker-compose.yml up -d
docker-stop:
	docker-compose -f ./docker/docker-compose.yml stop
docker-down:
	docker-compose -f ./docker/docker-compose.yml down

docker-refresh: docker-down docker-up

rabbitMQ-home:
	xdg-open http://localhost:15672/  & echo 'user and password : guest'

image:
	mvn clean verify jib:dockerBuild