package org.zerock.mapper;

public class GreetingServiceImpl1 implements GreetingService {
	
	private String greeting;
	
	public GreetingServiceImpl1() {} //������
	
	public GreetingServiceImpl1(String greeting) {
		this.greeting = greeting;
	}
	
	// �������̽� GreetingService�� �޼ҵ��� sayGreeting�� ����
	public void sayGreeting() {
		System.out.println(greeting);
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
