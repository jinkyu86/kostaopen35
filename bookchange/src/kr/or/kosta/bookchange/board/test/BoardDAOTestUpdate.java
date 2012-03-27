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
		
		board.setBoardContent("���� ���� ���̿��� ��");
		board.setBoardWant("�ڽ�������ź");
		board.setBoardPhoto("u.jpg");
		board.setBoardTitle("���� �丮å�Դϴ�");
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
