package com.iu.base.board;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {
	
	private Long num;
	private String title;
	private String contents;
	private String writer;
	private Date wdate;
	private Long click;
	
	private List<BoardFileVO> boardFileVOs;

}
