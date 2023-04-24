package com.iu.base.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {
	
	private Long num;
	@NotBlank
	@Size(min=3,max=20)
	private String title;
	private String contents;
	@NotBlank(message="작성자는 필수라우")
	private String writer;
	private Date wdate;
	private Long click;
	
	private List<BoardFileVO> boardFileVOs;

}
