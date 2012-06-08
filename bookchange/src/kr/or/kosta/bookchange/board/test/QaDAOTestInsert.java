package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.Qa;
import kr.or.kosta.bookchange.board.QaDAO;
import kr.or.kosta.bookchange.member.Member;

import org.junit.Test;

public class QaDAOTestInsert {

	@Test
	public void testInsertQa() {
		Qa qa=new Qa();
		
		qa.setQaContent("���ŷ��� �ϴµ� ������?");
		
		Member member=new Member();
		member.setEmail("hoihoi@nate.com");
		qa.setMember(member);
		
		Board board=new Board();
		board.setBoardNo(20);
		qa.setBoard(board);
		
		QaDAO.insertQa(qa);
	}

}
