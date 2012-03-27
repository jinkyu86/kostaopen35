package kr.or.kosta.auction.auction.test;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.auction.AuctionDAO;

import org.junit.Test;

public class AuctionDAOTest {

	@Test
	public void selectAuctionTest() {
		Auction auction = AuctionDAO.selectAuction("1");
		System.out.println(auction);
	}

}
