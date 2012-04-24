package kr.or.kosta.betting.match;

import java.util.List;

public interface IMatch {

	List<Match> selectMatchList(int page, int length);

	List<Match> selectMatchByDate(String date);

	Match selectMatch(String num);

	void updateMatch(Match match);

	void insertMatch(Match match);

	int selectMatchCount();

	void deleteMatch(String matchNum);

	String selectMatchTime(String matchNum);

}
