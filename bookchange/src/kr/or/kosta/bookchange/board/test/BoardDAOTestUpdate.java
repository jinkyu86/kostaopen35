package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;
import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;
import kr.or.kosta.bookchange.board.Category;
import kr.or.kosta.bookchange.board.Deal;

import org.junit.Test;

public class BoardDAOTestUpdate {

	@Test
	public void testUpdateBoard() {
		Board board=new Board();
		
		board.setBoardContent("상태 아주 굿이에요 굿");
		board.setBoardWant("코스모폴리탄");
		board.setBoardPhoto("u.jpg");
		board.setBoardTitle("좋은 요리책입니다");
		board.setBoardNo(22);
		
		Category category=new Category();
		category.setCategoryNo(5);
		board.setCategory(category);
		
		Deal deal=new Deal();
		deal.setDealNo(0);
		board.setDeal(deal);		
		
		BoardDAO.updateBoard(board);
	}

}
