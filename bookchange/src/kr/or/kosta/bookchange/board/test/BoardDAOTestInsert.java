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
		
		board.setBoardContent("테스트용 게시물");
		board.setBoardPhoto("u.jpg");
		board.setBoardTitle("슈퍼푸드로 만든 건강한 요리");
		board.setBoardWant("백과사전");
		
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
