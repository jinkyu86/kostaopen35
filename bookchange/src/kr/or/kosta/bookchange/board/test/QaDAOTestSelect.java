package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.Qa;
import kr.or.kosta.bookchange.board.QaDAO;

import org.junit.Test;

public class QaDAOTestSelect {

	@Test
	public void test() {
		Qa qa=QaDAO.selectQa("17");
		System.out.println(qa);
	}

}
