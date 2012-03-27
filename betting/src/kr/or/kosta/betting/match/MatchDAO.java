package kr.or.kosta.betting.match;

import java.util.ArrayList;
import java.util.Date;

public class MatchDAO {

	/**
	 * 매치의 모든 데이터 리스트 조회 메서드
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectMatchList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 선택한 날짜에 하는 경기 데이터 조회 메서드
	 * 
	 * @param Date
	 */
	public ArrayList selectMatchByDate(Date Date) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 선택한 매치 번호의 데이터 조회 메서드
	 * 
	 * @param num
	 * @param score
	 * @param winNum
	 */
	public void updateMatch(String num, String score, String winNum) {
		/* default generated stub */;
		
	}

	/**
	 * 매치 데이서 삽입 메서드
	 * 
	 * @param match
	 */
	public void insertMatch(Match match) {
		/* default generated stub */;
	
	}

	/**
	 * 페이지 설정을 위한 카운터 메서드
	 */
	public int countMatch() {
		/* default generated stub */;
		return 0;
	}

	/**
	 * 선택된 날짜의 경기의 수만큼 카운터하는 메서드
	 * 
	 * @param date
	 */
	public int countMatchByDate(Date date) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * 선택된 팀번호의 이긴팀 번호를 조회하는 메서드
	 * 
	 * @param matchnum
	 */
	public String selectWinTeam(String matchnum) {
		/* default generated stub */;
		return null;
	}
}
