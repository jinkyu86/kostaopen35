package kr.or.kosta.bookchange.board;

import java.util.ArrayList;

public class BoardDAO {

	/**
	 * �Խù�����Ʈ ��ȸ
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList<Board> selectBoardList(int length, int page) {
		return null;
	}

	/**
	 * ��ü�Խù� �� ����
	 */
	public int selectBoardCount() {
		return 0;
	}

	/**
	 * ī�װ��� �Խù� ��ȸ
	 * 
	 * @param length
	 * @param page
	 * @param category
	 */
	public ArrayList<Board> selectBoardListbyCategory(int length, int page, String category) {
		return null;
	}

	/**
	 * ī�װ��� �Խù� �� ����
	 * 
	 * @param category
	 */
	public int selectBoardCategoryCount(String category) {
		return 0;
	}

	/**
	 * �������� �˻��� �Խù� ��ȸ
	 * 
	 * @param length
	 * @param page
	 * @param title
	 */
	public ArrayList<Board> selectBoardListbyTitle(int length, int page, String title) {
		return null;
	}

	/**
	 * �������� �˻���  �Խù� �� ����
	 * 
	 * @param title
	 */
	public int selectBoardTitleCount(String title) {
		return 0;
	}

	/**
	 * �Խù� ����
	 * 
	 * @param boardNo
	 */
	public Board selectBoard(String boardNo) {
		return null;
	}

	/**
	 * �Խù� �߰�(��ǰ ���)
	 * 
	 * @param board
	 */
	public void insertBoard(Board board) {

	}

	/**
	 * �Խù� ����
	 * 
	 * @param board
	 */
	public Board updateBoard(Board board) {
		return null;
	}

	/**
	 * �Խù� ����
	 * 
	 * @param boardNo
	 */
	public void deleteBoard(String boardNo) {
		
	}
}
