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

	@PostMapping("direct")
	public ResponseEntity<?> exchangeDirect(@RequestBody SimpleMessage body) {

		logger.info(body.toString());
		body.setExchange(RabbitMqQueue.Exchange.DIRECT_EXCHANGE);
		rabbitTemplate.convertAndSend(RabbitMqQueue.Exchange.DIRECT_EXCHANGE, "routingKey", body);
		return ResponseEntity.ok(body);
	}

	@PostMapping("topic")
	public ResponseEntity<?> exchangeTopic(@RequestBody SimpleMessage body) {

		logger.info(body.toString());
		body.setExchange(RabbitMqQueue.Exchange.TOPIC_EXCHANGE);
		body.setRoutingKey(RabbitMqQueue.RoutingKey.ROUTING_KEY_1);
		rabbitTemplate.convertAndSend(RabbitMqQueue.Exchange.TOPIC_EXCHANGE, RabbitMqQueue.RoutingKey.ROUTING_KEY_1, body);
		return ResponseEntity.ok(body);
	}

	@PostMapping("fanout")
	public ResponseEntity<?> exchangeFanout(@RequestBody SimpleMessage body) {

		logger.info(body.toString());
		body.setExchange(RabbitMqQueue.Exchange.FANOUT_EXCHANGE);
		rabbitTemplate.convertAndSend(RabbitMqQueue.Exchange.FANOUT_EXCHANGE, "routingKey", body);
		return ResponseEntity.ok(body);
	}


}
