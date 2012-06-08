package kr.or.kosta.bookchange.board;

import java.util.List;

public interface IQaDAO {

	List<Qa> selectQaList(int length, int page, String boardNo);

	void insertQa(Qa qa);

	void updateQa(Qa qa);

	void deleteQabyQaNo(String qaNo);

	void deleteQabyBoardNo(String boardNo);

	int selectQaCount(String boardNo);

}
