package com.kafkaTesting.kafka.kafkaTest.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kafkaTesting.kafka.kafkaTest.Service.KafkaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/kaf")
public class KafkaController {

	@Autowired
	private KafkaService kafkaService;
	
	 @PostMapping("/kafka")
	public String kafka_test(@RequestBody String jsonData) throws Exception{
		 
		  	log.debug("jsonData:::::"+jsonData);
		  	JSONObject json =new JSONObject(jsonData);
		  	log.debug("check::::"+json);
		  	
		  	HashMap<String, Object> params = new HashMap<>();
		  	params.put("type", json.get("type"));
		  	params.put("code", json.get("code"));
		  	log.debug("check params:::{}"+params);
		  	HashMap<String , Object> resultMap = new HashMap<>();
		  	ArrayList<HashMap<String , Object>> list = new ArrayList();
		  	list = kafkaService.selectEmpList(params);
		  	
		  	log.debug("result::::"+list);
		  
		  	
		  	
	        return list.toString();
	    }
	  
		
	}
	
