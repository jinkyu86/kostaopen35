package kr.or.kosta.auction.bid.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.bid.Bid;
import kr.or.kosta.auction.bid.BidDAO;
import kr.or.kosta.auction.member.Member;

import org.junit.Test;

public class BidDAOTest {

	@Test
	public void testInsertBid() {
		Bid bid=new Bid();
		Auction auction=new Auction();
		Member member=new Member();
		auction.setaNum("2");
		member.setUserid("lee");
		bid.setBidPrice("150");
		bid.setMember(member);
		bid.setAuction(auction);
		BidDAO.insertBid(bid);
	}

	@Test
	public void testUpdateBid() {
		Bid bid=BidDAO.selectBid("1");
		bid.setBidPrice("200");
		
		BidDAO.updateBid(bid);
	}
	
	@Test
	public void testDeleteBid() {
		BidDAO.deleteBidById("kook");
	}

	@Test
	public void testSelectBid() {
		System.out.println(BidDAO.selectBid("1"));
		
	}

	@Test
	public void testSelectBidList() {
		List<Bid> bidList=BidDAO.selectBidList();
		for(int i=0;i<bidList.size();i++) System.out.println(bidList.get(i));
	}
	
	@Test
	public void testSelectBidListByAuctionNum() {
		List<Bid> bidList=BidDAO.selectBidListByAuctionNum("2",5);
		for(int i=0;i<bidList.size();i++) System.out.println(bidList.get(i));
	}
	@Test
	public void testSelectBidListIntInt() {
		List<Bid> page1List=BidDAO.selectBidList(5,1);
		System.out.println("page1List:"+page1List);
		List<Bid> page2List=BidDAO.selectBidList(5,2);
		System.out.println("page2List:"+page2List);
	}

	@Test
	public void testSelectBidListByID() {
		List<Bid> page1List=BidDAO.selectBidListByID(5,1,"lee");
		System.out.println("page1List:"+page1List);
	}

	@Test
	public void testSelectBidListByBidNum() {
		List<Bid> page1List=BidDAO.selectBidListByAuctionNum("1",5);
		System.out.println("page1List:"+page1List);
	}

	@Test
	public void selectMoneybackByIdCount() {
		System.out.println(BidDAO.selectMoneybackByIdCount("jung"));
	}

	@Test
	public void testSelectMoneybackByIdCount() {
		int count=BidDAO.selectMoneybackByIdCount("lee");
		System.out.println(count);
	}

	@Test
	public void testUpdateMoneybackById() {
		BidDAO.updateMoneybackById("lee");
	}
	
	@Test
	public void testUpdateMoneybackByIdInAuction() {
		BidDAO.updateMoneybackByIdInAuction("lee","5");
	}
}
