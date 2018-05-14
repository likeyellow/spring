package org.zerock.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.zerock.mapper.GreetingService;

public class HelloApp {
	public static void main(String[] args)throws Exception{
		@SuppressWarnings("deprecation")
		BeanFactory factory =
				new XmlBeanFactory(new FileSystemResource("root-context.xml"));
		
		GreetingService greetingService =
				(GreetingService)factory.getBean("greetingService");
		
		greetingService.sayGreeting();
		
		
	}
}
