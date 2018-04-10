package com.ramya.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "java_in_use_topic";
	String testTopic = "test-topic";
	
	public void send(String data) {
	    
	   // kafkaTemplate.send(kafkaTopic, 0, data);
	    kafkaTemplate.send(testTopic, 1, data);
	}
}