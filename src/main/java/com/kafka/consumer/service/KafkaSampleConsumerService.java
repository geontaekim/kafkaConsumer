package com.kafka.consumer.service;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaSampleConsumerService {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	 @KafkaListener(topics = "guntae", groupId = "group-id-oing")
	    public void consume(String message) throws IOException, ParseException {
		 	log.debug("check::????{}"+message);
		 	//kafkaTemplate.send("guntae2",message);
		 	//ObjectMapper mapper = new ObjectMapper();
		 	//List<HashMap<String, Object>> myObjects = mapper.readValue(message.toString(), new TypeReference<List<HashMap<String, Object>>>(){});
		 	
		 	//ArrayList<HashMap<String, String>> ss =(ArrayList<HashMap<String, String>>)sss;
		 	//log.debug("ss::::"+ss);
		 	//mapper.readValue(message, new TypeReference<ArrayList<HashMap<String,String>>>(){});
		 	
		 	//JSONObject json = new JSONObject(message);
		 	//log.debug("finalCheck:::"+json.get("SAL"));
		 	
		 	
		 	//ArrayList<HashMap<String,String>> list = new ArrayList<>();
		 	//ObjectMapper mapper = new ObjectMapper();
		 	//HashMap<String,String> saveMap = mapper.readValue(message, HashMap.class);
		 	//log.debug("finalCheck:::"+saveMap);
		 	//list.add(saveMap);
		 	
		 
		 	
	    }
	 
	 @KafkaListener(topics = "guntae3", groupId = "group-id-guning")
	    public void consume3(String message) throws IOException, ParseException {
		 	log.debug("check::222{}"+message);
		 	//kafkaTemplate.send("guntae2",message);
		 	//ObjectMapper mapper = new ObjectMapper();
		 	//List<HashMap<String, Object>> myObjects = mapper.readValue(message.toString(), new TypeReference<List<HashMap<String, Object>>>(){});
		 	
		 	//ArrayList<HashMap<String, String>> ss =(ArrayList<HashMap<String, String>>)sss;
		 	//log.debug("ss::::"+ss);
		 	//mapper.readValue(message, new TypeReference<ArrayList<HashMap<String,String>>>(){});
		 	
		 	//JSONObject json = new JSONObject(message);
		 	//log.debug("finalCheck:::"+json.get("SAL"));
		 	
		 	
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
	
	
