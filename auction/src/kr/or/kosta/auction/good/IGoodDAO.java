package kr.or.kosta.auction.good;

import java.util.List;

public interface IGoodDAO {

	String insertGood(Good good);

	void updateGood(Good good);

	void deleteGood(String gNum);

	Good selectGood(String gNum);

	List<Good> selectGoodList();

	List<Good> selectGoodList(int length, int page);

}
