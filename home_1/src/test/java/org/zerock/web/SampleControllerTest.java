package org.zerock.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
// location 속성 경로에 xml 파일을 이용해서 스프링이 로딩됨
public class SampleControllerTest {
	
	@Inject
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("setup.....");
	}
	@Test
	public void testDoA() throws Exception{
		//mockMvc.perform(MockMvcBuilders.get("/doA"));	// 에러가 나는 이유가 뭐지???
	}
}
