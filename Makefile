install:
	cd domain && mvn clean install
	cd rabbitmqListener && mvn clean install
	cd rabbitmqReceiver && mvn clean install
	cd rabbitmq && mvn clean install

image:
	cd rabbitmq && make image

docker-up:
	docker-compose -f ./docker/docker-compose.yml up -d
docker-stop:
	docker-compose -f ./docker/docker-compose.yml stop
docker-down:
	docker-compose -f ./docker/docker-compose.yml down

docker-refresh: docker-down docker-up

rabbitMQ-home:
	xdg-open http://localhost:15672/  & echo 'user and password : guest'