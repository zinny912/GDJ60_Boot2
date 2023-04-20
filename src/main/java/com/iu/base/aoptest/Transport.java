package com.iu.base.aoptest;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.iu.base.board.BoardFileVO;
import com.iu.base.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Transport {
	
	public int useSubway(BoardFileVO boardFileVO) throws Exception {
//		Random random = new Random();
//		int num = random.nextInt(2);
//		if(num==0) {
//			throw new Exception();
//		}
		log.error("지하철이용");
		return 5;
	}

	public String useBus(Pager pager) {
		log.error("버스 이용");
		return "BUS";
				
	}
	
	public void takeWalk() {
		log.error("당당하게 걷기~");
	}
}
