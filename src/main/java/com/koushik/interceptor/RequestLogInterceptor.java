package com.koushik.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestLogInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getRequestURI());
		System.out.println(handler);
		System.out.println("PreHandler() method called");
		
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
	//	return HandlerInterceptor.super.preHandle(request, response, handler);
		
		String clientId = "koushik";
		
		if("koushik".equals(clientId))
		{
			return true;
		}
		response.getWriter().print("Invalid Request");
		
		return false;
		
	}

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("PostHandler() method called");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
