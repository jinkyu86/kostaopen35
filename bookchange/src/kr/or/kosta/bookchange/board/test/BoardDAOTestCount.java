package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.BoardDAO;

import org.junit.Test;

public class BoardDAOTestCount {

	@Test
	public void test() {
		int a=BoardDAO.selectBoardCount();
		System.out.println(a);
	}

}
