package com.iu.base.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.base.board.notice.NoticeDAO;
import com.iu.base.board.notice.NoticeService;
import com.iu.base.board.notice.NoticeVO;
import com.iu.base.member.MemberDAO;
import com.iu.base.member.MemberService;
import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSchedule {

	//private MemberService memberService;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private MailManager mailManager;
	
//	@Scheduled(cron = "*/10 * * * * *")
//	public void test() throws Exception {
//		
//		List<MemberVO> list = memberDAO.getMemberList();
//	
//		for(MemberVO memberVO:list) {
//		log.warn("====멤버리스트====== {}",memberVO.getUserName());
//		}
//	}
	//@Scheduled(cron ="0 0 * * * *")
	public void setEnabledMember()throws Exception {
		
		MemberVO memberVO=new MemberVO();
				memberDAO.setEnabledMember();
	}
	
	@Scheduled(cron ="*/5 * * * * *")
	public void getMemberBirthday()throws Exception {
		
		
	List<MemberVO>	ar =memberDAO.getMemberBirthday();
	
	StringBuffer sb = new StringBuffer();
	sb.append("오늘은 ");
	for(MemberVO members:ar) {
		sb.append(members.getName());
		sb.append(",");	
	}
	sb.append("의 생일 입니다. 금일봉 기대하세요~");
	
	NoticeVO noticeVO = new NoticeVO();
	
	noticeVO.setTitle("생축생축");
	noticeVO.setWriter("사장");
	
	int lastIndex = sb.lastIndexOf(",");
    if (lastIndex == sb.length() - 1) {
        sb.deleteCharAt(lastIndex); // 마지막 문자를 삭제하는 메소드인 deleteCharAt()을 사용합니다.
    }
    noticeVO.setContents(sb.toString());
	
	noticeDAO.setInsert(noticeVO);
			
	}
	
	//@Scheduled (cron="*/5 * * * * *")
	public void sendEmail() throws Exception {
		
		//1.메일 수신자를 설정하기
		MemberVO memberVO = new MemberVO();
				
		List<MemberVO> ar =memberDAO.getMemberBirthday();
			for(MemberVO email:ar) {
				email.getEmail();
				SimpleMailMessage message = new SimpleMailMessage();
//		        message.setFrom("xbigbang5@gmail.com");
		        message.setTo(email.getEmail());
		        message.setSubject(email.getName()+"생일을 축하합니다!! - 하영아카데미");
		        message.setText("생일축하축하");
		      //  javaMailSender.send(message);
				//log.error("이메일 나오니?================= {}",email.getEmail());
			};				
				
	}	
	@Scheduled(cron="*/5 * * * * *")
	public void sendMail()throws Exception {
		List<MemberVO> ar = memberDAO.getMemberBirthday();
		
		for(MemberVO memberVO: ar) {
			mailManager.send(memberVO.getEmail(), "생일축하2", "<h1>생일축하</h1>");
		}
	}
	
	
}
