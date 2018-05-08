package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;
/**
 * 
 * @author 5CLASS-184
 *
 */
@Log4j
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result = false;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member")!= null) {
			result = true;
			session.removeAttribute("memeber");
		}else {
			response.sendRedirect("/login");
		}
		
		log.info("check login user: " + result);
		
		return result;
	}

}
