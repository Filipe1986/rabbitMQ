package com.filipe.rabbitmq.controller;

import com.filipe.rabbitmq.constants.Constants;
import com.filipe.rabbitmq.constants.Constants.*;
import com.filipe.rabbitmq.domain.event.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class Controller {

	private final RabbitTemplate rabbitTemplate;

	public Controller(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@PostMapping("topic")
	public ResponseEntity<?> topic(@RequestBody SimpleMessage body) {
		rabbitTemplate.convertAndSend(RabbitMqQueue.Exchange.TOPIC_EXCHANGE, body.getTopic(), body.toString());
		return ResponseEntity.ok(body);
	}
}
