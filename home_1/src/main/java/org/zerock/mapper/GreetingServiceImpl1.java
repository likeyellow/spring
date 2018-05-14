package org.zerock.mapper;

public class GreetingServiceImpl1 implements GreetingService {
	
	private String greeting;
	
	public GreetingServiceImpl1() {} //생성자
	
	public GreetingServiceImpl1(String greeting) {
		this.greeting = greeting;
	}
	
	// 인터페이스 GreetingService의 메소드인 sayGreeting을 구현
	public void sayGreeting() {
		System.out.println(greeting);
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
