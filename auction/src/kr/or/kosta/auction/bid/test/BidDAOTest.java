package kr.or.kosta.auction.bid.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.bid.BidDAO;

import org.junit.Test;

public class BidDAOTest {

	@Test
	public void testInsertBid() {
		System.out.println(BidDAO.selectBid("1"));
		BidDAO.insertBid(BidDAO.selectBid("1"));
		System.out.println(BidDAO.selectBid("1"));
	}

	@Test
	public void testUpdateBid() {
		Bid bid=BidDAO.selectBid("1");
		bid.setBidPrice("100");
		
		BidDAO.updateBid(bid);
	}

	@Test
	public void testDeleteBid() {
		BidDAO.deleteBidById("jung");
	}

	@Test
	public void testSelectBid() {
		System.out.println(BidDAO.selectBid("1"));
	}

	@Test
	public void testSelectBidList() {
		ArrayList<Bid> bidList=BidDAO.selectBidList();
		for(int i=0;i<bidList.size();i++) System.out.println(bidList.get(i));
	}

	@Test
	public void testSelectBidListIntInt() {
		ArrayList<Bid> page1List=BidDAO.selectBidList(1,1);
		System.out.println("page1List:"+page1List);
		ArrayList<Bid> page2List=BidDAO.selectBidList(1,2);
		System.out.println("page2List:"+page2List);
	}

	@Test
	public void testSelectBidListByID() {
		ArrayList<Bid> page1List=BidDAO.selectBidListByID(5,1,"lee");
		System.out.println("page1List:"+page1List);
	}

	@Test
	public void testSelectBidListByBidNum() {
		ArrayList<Bid> page1List=BidDAO.selectBidListByAuctionNum("1",5);
		System.out.println("page1List:"+page1List);
	}

}
