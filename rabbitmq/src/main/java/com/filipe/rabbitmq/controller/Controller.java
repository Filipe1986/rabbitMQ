package com.filipe.rabbitmq.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("ue")
public class Controller {
		

	//public SearchController() {}

	@GetMapping()
	public ResponseEntity<?> find() {
		
		return ResponseEntity.ok("ok");
	}

}
