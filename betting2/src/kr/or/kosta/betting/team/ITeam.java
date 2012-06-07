package kr.or.kosta.betting.team;

import java.util.List;

public interface ITeam {

	List<Team> selectTeamList();

	Team selectTeam(String teamNum);

}
