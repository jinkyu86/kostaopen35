package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.Qa;
import kr.or.kosta.bookchange.board.QaDAO;

import org.junit.Test;

public class QaDAOTestUpdate {

	@Test
	public void test() {
		Qa qa=new Qa();
		qa.setQaContent("���� �ƴ���?");
		qa.setQaNo(1);
		
		QaDAO.updateQa(qa);
	}

}
