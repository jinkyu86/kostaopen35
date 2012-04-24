package kr.or.kosta.betting.betting.test;

import java.util.List;

import org.junit.Test;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.betting.BettingDAO;
import kr.or.kosta.betting.betting.IBetting;

public class BettingDAOTest extends BettingDAO {
	
	private IBetting bettingDAO;
	

	public BettingDAOTest(IBetting bettingDAO) {
		super();
		this.bettingDAO = bettingDAO;
	}
	@Test
	public void testInsertHomeBetting(){

		bettingDAO.insertHomeBetting("10298");
	}
	@Test
	public void testInsertAwayBetting() {

		bettingDAO.insertAwayBetting("10298");
	}
	@Test
	public void testSelectBettingList() {
		List<Betting> page1List = bettingDAO.selectBettingList(1, 5);
		System.out.println("page1List:" + page1List);
		List<Betting> page2List = bettingDAO.selectBettingList(2, 5);
		System.out.println("page2List:" + page2List);
	}
//	@Test
//	public void testSelectBettingListByDate(){
//		String date = now.Date();
//		List<Betting> bettingList = BettingDAO.selectBettingListByDate(date);
//		for(int i=0;i<bettingList.size();i++){
//			Betting betting = bettingList.get(i);
//		  System.out.println(betting);
//		}
//	}
	@Test
	public void testSelectBettingRating(){
		double bettingRating = bettingDAO.selectBettingRating("5");
		System.out.println(bettingRating);
	}
	@Test
	public void testSelectBettingSeleRating(){
		long bettingSeleRating = bettingDAO.selectBettingSeleRating("5");
		System.out.println(bettingSeleRating);
	}
	@Test
	public void testSelectBettingTotMineral(){
		long bettingTotMineral = bettingDAO.selectBettingTotMineral("5");
		System.out.println(bettingTotMineral);
	}
	@Test
	public void testUpdateBetting(){
		Betting betting = new Betting();
		betting.setNum("364");
		betting.setSeleRating(3);
		betting.setTotMineral(200);
		betting.setBatRating(1.8);
		
		bettingDAO.updateBetting(betting);
	}
	@Test
	public void testSelectBettingByHome(){
		Betting bettingHome = bettingDAO.selectBettingByHome("10245");
		System.out.println(bettingHome);
		
	}
	@Test
	public void testSelectBettingByAway(){
		Betting betting = bettingDAO.selectBettingByAway("10001");
		System.out.println(betting);
		
	}
	
	@Test
	public void testSelectBettingCount(){
		int count = bettingDAO.selectBettingCount();
		System.out.println(count);
	}
}
