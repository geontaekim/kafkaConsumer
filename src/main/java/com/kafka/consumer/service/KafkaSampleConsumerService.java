package com.kafka.consumer.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaSampleConsumerService {

	
	 @KafkaListener(topics = "guntae", groupId = "group-id-oing")
	    public void consume(@RequestBody String message) throws IOException, ParseException {
		 	log.debug("check::{}"+message);
		 	
			
		 	//ArrayList<HashMap<String, String>> ss =(ArrayList<HashMap<String, String>>)sss;
		 	//log.debug("ss::::"+ss);
		 	//mapper.readValue(message, new TypeReference<ArrayList<HashMap<String,String>>>(){});
		 	
		 	//JSONObject json = new JSONObject(message);
		 	//log.debug("finalCheck:::"+json);
		 	
		 	//ArrayList<HashMap<String,String>> list = new ArrayList<>();
		 	//ObjectMapper mapper = new ObjectMapper();
		 	//HashMap<String,String> saveMap = mapper.readValue(message, HashMap.class);
		 	//log.debug("finalCheck:::"+saveMap);
		 	//list.add(saveMap);
		 	
		 
		 	
	    }
	 
	 
	 @KafkaListener(topics = "guntae2", groupId = "group-id-oing")
	    public void consume2(String message) throws IOException {
		 	log.debug("222222222222222222");
		 
		 	log.debug("check:::::"+message);
	       
	        
	    }
		
	} 
	
	
