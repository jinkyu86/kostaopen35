package kr.or.kosta.bookchange.board;

import java.util.List;

import kr.or.kosta.bookchange.member.Member;

public interface IBoardDAO {

	List<Board> selectBoardList(int length, int page);

	int selectBoardCount();

	List<Board> selectBoardListbyCategory(int length, int page,
			String categoryNo);

	int selectBoardCategoryCount(String categoryNo);

	List<Board> selectBoardListbyTitle(int length, int page, String title);

	int selectBoardTitleCount(String title);

	Board selectBoard(String boardNo);

	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(String boardNo);

	List<Board> selectBoardListbyEmail(int length, int page, String email);

	int selectBoardEmailCount(String email);

	List<Board> selectBoardListbyCategoryandTitle(int length, int page,
			String categoryNo, String title);

	int selectBoardCategoryandTitleCount(String categoryNo, String title);

	List<Board> selectBoardListbyCategoryandEmail(int length, int page,
			String categoryNo, String email);

	int selectBoardCategoryandEmailCount(String categoryNo, String email);

	List<Board> selectBoardListbyEmailWhenAdd(int length, int page, String email);

	int selectBoardEmailWhenAddCount(String email);

	Member viewMemberInfo(String email);

	void deleteBoardbyEmail(String email);

	List<Board> selectBoardListbyEmailWhenDelete(String email);

}
