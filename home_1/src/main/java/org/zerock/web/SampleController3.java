package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController3 {

	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {	// ���� Ÿ���� @ResponseBody ������̼���, �޼ҵ��� ���� ����� �Ϲ� ��ü�� ����
		
		ProductVO vo = new ProductVO("���û�ǰ", 30000);
		
		return vo;
	}
}
