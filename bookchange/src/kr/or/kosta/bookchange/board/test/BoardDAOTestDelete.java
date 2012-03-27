package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.BoardDAO;

import org.junit.Test;

public class BoardDAOTestDelete {

	@Test
	public void test() {
		BoardDAO.deleteBoard("22");
	}

}
