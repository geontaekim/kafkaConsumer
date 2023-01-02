package com.kafkaTesting.kafka.kafkaTest.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafkaTesting.kafka.kafkaTest.mapper.KafkaMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaService {
	
	@Autowired
	private KafkaMapper kafkamapper;

	
	public ArrayList<HashMap<String , Object>> selectEmpList(HashMap<String,Object> map){
		log.debug("[selectEmpList][work]");
		log.debug("[selectEmpList][check map]:::{}"+map);
		ArrayList<HashMap<String , Object>> result=kafkamapper.selectEmpList();
		
		log.debug("[checkResult]"+result);
		
		return result;
		
	} 
	
	
}
