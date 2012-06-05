package kr.or.kosta.auction.auction;

import java.util.List;

public interface IAuctionDAO {

	String insertAuction(Auction auction);

	void updateAuction(Auction auction);

	void deleteAuction(String aNum);

	Auction selectAuction(String aNum);

	List<Auction> selectAuctionList();

	List<Auction> selectAuctionSoldById(String s);

	List<Auction> selectAuctionSoldList();
	
}
