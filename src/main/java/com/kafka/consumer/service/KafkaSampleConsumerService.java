package com.kafka.consumer.service;

import java.io.IOException;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaSampleConsumerService {
	
	 @KafkaListener(topics = "guntae", groupId = "group-id-oing")
	    public void consume(String message) throws IOException {
		 	log.debug("csadsadsadsadsadsadsad");
		 	
		 	
		 	
	        log.debug("check:::::"+message);
	        
	        
	        
	        
	    }
		
	} 
	
	
