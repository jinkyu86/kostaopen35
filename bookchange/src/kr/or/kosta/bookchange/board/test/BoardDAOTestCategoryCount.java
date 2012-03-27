package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.BoardDAO;

import org.junit.Test;

public class BoardDAOTestCategoryCount {

	@Test
	public void test() {
		int a=BoardDAO.selectBoardCategoryCount("4");
		System.out.println(a);
	}

}
