package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;

import org.junit.Test;

public class BoardDAOTestSelectList {

	@Test
	public void testSelectBoardList() {
		ArrayList<Board> board1List=BoardDAO.selectBoardList(5,1);
		System.out.println("boar1List:"+board1List);
		ArrayList<Board> board2List=BoardDAO.selectBoardList(5,2);
		System.out.println("board2List:"+board2List);
	}

}
