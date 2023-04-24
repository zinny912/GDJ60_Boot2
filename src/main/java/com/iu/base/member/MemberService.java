package com.iu.base.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int setJoin(MemberVO memberVO) throws Exception {
		
		int result = memberDAO.setJoin(memberVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("userName", memberVO.getUserName());
		map.put("num", 3);
		result=memberDAO.setMemberRole(map);

		return result;
	}
	
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

}
