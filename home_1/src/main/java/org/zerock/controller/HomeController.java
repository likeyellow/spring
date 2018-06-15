package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.util.UploadFileUtils;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void ajaxTest() {
		
	}
	
	@RequestMapping(value = "uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
			
	}
	
	@ResponseBody
	@RequestMapping(value = "uploadAjax", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		
		log.info("originalName: " + file.getOriginalFilename());
		log.info("size: " + file.getSize());
		log.info("contentType: " + file.getContentType());
		
	//	return new ResponseEntity<>(file.getOriginalFilename(), HttpStatus.CREATED); // HttpStatus.CREATED는 원하는 리소스가 정상적으로 생성되었다는 삳태 코드
																// HttpStatus.OK 도 가능
		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/doA", method = RequestMethod.GET)
	public String doA(Locale locale, Model model) {
		
		System.out.println("doA..............");
		
		return "home";
	}
	
	@RequestMapping(value= "/doB", method = RequestMethod.GET)
	public String doB(Locale locale, Model model) {
		
		System.out.println("doB................");
		
		model.addAttribute("result", "DOB RESULT");
		
		return "home";
	}
	
}
