package kr.or.kosta.bookchange.change;

import java.util.List;

public interface IChangeDAO {

	void insertChange(Change change);

	void matchChange(Change change);

	void cancelChange(int demandBoardNo);

	void completeChange(int ChangeNo, int BoardNo);

	List<Change> selectChangeRequestList(int length, int page, String email);

	int selectChangeRequestCount(String email);

	List<Change> selectChangeMyboardList(int length, int page, String email);

	int selectChangeMyboardCount(String email);

	List<Change> selectMatchList(int length, int page, String email);

	int selectMatchListCount(String email);

	void deleteChange(int boardNo);

	List<Change> selectMatchResultList(int length, int page, String email);

	int selectMatchResultListCount(String email);

}
