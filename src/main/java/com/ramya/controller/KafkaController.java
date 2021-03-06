package com.ramya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramya.sender.KafkaSender;
import com.ramya.storage.MessageStorage;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	@Autowired
	KafkaSender kafkaSender;

	@Autowired
	MessageStorage storage;
	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);

		return "Message sent to the Kafka Topic test-topic Successfully";
	}
	
	@GetMapping(value = "/consumer")
	public String consumer(){
		String messages = storage.toString();
		storage.clear();
		
		return messages;
	}
}
