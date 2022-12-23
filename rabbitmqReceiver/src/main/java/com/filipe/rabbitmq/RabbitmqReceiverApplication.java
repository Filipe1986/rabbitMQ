package com.filipe.rabbitmq;


import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RabbitmqReceiverApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqReceiverApplication.class, args);
	}

}
