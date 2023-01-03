package com.kafka.consumer.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaSampleConsumerService {

	
	 @KafkaListener(topics = "guntae", groupId = "group-id-oing")
	    public void consume(String message) throws IOException, ParseException {
		 	log.debug("check:::::"+message);
		 	JSONObject json = new JSONObject(message);
		 	log.debug("finalCheck:::"+json);
		 	log.debug("json:::::"+json.get("ENAME"));
		 	  
	       
	        
	    }
	 
	 
	 @KafkaListener(topics = "guntae2", groupId = "group-id-oing")
	    public void consume2(String message) throws IOException {
		 	log.debug("222222222222222222");
		 
		 	log.debug("check:::::"+message);
	       
	        
	    }
		
	} 
	
	
