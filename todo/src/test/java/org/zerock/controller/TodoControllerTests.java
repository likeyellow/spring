package org.zerock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.TodoVO;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
@Log4j
public class TodoControllerTests {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext context;

	protected MockMvc mockMvc;

	@Before
	public void ready() {
		log.info("ready................");

		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

	}

	@Test
	public void testNew() throws Exception{

		TodoVO vo = new TodoVO();
		vo.setTitle("sample title" );
		vo.setContent("sample content");
		
		String jsonStr = new Gson().toJson(vo);

		log.info(jsonStr);

		mockMvc.perform(post("/todo/new").contentType(MediaType.APPLICATION_JSON).content(jsonStr))
				.andExpect(status().is(200));
	}
	
	@Test
	public void testRead()throws Exception {
		
		String result = mockMvc.perform(get("/todo/1.json").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is(200)).andReturn().getResponse().getContentAsString();
	
		log.info("result: " + result);
	
	}
	
	@Test
	public void testUpdate()throws Exception {
		
		TodoVO vo = new TodoVO();
		vo.setTitle("update2 title" );
		vo.setContent("update2 content");
		
		String jsonStr = new Gson().toJson(vo);
		
		String result = mockMvc.perform(put("/todo/1.json").contentType(MediaType.APPLICATION_JSON).content(jsonStr))
		.andExpect(status().is(200)).andReturn().getResponse().getContentAsString();
	
		log.info("result: " + result);
	
	}
	
	
	@Test
	public void testDelete()throws Exception {
		
		String result = mockMvc.perform(delete("/todo/1.json").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200)).andReturn().getResponse().getContentAsString();
			
		
		log.info("delete: " + result);
		
	}
}
