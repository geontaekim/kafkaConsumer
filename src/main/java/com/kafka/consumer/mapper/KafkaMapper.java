package com.kafka.consumer.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KafkaMapper {
	
	public ArrayList<HashMap<String,Object>> selectEmpList();
	
	  public int save(HashMap<String,Object> map);

	  public int update(HashMap<String,Object> map);
	
}
