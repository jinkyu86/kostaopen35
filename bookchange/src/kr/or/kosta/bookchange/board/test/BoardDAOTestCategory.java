package kr.or.kosta.bookchange.board.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.BoardDAO;

import org.junit.Test;

public class BoardDAOTestCategory {

	@Test
	public void test() {
		List<Board> board1List=BoardDAO.selectBoardListbyEmailWhenAdd(5, 1,"yoyo");
		System.out.println(board1List);
		List<Board> board2List=BoardDAO.selectBoardListbyEmailWhenAdd(5, 2,"yoyo");
		System.out.println(board2List);
	}

}
