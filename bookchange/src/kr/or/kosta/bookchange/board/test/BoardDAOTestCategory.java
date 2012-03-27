package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;

import org.junit.Test;

public class BoardDAOTestCategory {

	@Test
	public void test() {
		ArrayList<Board> board1List=BoardDAO.selectBoardListbyCategory(3, 1, "4");
		System.out.println(board1List);
		ArrayList<Board> board2List=BoardDAO.selectBoardListbyCategory(3, 1, "4");
		System.out.println(board2List);
	}

}
