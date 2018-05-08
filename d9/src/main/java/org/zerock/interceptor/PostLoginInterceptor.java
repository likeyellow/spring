package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class PostLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			
		Object loginResult = modelAndView.getModel().get("member");
		
		MemberVO vo = (MemberVO)loginResult;
		
		request.getSession().setAttribute("member", vo);
		
	}

}
