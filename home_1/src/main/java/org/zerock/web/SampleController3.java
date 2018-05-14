package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController3 {

	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {	// 리턴 타입이 @ResponseBody 어노테이션임, 메소드의 실행 결과로 일반 객체를 리턴
		
		ProductVO vo = new ProductVO("샘플상품", 30000);
		
		return vo;
	}
}
