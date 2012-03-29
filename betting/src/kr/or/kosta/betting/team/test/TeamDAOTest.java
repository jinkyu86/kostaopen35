package kr.or.kosta.betting.team.test;

import java.util.ArrayList;

import kr.or.kosta.betting.team.Team;
import kr.or.kosta.betting.team.TeamDAO;

import org.junit.Test;

public class TeamDAOTest {

	@Test
	public void testSelectTeamList() {
		ArrayList<Team>teamList = TeamDAO.selectTeamList();
		for(int i=0;i<teamList.size();i++){
			Team team = teamList.get(i);
			System.out.println(team);
		}
	}
	@Test
	public void testSelectTeam() {
		Team team = TeamDAO.selectTeam("2");
		System.out.println(team);
	}

}
