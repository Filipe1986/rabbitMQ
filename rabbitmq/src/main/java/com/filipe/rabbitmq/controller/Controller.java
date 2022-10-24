package com.filipe.rabbitmq.controller;

import com.filipe.domain.constants.Constants.RabbitMqQueue;
import com.filipe.domain.event.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class Controller {
	private final RabbitTemplate rabbitTemplate;

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	public Controller(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@PostMapping("topic")
	public ResponseEntity<?> topic(@RequestBody SimpleMessage body) {

		logger.info(body.toString());
		rabbitTemplate.convertAndSend(RabbitMqQueue.Exchange.TOPIC_EXCHANGE, body.getTopic(), body);
		return ResponseEntity.ok(body);
	}
}
