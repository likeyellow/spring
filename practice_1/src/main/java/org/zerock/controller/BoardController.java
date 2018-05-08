package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.util.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardController {

	@Setter(onMethod_= {@Autowired})
	BoardMapper mapper;

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list");
		
		model.addAttribute("list", mapper.list(cri));
	}

	@GetMapping("/register")
	public void register() {
		log.info("Get register");
	}

	@PostMapping("/register")
	public String register(BoardVO vo) {

		mapper.insert(vo);

		log.info("post register....");
		return "board/result";
	}
	@GetMapping("/delete")
	public String delete(Long bno) {
		
		mapper.delete(bno);
		
		return "board/result";
	}
	@GetMapping("/read")
	public void read(Long bno, Model model) {
		
		model.addAttribute("vo",mapper.read(bno));
		
	}
	
}
