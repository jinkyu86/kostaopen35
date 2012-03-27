package kr.or.kosta.bookchange.board;

import java.util.ArrayList;

public class BoardDAO {

	/**
	 * 게시물리스트 조회
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList<Board> selectBoardList(int length, int page) {
		return null;
	}

	/**
	 * 전체게시물 수 리턴
	 */
	public int selectBoardCount() {
		return 0;
	}

	/**
	 * 카테고리별 게시물 조회
	 * 
	 * @param length
	 * @param page
	 * @param category
	 */
	public ArrayList<Board> selectBoardListbyCategory(int length, int page, String category) {
		return null;
	}

	/**
	 * 카테고리별 게시물 수 리턴
	 * 
	 * @param category
	 */
	public int selectBoardCategoryCount(String category) {
		return 0;
	}

	/**
	 * 제목으로 검색한 게시물 조회
	 * 
	 * @param length
	 * @param page
	 * @param title
	 */
	public ArrayList<Board> selectBoardListbyTitle(int length, int page, String title) {
		return null;
	}

	/**
	 * 제목으로 검색한  게시물 수 리턴
	 * 
	 * @param title
	 */
	public int selectBoardTitleCount(String title) {
		return 0;
	}

	/**
	 * 게시물 보기
	 * 
	 * @param boardNo
	 */
	public Board selectBoard(String boardNo) {
		return null;
	}

	/**
	 * 게시물 추가(물품 등록)
	 * 
	 * @param board
	 */
	public void insertBoard(Board board) {

	}

	/**
	 * 게시물 수정
	 * 
	 * @param board
	 */
	public Board updateBoard(Board board) {
		return null;
	}

	/**
	 * 게시물 삭제
	 * 
	 * @param boardNo
	 */
	public void deleteBoard(String boardNo) {
		
	}
}
