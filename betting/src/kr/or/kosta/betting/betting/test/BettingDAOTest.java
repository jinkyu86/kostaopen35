package kr.or.kosta.betting.betting.test;

import java.util.ArrayList;

import org.junit.Test;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.betting.BettingDAO;
import kr.or.kosta.betting.match.Match;
import kr.or.kosta.betting.util.now;


public class BettingDAOTest extends BettingDAO {


	@Test
	public void testInsertHomeBetting(){

		BettingDAO.insertHomeBetting("10012");
	}
	@Test
	public void testInsertAwayBetting() {

		BettingDAO.insertAwayBetting("10012");
	}
	@Test
	public void testSelectBettingList() {
		ArrayList<Betting> page1List = BettingDAO.selectBettingList(1, 5);
		System.out.println("page1List:" + page1List);
		ArrayList<Betting> page2List = BettingDAO.selectBettingList(2, 5);
		System.out.println("page2List:" + page2List);
	}
	@Test
	public void testSelectBettingListByDate(){
		String date = now.Date();
		ArrayList<Betting> bettingList = BettingDAO.selectBettingListByDate(date);
		for(int i=0;i<bettingList.size();i++){
			Betting betting = bettingList.get(i);
		  System.out.println(betting);
		}
	}
	@Test
	public void testSelectBettingRating(){
		double bettingRating = BettingDAO.selectBettingRating("5");
		System.out.println(bettingRating);
	}
	@Test
	public void testSelectBettingSeleRating(){
		long bettingSeleRating = BettingDAO.selectBettingSeleRating("5");
		System.out.println(bettingSeleRating);
	}
	@Test
	public void testSelectBettingTotMineral(){
		long bettingTotMineral = BettingDAO.selectBettingTotMineral("5");
		System.out.println(bettingTotMineral);
	}
	@Test
	public void testUpdateBetting(){
		Betting betting = new Betting();
		betting.setNum("3");
		betting.setSeleRating(1);
		betting.setTotMineral(1);
		betting.setBatRating(1);
		betting.setDistnum("1");

		Match match = new Match();
		match.setNum("10000");
					
		betting.setMatch(match);
		
		BettingDAO.updateBetting(betting);
	}
	@Test
	public void testSelectBettingListByHome(){
		Betting bettingHome = BettingDAO.selectBettingListByHome("10001");
		System.out.println(bettingHome);
		
	}
	@Test
	public void testSelectBettingListByAway(){
		Betting betting = BettingDAO.selectBettingListByAway("10001");
		System.out.println(betting);
		
	}
}
