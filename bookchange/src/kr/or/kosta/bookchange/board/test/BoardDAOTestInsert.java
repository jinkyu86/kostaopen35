package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;
import kr.or.kosta.bookchange.board.Category;
import kr.or.kosta.bookchange.board.Deal;
import kr.or.kosta.bookchange.member.Member;

import org.junit.Test;

public class BoardDAOTestInsert {

	@Test
	public void testInsertBoard() {
		Board board=new Board();
		
		board.setBoardContent("�׽�Ʈ�� �Խù�");
		board.setBoardPhoto("u.jpg");
		board.setBoardTitle("����Ǫ��� ���� �ǰ��� �丮");
		board.setBoardWant("�������");
		
		Category category=new Category();
		category.setCategoryNo(5);
		board.setCategory(category);
		
		Member member=new Member();
		member.setEmail("shego@naver.com");
		board.setMember(member);
		
		Deal deal=new Deal();
		deal.setDealNo(0);
		board.setDeal(deal);
		
		BoardDAO.insertBoard(board);
	}

}
