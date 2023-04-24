package com.iu.base.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.notice.NoticeDAO;
import com.iu.base.board.qna.QnaDAO;

public class EncodingInterceptor implements HandlerInterceptor {
	
	
	// interceptor를 사용하고자 했을 때 너무 복잡해진다 그러면 그냥 개별적으로 각각 처리하기
//	@Autowired
//	private QnaDAO qnaDAO;
//	
//	@Autowired
//	private NoticeDAO noticeDAO;
//	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 1. method 검증하기 
		
		
	}

}
