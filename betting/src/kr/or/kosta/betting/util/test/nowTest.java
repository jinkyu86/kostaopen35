package kr.or.kosta.betting.util.test;

import kr.or.kosta.betting.util.now;

import org.junit.Test;

public class nowTest {

	@Test
	public void testDate() {
		String time = now.Date();
		System.out.println(time);
	}
	
	
	@Test
	public void testHourCheck(){
		int a = now.hourCheck("2012/04/04 22:00:00");
		System.out.println(a);
	}
}
