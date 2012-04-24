package kr.or.kosta.auction.auction.test;

import java.util.List;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.auction.AuctionDAO;
import kr.or.kosta.auction.auction.IAuctionDAO;
import kr.or.kosta.auction.good.Good;


import org.junit.Test;

public class AuctionDAOTest {
	private IAuctionDAO auctionDAO;
	
	
	public AuctionDAOTest(IAuctionDAO auctionDAO) {
		super();
		this.auctionDAO = auctionDAO;
	}
	@Test
	public void selectAuctionTest() {
		Auction auction = auctionDAO.selectAuction("86");
		System.out.println(auction);
	}
	@Test
	public void testInsertAuction() {
		Auction auction = new Auction(); 
		Good good = new Good();
		
		good.setgNum("18");
		auction.setsTime("2012/03/28");
		auction.seteTime("2012/03/29");
		auction.setCuPrice("100");
		auction.setImPrice("1000");
		auction.setSold(1);
		auction.setsPrice("10");
		auction.setGood(good);
		
		
		auctionDAO.insertAuction(auction);
	}
	@Test
	public void testDeleteAuction(){
		
		auctionDAO.deleteAuction("172");
			
	}
	
	@Test
	public void TestselectAuctionList() {
		List<Auction> auctionList = auctionDAO.selectAuctionList();
		System.out.println("AuctionDAO:selectAuctionList:"+auctionList);
		//for(int i =0; i<auctionList.size();i++){
			//Auction auction = auctionList.get(i);
			//System.out.println(auction);
			
		}
	@Test
	public void TestselectAuctionSoldById(){
		List<Auction> auction = auctionDAO.selectAuctionSoldById("admin");
		System.out.println(auction);
	}
	@Test
	public void TestselectAuctionSoldList(){
		List<Auction> selectAuctionSoldList = auctionDAO.selectAuctionSoldList();
		System.out.println("AuctionDAO:selectAuctionSoldList:"+selectAuctionSoldList);
	}
	/* 
	@Test
	public void SelectSoldAuctionTest() {
		ArrayList<Auction> auctionList = AuctionDAO.selectSoldList();
		for(int i=0; i<auctionList.size();i++){
			Auction auction = auctionList.get(i);
			System.out.println(auction);
		}
	}
	@Test
	public void testSelectAuctionListIntInt() {
		ArrayList<Auction> page1List = AuctionDAO.selectAuctionList(3, 1);
		System.out.println("page1List:" + page1List);
		ArrayList<Auction> page2List = AuctionDAO.selectAuctionList(3, 2);
		System.out.println("page2List:" + page2List);
	}
	@Test
	public void testSelectSoldAuctionListIntInt() {
		ArrayList<Auction> page1List = AuctionDAO.selectSoldList(3, 1);
		System.out.println("page1List:" + page1List);
		ArrayList<Auction> page2List = AuctionDAO.selectSoldList(3, 2);
		System.out.println("page2List:" + page2List);
	}
	*/
	@Test
	public void testUpdateAuction(){
		Auction auction = new Auction();
		Good good = new Good();
	
		good.setgNum("17");
		auction.setaNum("172");
		auction.setsTime("2012/03/28");
		auction.seteTime("2012/03/29");
		auction.setCuPrice("100");
		auction.setImPrice("10000");
		auction.setSold(1);
		auction.setsPrice("10");
		auction.setsPrice("20");
		auction.setUserid("lee");
		
		auction.setGood(good);
		auctionDAO.updateAuction(auction);
	}
	
}
