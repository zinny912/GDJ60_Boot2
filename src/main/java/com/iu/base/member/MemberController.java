package com.iu.base.member;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
	private String adminKey;
	
	@GetMapping("delete")
	public String delete() throws Exception{
		MemberVO memberVO = (MemberVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//회원가입 방식을 구분해서 탈퇴 시켜줘야함 --> 컬럼 추가해야해... -> 방식 구분하는거는 Service에서 진행해도 무관
		this.kakaoDelete(memberVO);
		
		return "redirect:./logout";
		
	}
	
	private void kakaoDelete(MemberVO memberVO) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+adminKey);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("target_id_type", "user_id");
		params.add("target_id", memberVO.getAttribute().get("id").toString());
		
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(params,headers);
		
		String id=restTemplate.postForObject("https://kapi.kakao.com/v1/user/unlink", req, String.class);
		log.error("delete {} <-----------------",id);
	}
	
	
	
	@GetMapping("info")
	public void info(HttpSession session) {
		
		String pw = "111111";
		
		MemberVO memberVO = (MemberVO)memberService.loadUserByUsername("user");
		
		log.error("{} ::::::::", memberVO.getPassword());
		log.error("{} ::::::::", passwordEncoder.encode(pw));
		log.error("{}::::::::", memberVO.getPassword().equals(passwordEncoder.encode(pw)));
		
		boolean check = passwordEncoder.matches(pw, memberVO.getPassword());
		log.error("{} ::::::::", check);
		
		log.error("============Login Info===========");
		
		
//	SPRING_SECURITY_CONTEXT
//		
//	Enumeration<String> names =session.getAttributeNames();
//	while(names.hasMoreElements()) {
//		log.error("========================================>>>>>>>>>>>>>>>>>>>>>>>>>> {}", names.nextElement());
//	}
//		Object obj=session.getAttribute("SPRING_SECURITY_CONTEXT");
//		log.error("========================================>>>>>>>>>>>>>>>>>>>>>>>>>> {}", obj);
//		SecurityContextImpl contextImpl = (SecurityContextImpl)obj;
//		Authentication authentication= contextImpl.getAuthentication();
//		
//		log.error("========================================>>>>>>>>>>>>>>>>>>>>>>>>>> {}", obj);
//		log.error("=======================================USERNAME >>>> {}", authentication.getName());
//		log.error("=======================================DETAIL >>>> {}", authentication.getDetails());
//		log.error("=======================================MemberVO PRINCIPAL >>>> {}", authentication.getPrincipal());
//		
	}
	
	@GetMapping("admin")
	public void getAdmin () throws Exception {
		
	}
	
	@GetMapping("myPage")
	public void getMyPage () throws Exception {
		
	}
	
	@GetMapping("login")
	public ModelAndView getLogin(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Object obj=session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		if(obj ==null) {
			mv.setViewName("member/login");			
		}else {
			mv.setViewName("redirect:/");
		}
		
		return mv;
	}
	
//	@PostMapping("login")
//	public ModelAndView getLogin(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception {
//		
//		memberVO = memberService.getLogin(memberVO);
//		
//		mv.setViewName("redirect:./login");
//		
//		if(memberVO != null) {
//			session.setAttribute("member", memberVO);
//			mv.setViewName("redirect:../");
//		}
//
//		return mv;
//	}
	
//	@GetMapping("logout")
//	public ModelAndView getLogout(HttpSession session) throws Exception {
//		ModelAndView mv= new ModelAndView();
//		
//		MemberVO memberVO =(MemberVO)session.getAttribute("member");
//		int result=memberService.setLastTime(memberVO);
//		
//		session.invalidate();
		
//		mv.setViewName("redirect:/");
//		return mv;
//	}
	
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
		//memberVO.setEnabled(true);
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
	
	@GetMapping("findPassword")
	public ModelAndView setNewPassword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/findPassword");
		return mv;
	}
	
	@PostMapping("findPassword")
	public ModelAndView setNewPassword(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setNewPassword(memberVO);
		log.error("정답은???{}",result);
		
		if(result == 0) {
//			mailService.sendMail(memberVO);
			mv.setViewName("common/result");
			mv.addObject("message", "사용자가 없습니다.");
		}else {
			mv.setViewName("common/result");
			mv.addObject("message", "메일이 발송되었습니다.");
			mv.addObject("url", "./login");
		}
		return mv;
	}
	
	
}
