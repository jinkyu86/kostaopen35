package kr.or.kosta.betting.betting.test;

import java.util.ArrayList;

import org.junit.Test;

import kr.or.kosta.betting.betting.Betting;
import kr.or.kosta.betting.betting.BettingDAO;
import kr.or.kosta.betting.match.Match;


public class BettingDAOTest extends BettingDAO {


	@Test
	public void testInsertHomeBetting(){
		Betting betting = new Betting();
		
		Match match = new Match();
		match.setNum("10012");
	
		betting.setMatch(match);
		
		BettingDAO.insertHomeBetting(betting);
	}
	@Test
	public void testInsertAwayBetting() {
		Betting betting = new Betting();

		Match match = new Match();
		match.setNum("10012");
	
		betting.setMatch(match);
		
		BettingDAO.insertAwayBetting(betting);
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
		ArrayList<Betting> bettingList = BettingDAO.selectBettingListByDate("2012/03/18");
		for(int i=0;i<bettingList.size();i++){
			Betting betting = bettingList.get(i);
		  System.out.println(betting);
		}
	}
	@Test
	public void testSelectBettingRating(){
		long bettingRating = BettingDAO.selectBettingRating("5");
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
}
