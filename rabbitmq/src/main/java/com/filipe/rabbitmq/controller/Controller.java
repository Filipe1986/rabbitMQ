package com.filipe.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.filipe.rabbitmq.RabbitmqApplication;
import com.filipe.rabbitmq.constants.Constants.Topics;

@RestController
@RequestMapping()
public class Controller {

	private final RabbitTemplate rabbitTemplate;

	public Controller(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@GetMapping()
	public ResponseEntity<?> stringMessage(@RequestParam(required = true) String entry) {
		rabbitTemplate.convertAndSend(Topics.TOPIC_TEXT, "foo.bar.fizz", entry);
		return ResponseEntity.ok(entry);
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> string2Message(@RequestParam(required = true) String entry) {
		rabbitTemplate.convertAndSend(Topics.TOPIC_JSON, "foo.bar.fizz", entry);
		return ResponseEntity.ok(entry);
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody String body) {
		rabbitTemplate.convertAndSend(Topics.TOPIC_TEXT, "foo.bar.fizz", body);
		return ResponseEntity.ok(body);
	}

}
