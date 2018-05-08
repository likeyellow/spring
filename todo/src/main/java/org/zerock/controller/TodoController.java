package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.TodoVO;
import org.zerock.mapper.TodoMapper;

import lombok.extern.log4j.Log4j;

@CrossOrigin
@RestController
@RequestMapping("/todo/*")
@Log4j
public class TodoController {

	private TodoMapper mapper;

	public TodoController(TodoMapper mapper) {
		this.mapper = mapper;
	}

	@PostMapping("/new")
	public ResponseEntity<String> register(@RequestBody TodoVO vo) {

		mapper.create(vo);

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@GetMapping("/{tno}")
	public ResponseEntity<TodoVO> read(@PathVariable("tno") Integer tno) {

		return new ResponseEntity<TodoVO>(mapper.read(tno), HttpStatus.OK);
	}

	@DeleteMapping("/{tno}")
	public ResponseEntity<String> remove(@PathVariable("tno") Integer tno) {
		String msg = mapper.delete(tno) == 1 ? "success" : "fail";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@PutMapping("/{tno}")
	public ResponseEntity<String> update(@PathVariable("tno") Integer tno, @RequestBody TodoVO vo) {
		vo.setTno(tno);
		String msg = mapper.update(vo) == 1 ? "success" : "fail";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	@GetMapping("/list/{page}")
	public ResponseEntity<List<TodoVO>> list(Criteria cri){
		
		log.info("cri: " + cri);
		
		return new ResponseEntity<List<TodoVO>>(mapper.list(cri),HttpStatus.OK);
	}
	
}
