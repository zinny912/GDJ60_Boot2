package com.iu.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.base.board.BoardFileVO;

@Component
public class FileManager extends AbstractView {
	
	@Value("${app.upload}")
	private String path;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		 BoardFileVO boardFileVO = (BoardFileVO)model.get("boardFileVO");
		 String board = (String)model.get("board");
		 File file = new File(path+board, boardFileVO.getFileName());
		 
		 //한글 처리
		 response.setCharacterEncoding("UTF-8");
		 
		 //총 파일의 크기
		 response.setContentLengthLong(file.length());
		 
		 //다운로드시 파일의 이름을 인코딩
		 String oriName = URLEncoder.encode(boardFileVO.getOriName(), "UTF-8");
		 
		 //header 설정
		 response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		 response.setHeader("Content-Transfer-Encoding", "binary");
		 
		 //HDD에서 파일을 읽고
		 FileInputStream fi = new FileInputStream(file);
		 //Client 로 전송 준비
		 OutputStream os = response.getOutputStream();
		 
		 //전송
		 FileCopyUtils.copy(fi, os);
		 
		 //자원 해제
		 os.close();
		 fi.close();
		
		
	}
		// TODO Auto-generated method stub
		
	
	//1. HDD에 파일을 저장하고 저장된 파일명을 리턴하는 메서드가 필요
	public String saveFile (String path, MultipartFile multipartFile) throws Exception {
		
		//1. File 객체 생성
		File file = new File(path);//저장할 폴더
		
		//파일이 없으면 파일을 만들라! 
		if(!file.exists()) {
			file.mkdirs();
		}
		
		
		//2. 저장할 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName= fileName+"_"+multipartFile.getOriginalFilename();
		
		//3. 경로명과 파일명의 정보를 가진 File 객체 생성 ()안에 file 대신 path를 써도 됨 
		file = new File(file, fileName);
		
		//4. 파일저장
		//1). FileCopyUtils.copy(multipartFile.getBytes(), file);
		//2).
			multipartFile.transferTo(file);
			
		return fileName;
	}
	

}
