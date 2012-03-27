package kr.or.kosta.auction.board.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.auction.board.Board;
import kr.or.kosta.auction.board.BoardDAO;
import kr.or.kosta.auction.member.Member;

import org.junit.Test;

public class BoardDAOTest {
	
	@Test
	public void testInsertBoard(){
		
		Board board = new Board();
		board.setTitle("������");
		board.setContent("�� ����Ʈ ������� ���׿�~~");
		
		Member member = new Member();
		member.setUserid("park");
		board.setMember(member);
		
		BoardDAO.insertBoard(board);	
	}
	
	@Test
	public void testUpdateStudent(){

		Board board = new Board();
		board.setTitle("����~!");
		board.setContent("�� ����Ʈ ������ ���� �ֿ��Ҳ���^^");
		board.setbNum("22");
		
		BoardDAO.updateBoard(board);
	}
	
	@Test
	public void deleteStudent(){
		Board board = new Board();
		board.setbNum("23");
		
		BoardDAO.deleteBoard("23");
	}

	@Test
	public void testselectBoard() {
		Board board = BoardDAO.selectBoard("2");
		System.out.println(board);
	}
	
	@Test
	public void testSelectBoardList() {
		ArrayList<Board> boardList = BoardDAO.selectBoardList();
		for (int i = 0; i < boardList.size(); i++) {
			Board board = boardList.get(i);
			System.out.println(board);
		}
	}
}
