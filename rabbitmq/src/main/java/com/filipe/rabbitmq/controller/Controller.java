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

/*	@GetMapping()
	public ResponseEntity<?> stringMessage(@RequestParam(required = true) String entry) {
		rabbitTemplate.convertAndSend(RabbitMqQueue.Topics.TOPIC_TEXT, RabbitMqQueue.RoutingKey.FOO_BAR_FIZZ, entry);
		return ResponseEntity.ok(entry);
	}

	@PostMapping("asString")
	public ResponseEntity<?> create(@RequestBody String body) {
		rabbitTemplate.convertAndSend(RabbitMqQueue.Topics.MY_EXCHANGE, "topic", body);
		return ResponseEntity.ok(body);
	}



	@PostMapping("object")
	public ResponseEntity<?> create(@RequestBody SimpleMessage body) {
		rabbitTemplate.convertAndSend(RabbitMqQueue.Topics.MY_EXCHANGE, "topic", body);
		return ResponseEntity.ok(body);
	}

*/
	@PostMapping("topic")
	public ResponseEntity<?> topic(@RequestBody String body) {
		rabbitTemplate.convertAndSend(RabbitMqQueue.Exchange.TOPIC_EXCHANGE, RabbitMqQueue.Topics.TOPIC + "_2", body);
		return ResponseEntity.ok(body);
	}

	@PostMapping("topic2")
	public ResponseEntity<?> topic2(@RequestBody String body) {
		rabbitTemplate.convertAndSend(RabbitMqQueue.Exchange.TOPIC_EXCHANGE, RabbitMqQueue.Topics.TOPIC_2 , body);
		return ResponseEntity.ok(body);
	}
}
