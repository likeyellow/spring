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
	public String doE(RedirectAttributes rttr) { // RedirectAttributes��� Ŭ������ �Ķ���ͷ� ���� ����ϰ� �Ǹ� �����̷�Ʈ ������ ���ϴ� �����͸� �ӽ÷� �߰��ؼ� �ѱ�� �۾��� ����
						// RedirectAttributes�� �̿��ϴ� ��� URI�� ������ �ʰ� �����͸� ������
		log.info("doE called but redirect to /doF...............");
		
		rttr.addFlashAttribute("msg", "This is the Message!!! whith redirected");	//addFlashAttribute()�� �ӽõ����͸� ������
		return "redirect:/doF";
	}
	@RequestMapping("/doF")
	public void doF(@ModelAttribute String msg) { //"redirect:/doF" ���ڿ��� ��ȯ�ϱ� ������ ������ MVC�� �������� �ٽ� '/doF'�� ȣ��
		
		log.info("doF called.............." + msg);
	}
	
	
}
