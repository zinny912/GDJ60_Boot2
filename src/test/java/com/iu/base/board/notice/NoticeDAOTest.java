package com.iu.base.board.notice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.base.board.BoardVO;

@SpringBootTest
public class NoticeDAOTest {
	
	@Autowired
	private NoticeDAO noticeDAO;

	//@Test
	void setInsertTest()throws Exception{
		for(int i=0;i<120;i++) {
		BoardVO boardVO = new NoticeVO();
		
		boardVO.setWriter("테테테"+i);
		boardVO.setTitle("인서트테스트"+i);
		boardVO.setContents("인서트 내용 테스트"+i);
		
		int result = noticeDAO.setInsert(boardVO);
		
		if(i%10==0) {
			Thread.sleep(500);
		}
	}
		System.out.println("종료");
	//	assertEquals(1, result);
	}
	
//	@Test
	void setUpdateTest() throws Exception{
		BoardVO boardVO = new NoticeVO();
		
		boardVO.setNum(2L);
		boardVO.setWriter("롸롸롸2");
		boardVO.setTitle("수정완료됐니?2");
		boardVO.setContents("업데이트 내용 테스트222");
		
		int result = noticeDAO.setUpdate(boardVO);
		assertEquals(1, result);
	}
//	@Test
	void setDeleteTest() throws Exception {
		
		BoardVO boardVO = new NoticeVO();
		
		boardVO.setNum(3L);
		
		int result = noticeDAO.setDelete(boardVO);
		assertEquals(1, result);
		
	}
	
	
}
