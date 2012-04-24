package kr.or.kosta.moviesystem.buy;

import java.util.List;

public interface IBuyDAO {

	void insertBuy(Buy buy);

	List<Buy> selectBuyList(String userid, int length, int page);

	int selectBuyCountByUerid(String userid);

	List<Buy> selectCancelableBuyList(String userid, int length, int page);

	int selectCancelableBuyListCount(String userid);

	List<Buy> selectCanceledBuyList(String userid, int length, int page);

	int selectCanceledBuyListCount(String userid);

	void cancelBuy(String buynum);

}
