package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.Qa;
import kr.or.kosta.bookchange.board.QaDAO;

import org.junit.Test;

public class QaDAOTestUpdate {

	@Test
	public void test() {
		Qa qa=new Qa();
		qa.setQaContent("13���� �ݿ����̴�!");
		qa.setQaNo(201);
		
		QaDAO.updateQa(qa);
	}

}
