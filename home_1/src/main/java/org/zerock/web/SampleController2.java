package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;
@Log4j
@Controller
public class SampleController2 {
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) { // RedirectAttributes라는 클래스를 파라미터로 같이 사용하게 되면 리다이렉트 시점에 원하는 데이터를 임시로 추가해서 넘기는 작업이 가능
						// RedirectAttributes를 이용하는 경우 URI에 보이지 않게 데이터를 전달함
		log.info("doE called but redirect to /doF...............");
		
		rttr.addFlashAttribute("msg", "This is the Message!!! whith redirected");	//addFlashAttribute()는 임시데이터를 전달함
		return "redirect:/doF";
	}
	@RequestMapping("/doF")
	public void doF(@ModelAttribute String msg) { //"redirect:/doF" 문자열을 반환하기 때문에 스프링 MVC는 브라우저에 다시 '/doF'를 호출
		
		log.info("doF called.............." + msg);
	}
	
	
}
