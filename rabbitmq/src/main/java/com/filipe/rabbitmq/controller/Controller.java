package com.filipe.rabbitmq.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.rabbitmq.RabbitmqApplication;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping()
public class Controller {
		
	  private final RabbitTemplate rabbitTemplate;
	  
	public Controller(RabbitTemplate rabbitTemplate) {
	    this.rabbitTemplate = rabbitTemplate;
	  }

	@GetMapping()
	public ResponseEntity<?> find() {
		rabbitTemplate.convertAndSend(RabbitmqApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
		return ResponseEntity.ok("ok");
	}
	
	@PostMapping()
	public ResponseEntity<?> create(String body) {
		rabbitTemplate.convertAndSend(RabbitmqApplication.topicExchangeName, "foo.bar.baz", body);
		return ResponseEntity.ok("ok");
	}

}
