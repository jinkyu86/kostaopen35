package kr.or.kosta.betting.match.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.betting.match.Match;
import kr.or.kosta.betting.match.MatchDAO;


import org.junit.Test;

public class MatchDAOTest {

	@Test
	public void testSelectMatchList() {
		ArrayList<Match> page1List = MatchDAO.selectMatchList(5, 1);
		System.out.println("page1List:" + page1List);
		ArrayList<Match> page2List = MatchDAO.selectMatchList(5, 2);
		System.out.println("page2List:" + page2List);

	}

}
