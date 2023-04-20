package com.iu.base.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
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

	
	public int setJoin(MemberVO memberVO) throws Exception {
		RoleVO roleVO = memberDAO.setMemberRole(roleVO);
		
		int result = memberDAO.setJoin(memberVO);
		
		

		
		System.out.println(result);

		return result;
	}
}
