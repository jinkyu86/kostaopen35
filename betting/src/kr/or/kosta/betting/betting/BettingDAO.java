package kr.or.kosta.betting.betting;

import java.util.Date;

public class BettingDAO {

	/**
	 * 베팅 데이터의 모든 데이터 조회 하는 메서드
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectBettingList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 해당 날짜의 경기의 데이터만 조회하는 메서드
	 * 
	 * @param Date
	 */
	public ArrayList selectBettingListByDate(Date Date) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 베팅 데이터 입력하는 메서드
	 * 
	 * @param betting
	 */
	public void insertBetting(Betting betting) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 베팅번호로 선택된 데이터의 업데이트
	 * 
	 * @param num
	 * @param batRating
	 * @param seleRating
	 * @param totMineral
	 */
	public void updateBetting(String num, long batRating, long seleRating,
			long totMineral) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 선택된 번호의 베팅률 조회
	 * 
	 * @param num
	 */
	public long selectBettingRating(String num) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 선택된 번호의 베팅팀의 선택률
	 * 
	 * @param num
	 */
	public long selectBettingSeleRating(String num) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 선택된 베팅 번호의 팀의 누적된 베팅 금액을 조회
	 * 
	 * @param num
	 */
	public long selectBettingTotMineral(String num) {
		/* default generated stub */;
		return null;
	}
}
