package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
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
	
	
	@RequestMapping(value="register", method=RequestMethod.GET)
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
		return "redirect:/board/listCri";
	}
	
	@RequestMapping(value="listPage", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")Criteria cri, Model model)throws Exception{
		
		//log.info("Show list Page with Criteria............");
		log.info(cri.toString());
		
		model.addAttribute("listall", mapper.listCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(131);
		
		//pageMaker.setTotalCount(mapper.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
	@RequestMapping(value="listCri", method=RequestMethod.GET)
	public void listAll(@ModelAttribute("cri")Criteria cri, Model model)throws Exception{
		
		log.info("Show list Page with Criteria............");
		model.addAttribute("listall", mapper.listCriteria(cri));
		
		/*PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(131);
		
		//pageMaker.setTotalCount(mapper.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);*/
	}
	
	//@ModelAttribute("cri")Criteria cri,
	@RequestMapping(value="read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri")Criteria cri, Model model)throws Exception{
		
		model.addAttribute("bo",mapper.read(bno));
	}
	
	
	@RequestMapping(value="remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception{
		
		mapper.delete(bno);
		
		/*rttr.addFlashAttribute("msg", "SUCCESS");*/
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listCri";
	}
	
	@RequestMapping(value="modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		
		model.addAttribute("bo",mapper.read(bno));
	}
	
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo, Criteria cri, RedirectAttributes rttr)throws Exception{
		
		log.info("mod post..........");
		
		mapper.update(vo);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listCri";
	}
}
