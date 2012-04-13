package kr.or.kosta.moviesystem.screentime;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScreenTimeDAOTest {

	@Test
	public void testSelectScreenTimeBySrcNum() {

		ScreenTime screenTime=ScreenTimeDAO.selectScreenTimeBySrcNum("43");
		System.out.println("screenTime = "+screenTime);

	}

}
