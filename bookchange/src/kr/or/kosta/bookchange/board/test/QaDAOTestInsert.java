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
		
		qa.setQaContent("너는 누구냐 오빠는 직거래만 하는데 괜찮니?");
		
		Member member=new Member();
		member.setEmail("hoihoi@nate.com");
		qa.setMember(member);
		
		Board board=new Board();
		board.setBoardNo(23);
		qa.setBoard(board);
		
		QaDAO.insertQa(qa);
	}

}
