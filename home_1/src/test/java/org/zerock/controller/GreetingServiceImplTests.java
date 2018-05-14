package org.zerock.controller;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.zerock.mapper.GreetingService;
import org.zerock.mapper.GreetingServiceImpl1;

import lombok.extern.log4j.Log4j;

@Log4j
public class GreetingServiceImplTests {

	@Autowired
	private GreetingServiceImpl1 greetingService;
	
	@Test
	public void testGreeting() {
		
		greetingService = new GreetingServiceImpl1();
		greetingService.setGreeting("¾È³ç");
		
		log.info("----------------");
		
		log.info(greetingService);	
	}
	
	@Test
	public void testGreetingClass() {
		
		@SuppressWarnings("deprecation")
		BeanFactory factory =
				new XmlBeanFactory(new FileSystemResource("root-context.xml"));
		
		GreetingService greetingService =
				(GreetingService)factory.getBean("greetingService");
		
		greetingService.sayGreeting();
		
		log.info(greetingService);
	}
	
}
