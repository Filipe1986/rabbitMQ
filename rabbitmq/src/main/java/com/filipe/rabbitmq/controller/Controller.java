package com.filipe.rabbitmq.controller;

import com.filipe.rabbitmq.constants.Constants.*;
import com.filipe.rabbitmq.domain.event.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.filipe.rabbitmq.constants.Constants.Exchange;

@RestController
@RequestMapping()
public class Controller {

	private final RabbitTemplate rabbitTemplate;

	public Controller(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@GetMapping()
	public ResponseEntity<?> stringMessage(@RequestParam(required = true) String entry) {
		rabbitTemplate.convertAndSend(Exchange.TOPIC_TEXT, RoutingKey.FOO_BAR_FIZZ, entry);
		return ResponseEntity.ok(entry);
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> string2Message(@RequestParam(required = true) String entry) {
		rabbitTemplate.convertAndSend(Exchange.TOPIC_JSON, RoutingKey.FOO_BAR_FIZZ, entry);
		return ResponseEntity.ok(entry);
	}

	@PostMapping("asString")
	public ResponseEntity<?> create(@RequestBody String body) {
		rabbitTemplate.convertAndSend(Exchange.TOPIC_TEXT, RoutingKey.FOO_BAR_FIZZ, body);
		return ResponseEntity.ok(body);
	}

	@PostMapping("object")
	public ResponseEntity<?> create(@RequestBody SimpleMessage body) {
		rabbitTemplate.convertAndSend(Exchange.TOPIC_TEXT, RoutingKey.FOO_BAR_FIZZ, body);
		return ResponseEntity.ok(body);
	}
}
