package kr.or.kosta.auction.board;

import java.util.ArrayList;

public class BoardDAO {

	/**
	 * @param board
	 */
	public void insertBoard(Board board) {
		/* default generated stub */;
	}

	/**
	 * @param board
	 */
	public void updateBoard(Board board) {
		/* default generated stub */;
	}

	/**
	 * @param bNum
	 */
	public void deleteBoard(String bNum) {
		/* default generated stub */;
	}

	/**
	 * @param bNum
	 */
	public Board selectBoard(String bNum) {
		/* default generated stub */;
		return null;
	}

	public ArrayList<Board> selectBoardList() {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param length
	 * @param page
	 */
	public ArrayList<Board> selectBoardList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param length
	 * @param page
	 * @param title
	 */
	public ArrayList<Board> selectBoardListByTitle(int length, int page, String title) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param title
	 */
	public int selectBoardListByTitleCount(String title) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * @param length
	 * @param page
	 * @param name
	 */
	public ArrayList<Board> selectBoardListByName(int length, int page, String name) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param name
	 */
	public int selectBoardListByNameCount(String name) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * @param length
	 * @param page
	 * @param userid
	 */
	public ArrayList<Board> selectBoardListByUserid(int length, int page, String userid) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param userid
	 */
	public int selectBoardListByUseridCount(String userid) {
		/* default generated stub */;
		return 0;
	}
}
