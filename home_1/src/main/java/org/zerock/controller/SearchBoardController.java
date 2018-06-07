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
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	
	//@Inject
		@Setter(onMethod_= {@Autowired})
		private BoardMapper mapper;
		
		@RequestMapping(value="list", method = RequestMethod.GET)
		public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
			
		log.info("리스트 로그입니다..." + cri.toString());
		
		//model.addAttribute("list", mapper.listCriteria(cri));
		
		model.addAttribute("list", mapper.listSearch(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		//pageMaker.setTotalCount(mapper.listCountCriteria(cri));
		
		pageMaker.setTotalCount(mapper.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		}
		
//-----------------------------------------------------------------------------------------------		
		
		@RequestMapping(value="read", method = RequestMethod.GET)
		public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		/*public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)throws Exception{*/
			model.addAttribute("bo",mapper.read(bno));
		}
		
		/*@RequestMapping(value="/read", method = RequestMethod.GET)
		public void read(@RequestParam("bno") int bno, Model model) throws Exception{
			
			model.addAttribute(mapper.read(bno));
		}*/
		
		@RequestMapping(value="remove", method = RequestMethod.POST)
		public String remove(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		/*public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception{*/
			
			mapper.delete(bno);
			
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());
			
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/sboard/list";
		}
		
		@RequestMapping(value="modify", method = RequestMethod.GET)
		public void modifyGET(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		/*public void modifyGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)throws Exception{*/
			model.addAttribute("bo", mapper.read(bno));
		}
		
		@RequestMapping(value ="modify", method = RequestMethod.POST)
		public String modifyPOST(BoardVO vo, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
			
			log.info(cri.toString());
			mapper.update(vo);
			
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getSearchType());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());
			
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			log.info(rttr.toString());
			
			return "redirect:/sboard/list";
		}
		@RequestMapping(value ="register", method = RequestMethod.GET)
		public void registGET()throws Exception{
			log.info("regist get ................");
		}
		
		@RequestMapping(value = "register", method = RequestMethod.POST)
		public String registPOST(BoardVO vo, RedirectAttributes rttr)throws Exception{
			log.info("regist post ...............");
			log.info(vo.toString());
			
			mapper.regist(vo);
			
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/sboard/list";
		}
}
