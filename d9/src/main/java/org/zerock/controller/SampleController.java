package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@GetMapping("/doA")
	//all user can see this uri
	public void doA() {
		log.info("doA.............");
	}
	
	@GetMapping("/doB")
	//only login user can see 
	public void doB() {
		log.info("doB..............");
	}
}
