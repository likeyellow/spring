package org.zerock.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bbs")
@PreAuthorize("isAuthenticated()")
public class BoardController {
	
	@GetMapping("/doA")
	@PreAuthorize("permitAll")
	public String doA() {
		return "AAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	}
	
	@GetMapping("/doB")
	public String doB() {
		return "BBBBBBBBBBBBBBBBBBBBBBBBBBB";
	}

	@GetMapping("/doC")
	public String doC() {
		return "CCCCCCCCCCCCCCCCCCCCCCCCCCCC";
	}


}
