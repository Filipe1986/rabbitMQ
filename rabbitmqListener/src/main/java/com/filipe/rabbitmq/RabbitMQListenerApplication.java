package com.filipe.rabbitmq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RabbitMQListenerApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitMQListenerApplication.class, args);
	}
}
