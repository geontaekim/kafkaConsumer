package com.kafka.consumer.service;

import java.io.IOException;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaSampleConsumerService {
	
	 @KafkaListener(topics = "oingdaddy", groupId = "group-id-oing")
	    public void consume(String message) throws IOException {
	        System.out.println("receive message : " + message);
	        
	        
	        
	    }
		
	} 
	
	
