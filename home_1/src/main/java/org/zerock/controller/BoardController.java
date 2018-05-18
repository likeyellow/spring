package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	//@Inject
	@Setter(onMethod_= {@Autowired})
	private BoardMapper mapper;
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(BoardVO vo, Model model)throws Exception{
		log.info("register get.........");
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	//public String registerPOST(BoardVO vo, Model model)throws Exception{
	public String registerPOST(BoardVO vo, RedirectAttributes rttr)throws Exception{
		log.info("register post.........");
		log.info(vo.toString());
		
		mapper.create(vo);
		
		//model.addAttribute("result", "success");
		
		rttr.addFlashAttribute("msg", "success");
		
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="listCri", method=RequestMethod.GET)
	public void listAll(Criteria cri, Model model)throws Exception{
		
		log.info("Show list Page with Criteria............");
		model.addAttribute("listall", mapper.listCriteria(cri));
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model)throws Exception{
		
		model.addAttribute(mapper.read(bno));
	}
	@RequestMapping(value="remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		
		mapper.delete(bno);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model)throws Exception{
		
		model.addAttribute(mapper.read(bno));
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo, RedirectAttributes rttr)throws Exception{
		
		log.info("mod post..........");
		
		mapper.update(vo);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listALL";
	}
	
	
	
	
}
