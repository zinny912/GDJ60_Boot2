package com.iu.base.member;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.iu.base.util.MailManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MailManager mailManager;
	
	
	//로그인 및 패스워드 비교 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.error("=================Spring Security Login ========================");
		log.error("==================> {} <==================", username);
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		
		try {
			memberVO=memberDAO.getLogin(memberVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberVO;
	}
	
	
	
	//패스워드 일치여부판단하는 검증 메서드 만들기
	//check=true: 에러있음! 검증실패 / check=false: 에러없음! 통과
	public boolean memberCheck(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check=false;
		
		//1.annotation 검증결과 
		check = bindingResult.hasErrors();
		
		//2.password가 일치하는지 검증하기 
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
			check=true;
			bindingResult.rejectValue("passwordCheck", "member.password.notEqual");
		
		}
		
		//3. ID중복 검사
		MemberVO result=memberDAO.idDuplicateCheck(memberVO);
		if(result !=null) {
			check=true;
			bindingResult.rejectValue("username", "member.id.duplicate");
		}
		 
		return check;
	}
	
	public int setJoin(MemberVO memberVO) throws Exception {
		//password 인코딩해서 다시 비밀번호 넣는 작업 
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		int result = memberDAO.setJoin(memberVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("username", memberVO.getUsername());
		map.put("num", 3);
		result=memberDAO.setMemberRole(map);

		return result;
	}
	
	//아이디 중복체크 
	public MemberVO idDuplicateCheck (MemberVO memberVO) throws Exception {
		return memberDAO.idDuplicateCheck(memberVO);
	}
	
	//로그인
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberDAO.getLogin(memberVO);
	}
	

	
	//로그아웃하면 로그아웃한 시간 기록되는 서비스
	public int setLastTime(MemberVO memberVO) throws Exception {
		
		return memberDAO.setLastTime(memberVO);
	}
	
	public int setNewPassword(MemberVO memberVO) throws Exception {
		
		log.error("여기까지 오니???????--------------------------->");
		
		String newPassword = UUID.randomUUID().toString().substring(0,6); // 무작위로 생성된 임시 비밀번호 6자리 생성하기
		
		mailManager.send(memberVO.getEmail(),"최강야구 팬페이지 임시 비밀번호 발송 이메일입니다." , newPassword);
		
		String encodedPassword = passwordEncoder.encode(newPassword); // 임시 비밀번호 암호화
		memberVO.setPassword(encodedPassword);
		
		log.error("왜 안돼?? -----------> {}",encodedPassword);
		int result = memberDAO.setNewPassword(memberVO);
		
		return result;
	}
	
	
//	public MemberVO getLogin(MemberVO memberVO)throws Exception{
//	 MemberVO result = memberDAO.getLogin(memberVO);
//	//result : ID와 일치하는 모든 정보 
//	
//	 //pw check
//	 if(result != null && memberVO.getPassword().equals(result.getPassword())) {
//		 memberVO.setPassword(null);
//		 memberVO.setRoleVOs(result.getRoleVOs());
//		 return memberVO;
//	 }else {
//		 return null;
//	 }

//return memberDAO.getLogin(memberVO);
//}
	
	
}
