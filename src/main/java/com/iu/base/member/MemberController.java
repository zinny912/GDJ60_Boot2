package com.iu.base.member;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("admin")
	public void getAdmin () throws Exception {
		
	}
	
	@GetMapping("myPage")
	public void getMyPage () throws Exception {
		
	}
	
	@GetMapping("login")
	public ModelAndView getLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception {
		
		memberVO = memberService.getLogin(memberVO);
		
		mv.setViewName("redirect:./login");
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}

		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView getLogout(HttpSession session) throws Exception {
		ModelAndView mv= new ModelAndView();
		
		MemberVO memberVO =(MemberVO)session.getAttribute("member");
		int result=memberService.setLastTime(memberVO);
		
		session.invalidate();
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("idDuplicateCheck")
	@ResponseBody
	public boolean idDuplicateCheck(MemberVO memberVO) throws Exception {
		log.debug("================= ID 중복 체크 ===================");
		boolean check=false;
		
		memberVO = memberService.idDuplicateCheck(memberVO);
		
		if(memberVO !=null) {
			check = true;
		}
//		memberVO.setEmail("test@email.com");
//		List<MemberVO> ar = new ArrayList<>();
//		ar.add(memberVO);
//		memberVO = new MemberVO();
//		memberVO.setUserName("testUser");
//		memberVO.setEmail("user@google.com");
//		ar.add(memberVO);
		return check;
	}
	
	@GetMapping("join")
	public ModelAndView setJoin() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		
		
		mv.addObject(new MemberVO());
		mv.setViewName("member/join");
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView setJoin(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception {
		memberVO.setEnabled(true);
		ModelAndView mv = new ModelAndView();
		
		boolean check=memberService.memberCheck(memberVO, bindingResult);
		if(check) {
			mv.setViewName("member/join");
			return mv;
		}
		
		int result = memberService.setJoin(memberVO);
		
		mv.setViewName("redirect:../");
		mv.addObject("member", result);
		return mv;
		
	}
	
	
}
