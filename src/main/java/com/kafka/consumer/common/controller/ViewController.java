package com.kafka.consumer.common.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ViewController {

	@RequestMapping(value="/{viewName}/view")
	public String view(@PathVariable String viewName) {
		log.debug("요청한 JSP : "+"/"+viewName);
		return viewName;
	}
	@RequestMapping(value="/{viewName}.html")  //     /sales/estimateInfo.html
	public String swaggerview(@PathVariable String viewName) {
		System.out.println("###########################"+"/"+viewName);
		return "/"+viewName;
	}

	@RequestMapping(value="/{pack}/{viewName}/view")
	public String packView(@PathVariable String pack, @PathVariable String viewName) {
		System.out.println("폴더 : "+pack+" "+" 요청한 JSP : "+viewName);
		return pack+"/"+viewName;
	}
     
 
}

	
