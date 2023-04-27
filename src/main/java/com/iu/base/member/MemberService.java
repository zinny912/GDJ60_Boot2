package com.iu.base.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
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
			bindingResult.rejectValue("userName", "member.id.duplicate");
		}
		 
		return check;
	}
	
	public int setJoin(MemberVO memberVO) throws Exception {
		
		int result = memberDAO.setJoin(memberVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("userName", memberVO.getUserName());
		map.put("num", 3);
		result=memberDAO.setMemberRole(map);

		return result;
	}
	
	//아이디 중복체크 
	public MemberVO idDuplicateCheck (MemberVO memberVO) throws Exception {
		return memberDAO.idDuplicateCheck(memberVO);
	}
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
	
//		 MemberVO result = memberDAO.getLogin(memberVO);
//		//result : ID와 일치하는 모든 정보 
//		
//		 //pw check
//		 if(result != null && memberVO.getPassword().equals(result.getPassword())) {
//			 memberVO.setPassword(null);
//			 memberVO.setRoleVOs(result.getRoleVOs());
//			 return memberVO;
//		 }else {
//			 return null;
//		 }
	return memberDAO.getLogin(memberVO);
	}
	
	//로그아웃하면 로그아웃한 시간 기록되는 서비스
	public int setLastTime(MemberVO memberVO) throws Exception {
		
		return memberDAO.setLastTime(memberVO);
	}
	
	
	
	
}
