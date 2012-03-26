package kr.or.kosta.auction.bid;

import java.util.ArrayList;

import kr.or.kosta.auction.auction.Auction;

public class BidDAO {

	/**
	 * @param bid
	 */
	public void insertBid(Bid bid) {
		/* default generated stub */;
	}

	/**
	 * @param bid
	 */
	public void updateBid(Bid bid) {
		/* default generated stub */;
	}

	/**
	 * @param bidNum
	 */
	public void deleteBid(String bidNum) {
		/* default generated stub */;
	}

	/**
	 * @param bidNum
	 */
	public Bid selectBid(String bidNum) {
		/* default generated stub */;
		return null;
	}

	public ArrayList<Bid> selectBidList() {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param length
	 * @param page
	 */
	public ArrayList<Bid> selectBidList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param length
	 * @param page
	 * @param userid
	 */
	public ArrayList<Bid> selectBidListByID(int length, int page, String userid) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param bidNum
	 * @param size
	 */
	public ArrayList<Bid> selectBidListByBidNum(String bidNum, int size) {
		/* default generated stub */;
		return null;
	}
}
