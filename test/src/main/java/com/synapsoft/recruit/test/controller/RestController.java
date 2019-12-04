package com.synapsoft.recruit.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synapsoft.recruit.test.service.ConvertService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired ConvertService service;
	
	@GetMapping(value="/hello/{hello}")
	public String isRunning(@PathVariable(required = false) String hello) {
		return hello + " is Running";
	}
	
	@PostMapping(value="/input")
	public String inputMoney(@RequestParam String money) {
		String result = service.convert(money);
		
		return result;
	}
}
