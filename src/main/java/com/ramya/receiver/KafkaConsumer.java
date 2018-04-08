package com.ramya.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ramya.storage.MessageStorage;

@Component
public class KafkaConsumer {
	
	@Autowired
	MessageStorage storage;
	
	@KafkaListener(topics="${java_in_use_topic}")
    public void processMessage(String content) {
		storage.put(content);
    }
	

}
