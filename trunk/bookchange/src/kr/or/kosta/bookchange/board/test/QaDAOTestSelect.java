package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.kosta.bookchange.board.Qa;
import kr.or.kosta.bookchange.board.QaDAO;

import org.junit.Test;

public class QaDAOTestSelect {

	@Test
	public void test() {
		List<Qa> qaList=QaDAO.selectQaList(5, 1, "20");
		System.out.println(qaList);
	}

}
