package com.pawan.springsecurityrolebased.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pawan.springsecurityrolebased.service.RecordLoaderService;
import com.pawan.springsecurityrolebased.util.APIResponse;

@RestController
@RequestMapping("/configure")
public class InitialDataLoaderController {
	
	
	
	@Autowired
	private RecordLoaderService recordLoaderServiceImpl;
	
	 @RequestMapping(value = "/dataloader", method = RequestMethod.GET)
	public APIResponse saveInitialData(){
		 System.out.println(" :: Called InitialDataLoaderController ::");
		 System.out.println("Object value of recordLoaderService ::"+recordLoaderServiceImpl);
		 recordLoaderServiceImpl.insertRecord();
		 APIResponse apiResponse=new APIResponse();
		 apiResponse.setResponseStatus("200");
		 apiResponse.setResponseMessage("save successfully");
		return apiResponse ;
	}
	
	
}
