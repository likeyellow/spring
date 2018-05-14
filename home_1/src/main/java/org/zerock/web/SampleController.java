package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO;

import lombok.extern.log4j.Log4j;
@Log4j
@Controller
public class SampleController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("/doA")
	public void doA() {
		
		logger.info("doA called.................");
		log.info("Log4j  : doA ...............");
	}
	@RequestMapping("/doB")
	public void doB() {
		
		logger.info("doB called.................");
		log.info("Log4j  : doB ...............");
		
	}
	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg) {
		// 만일 컨트롤러에서 메소드의 리턴 타입이 문자열인 경우라면 결과는 
		// '문자열 + jsp' 파일을 찾아서 실행하게 됨
		
		logger.info("랄라라라라라~~~~ doC called..........................");
		log.info("랄라라라~~~~~" );
		return "result";
	}
	
	@RequestMapping("/doD")
	public String doD(Model model) {  // 모델이라는 클래스를 파라메터로 사용함, 스프링 MVC에서 기본적으로 제공되는 클래스임, 용도는 뷰에 원하는 데이터를 전달하는 일종의 컨테이너나 상자의 역할
		
		
		//make smaple data
		ProductVO product = new ProductVO("Sample Product", 10000);
		// product 객체를 생성해서 이 객체를 Model 이라는 객체를 이용해서 필요한 데이터를 담은 후 뷰(jsp)로 전달
		
		log.info("doD");
		
		model.addAttribute(product);	// addAttribute()라는 메소드를 이용해서 ProductVO 객체를 보관
		//addAttribute(객체) : 이름을 지정하지 않는 경우에는 자동으로 저장되는 객체의 클래스명 앞 글자를 소문자로 처리한 클래스명을 이름으로 간주
		// (이 코드에선) 뷰(jsp)에서의 이름은 productVO
		
		return "productDetail";
		
		
		
	}
}
