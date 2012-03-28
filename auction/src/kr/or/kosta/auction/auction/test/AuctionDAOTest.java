package kr.or.kosta.auction.auction.test;

import java.util.ArrayList;

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.auction.AuctionDAO;
import kr.or.kosta.auction.good.Good;


import org.junit.Test;

public class AuctionDAOTest {

	@Test
	public void selectAuctionTest() {
		Auction auction = AuctionDAO.selectAuction("3");
		System.out.println(auction);
	}
	@Test
	public void selectAuctionTest2() {
		AuctionDAO auctiondao = new AuctionDAO();
		ArrayList<Auction> auctionList = new ArrayList<Auction>();
		
		auctionList = auctiondao.selectAuctionList();
		
		for(int i =0; i<auctionList.size();i++){
			Auction auction = auctionList.get(i);
			System.out.println(auction);
			
		}
	}
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
		ArrayList<Auction> page1List = AuctionDAO.selectSoldList(1, 1);
		System.out.println("page1List:" + page1List);
		ArrayList<Auction> page2List = AuctionDAO.selectSoldList(1, 1);
		System.out.println("page2List:" + page2List);
	}
	@Test
	public void testInsertAuction() {
		Auction auction = AuctionDAO.selectAuction("1"); 
		
		try {
			AuctionDAO.insertAuction(auction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdateAuction(){
		Auction auction = new Auction();
		
		Good good = new Good();
		good.setgNum("5");
		auction.setsPrice("10");
		auction.setImPrice("1500");
		auction.setSold(false);
		auction.setCuPrice("400");
		auction.setaNum("3");
		
		auction.setGood(good);
		
		AuctionDAO.updateAuction(auction);
	}
	@Test
	public void testDeleteAuction(){
		
		AuctionDAO.deleteAuction("10");
			
	}
}
