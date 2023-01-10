package com.kafka.consumer.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.service.KafkaService;

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
	public ModelMap kafka_test(@RequestBody String pam) throws Exception{
		 
		 	log.debug("pam::::"+pam);
		 	
		  	JSONObject jsonData =new JSONObject(pam);
		  	//log.debug("check::::"+jsonData);
		  	//ObjectMapper obj = new ObjectMapper();
		  	//HashMap<String,String> map = obj.readValue(pam,HashMap.class );
		  	//log.debug("check:::::"+map);
		 	
		  	HashMap<String, Object> params = new HashMap<>();
		  	params.put("ename", jsonData.get("ENAME"));
		  	//params.put("code", json.get("code"));
		  	log.debug("check params:::{}"+params);
		  	HashMap<String , Object> resultMap = new HashMap<>();
		  	ArrayList<HashMap<String , Object>> list = new ArrayList();
		  	list = kafkaService.selectEmpList(params);
		  	ModelMap map = new ModelMap();
		  	log.debug("result::::"+list);
		  	
		  	map.put("dataList", list);
			map.put("errorCode", 1);
			map.put("errorMsg", "성공");
		  	
		  	return map;
		  	 
	    }
	  
		
	}
	
