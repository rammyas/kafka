package com.ramya.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import com.ramya.storage.MessageStorage;

@Component
public class KafkaConsumer {
	
	@Autowired
	MessageStorage storage;

	// @KafkaListener(topics="${order_topic}")
	@KafkaListener(topicPartitions={@TopicPartition(topic = "${test-topic}", partitions = { "${order.topic-partition}" }) })
    public void processMessage(String content) {
		storage.put(content);
    }
	

}
