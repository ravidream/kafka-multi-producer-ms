package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer{
	private static final String TOPIC = "test";
	
	@Autowired
	@Qualifier("producer1")
	private KafkaTemplate<String, String> kafkaTemplate1;
	
	@Autowired
	@Qualifier("producer2")
	private KafkaTemplate<String, String> kafkaTemplate2;


	public void sendMessage(String msg) {
	    kafkaTemplate1.send(TOPIC, msg);
	    kafkaTemplate2.send(TOPIC, msg);
	}
}