package kr.or.kosta.moviesystem.good;

import java.util.List;

public interface IGoodDAO {

	String insertGood(Good good);

	void editGood(Good good);

	void deleteGood(String gnum);

	Good selectGood(String gnum);

	List<Good> selectGoodList(int length, int page);

	int selectGoodListCount();

	List<Good> selectGoodListByName(int length, int page, String gname);

	int selectGoodListByNameCount(String gname);

}
