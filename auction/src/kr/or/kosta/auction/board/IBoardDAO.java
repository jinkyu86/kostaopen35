package kr.or.kosta.auction.board;

import java.util.List;

public interface IBoardDAO {

	String insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(String boardno);

	Board selectBoard(String boardno);

	List<Board> selectBoardList();

	List<Board> selectBoardList(int page, int length);

	int selectBoardCount();

	int selectBoardListByTitleCount(String title);

	int selectBoardListByUseridCount(String userid);

	List<Board> selectBoardListByTitle(int page, int length, String title);

	List<Board> selectBoardListByUserid(int page, int length, String userid);

}
