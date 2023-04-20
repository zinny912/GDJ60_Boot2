package com.iu.base.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.base.board.BoardFileVO;
import com.iu.base.board.BoardService;
import com.iu.base.board.BoardVO;
import com.iu.base.util.FileManager;
import com.iu.base.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	//property key 는 EL 형식으로 
	@Value("${app.upload.notice}")
	private String path;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public BoardFileVO getFileDetail(BoardFileVO boardFileVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getFileDetail(boardFileVO);
	}
	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		
		return noticeDAO.getDetail(boardVO);
	}

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		
		pager.makeStartRow();
		pager.makeNum(noticeDAO.getTotalCount(pager));
		
		return noticeDAO.getList(pager);
	}

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] multipartFiles) throws Exception {
		
		int result =  noticeDAO.setInsert(boardVO);
		log.error("NUM =========>>>>> {}", boardVO.getNum());
		
		if(multipartFiles != null) {
			for(MultipartFile multipartFile: multipartFiles) {
				//multipartFile.isEmpty() = multipartFile.getSize() ==0
				if(!multipartFile.isEmpty()) {
					String fileName=fileManager.saveFile(path, multipartFile);
					BoardFileVO boardFileVO = new BoardFileVO();
					boardFileVO.setFileName(fileName);
					boardFileVO.setOriName(multipartFile.getOriginalFilename());
					boardFileVO.setNum(boardVO.getNum());
					
					result = noticeDAO.setFileInsert(boardFileVO);
					
				}
			}
		}
		
		//return noticeDAO.setInsert(boardVO);
		return 0;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
