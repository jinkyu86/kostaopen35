package kr.or.kosta.betting.betting;

import java.util.List;

public interface IBetting {

	List<Betting> selectBettingList(int page, int length);

	Betting selectBettingByHome(String matchNum);

	Betting selectBettingByAway(String matchNum);

	void updateBetting(Betting betting);

	double selectBettingRating(String bettingNum);

	long selectBettingSeleRating(String bettingNum);

	long selectBettingTotMineral(String bettingNum);

	void insertHomeBetting(String matchNum);

	void insertAwayBetting(String matchNum);

	int selectBettingCount();

}
