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
		// ���� ��Ʈ�ѷ����� �޼ҵ��� ���� Ÿ���� ���ڿ��� ����� ����� 
		// '���ڿ� + jsp' ������ ã�Ƽ� �����ϰ� ��
		
		logger.info("��������~~~~ doC called..........................");
		log.info("������~~~~~" );
		return "result";
	}
	
	@RequestMapping("/doD")
	public String doD(Model model) {  // ���̶�� Ŭ������ �Ķ���ͷ� �����, ������ MVC���� �⺻������ �����Ǵ� Ŭ������, �뵵�� �信 ���ϴ� �����͸� �����ϴ� ������ �����̳ʳ� ������ ����
		
		
		//make smaple data
		ProductVO product = new ProductVO("Sample Product", 10000);
		// product ��ü�� �����ؼ� �� ��ü�� Model �̶�� ��ü�� �̿��ؼ� �ʿ��� �����͸� ���� �� ��(jsp)�� ����
		
		log.info("doD");
		
		model.addAttribute(product);	// addAttribute()��� �޼ҵ带 �̿��ؼ� ProductVO ��ü�� ����
		//addAttribute(��ü) : �̸��� �������� �ʴ� ��쿡�� �ڵ����� ����Ǵ� ��ü�� Ŭ������ �� ���ڸ� �ҹ��ڷ� ó���� Ŭ�������� �̸����� ����
		// (�� �ڵ忡��) ��(jsp)������ �̸��� productVO
		
		return "productDetail";
		
		
		
	}
}
