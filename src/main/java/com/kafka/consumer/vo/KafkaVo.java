package com.kafka.consumer.vo;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

@Data
public class KafkaVo {
	
	 private String productName;
	    private Integer price;
	    private ArrayList<HashMap<String,Object>> params;
	    
}
