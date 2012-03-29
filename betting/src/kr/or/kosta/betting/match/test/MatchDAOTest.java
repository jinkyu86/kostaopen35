package kr.or.kosta.betting.match.test;

import java.util.ArrayList;

import kr.or.kosta.betting.loc.Loc;
import kr.or.kosta.betting.match.Match;
import kr.or.kosta.betting.match.MatchDAO;
import kr.or.kosta.betting.team.Team;


import org.junit.Test;

public class MatchDAOTest {

	@Test
	public void testSelectMatchList() {
		ArrayList<Match> page1List = MatchDAO.selectMatchList(5, 1);
		System.out.println("page1List:" + page1List);
		ArrayList<Match> page2List = MatchDAO.selectMatchList(5, 2);
		System.out.println("page2List:" + page2List);

	}
	@Test
	public void testSelectMatchByDate() {
		ArrayList<Match> matchList = MatchDAO.selectMatchByDate("2012/03/28");
		for(int i=0;i<matchList.size();i++){
			Match match = matchList.get(i);
			System.out.println(match);
		}
	}
	
	@Test
	public void testInsertMatch() {
		Match match = new Match();
		match.setMatchTime("2012/04/01");
		match.setScore("null");
		
		Team hTeam = new Team();
		hTeam.setNum("1");
		
		Team aTeam = new Team();
		aTeam.setNum("2");
		
		Team wTeam = new Team();
		wTeam.setNum("1");
		
		Loc loc = new Loc();
		loc.setNum("11");
		
		match.setHomeTeam(hTeam);
		match.setAwayTeam(aTeam);
		match.setWinTeam(wTeam);
		match.setLoc(loc);
				
		MatchDAO.insertMatch(match);
	}
	@Test
	public void testSelectWinTeam() {
		String winTeam = MatchDAO.selectWinTeam("10001");
		System.out.println(winTeam);
	}
	@Test
	public void testUpdateMatch(){
		Match match = new Match();
		match.setNum("10032");
		match.setMatchTime("2012/03/27");
		match.setScore("4:6");
		
		Team hTeam = new Team();
		hTeam.setNum("1");
		
		Team aTeam = new Team();
		aTeam.setNum("6");
		
		Team wTeam = new Team();
		wTeam.setNum("6");
		
		Loc loc = new Loc();
		loc.setNum("11");
		
		match.setHomeTeam(hTeam);
		match.setAwayTeam(aTeam);
		match.setWinTeam(wTeam);
		match.setLoc(loc);
				
		MatchDAO.updateMatch(match);
	}

		
}
