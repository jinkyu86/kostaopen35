package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.BoardDAO;

import org.junit.Test;

public class BoardDAOTestSelect {

	@Test
	public void test() {
		System.out.println(BoardDAO.selectBoard("1"));
	}

}
