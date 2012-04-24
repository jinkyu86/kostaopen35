package kr.or.kosta.auction.bid;

import java.util.List;

public interface IBidDAO {

	void insertBid(Bid bid);

	void updateBid(Bid bid);

	Bid selectBid(String bidNum);

	List<Bid> selectBidList();

	List<Bid> selectBidList(int length, int page);

	List<Bid> selectBidListByID(int length, int page, String userid);

	List<Bid> selectBidListByAuctionNum(String aNum, int size);

	void deleteBidById(String userid);

	void updateMoneybackById(String userid);

	void updateMoneybackByIdInAuction(String userid, String aNum);

	int selectMoneybackByIdCount(String userid);

}
