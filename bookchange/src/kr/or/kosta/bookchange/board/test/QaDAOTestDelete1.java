package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.QaDAO;

import org.junit.Test;

public class QaDAOTestDelete1 {

	@Test
	public void test() {
		QaDAO.deleteQabyQaNo("2");
	}

}
