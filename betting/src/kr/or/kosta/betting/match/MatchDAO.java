package kr.or.kosta.betting.match;

import java.util.Date;

public class MatchDAO {

	/**
	 * ��ġ�� ��� ������ ����Ʈ ��ȸ �޼���
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectMatchList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ������ ��¥�� �ϴ� ��� ������ ��ȸ �޼���
	 * 
	 * @param Date
	 */
	public ArrayList selectMatchByDate(Date Date) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ������ ��ġ ��ȣ�� ������ ��ȸ �޼���
	 * 
	 * @param num
	 * @param score
	 * @param winNum
	 */
	public void updateMatch(String num, String score, String winNum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ġ ���̼� ���� �޼���
	 * 
	 * @param match
	 */
	public void insertMatch(Match match) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ������ ������ ���� ī���� �޼���
	 */
	public int countMatch() {
		/* default generated stub */;
		return null;
	}

	/**
	 * ���õ� ��¥�� ����� ����ŭ ī�����ϴ� �޼���
	 * 
	 * @param date
	 */
	public int countMatchByDate(date date) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ���õ� ����ȣ�� �̱��� ��ȣ�� ��ȸ�ϴ� �޼���
	 * 
	 * @param matchnum
	 */
	public String selectWinTeam(String matchnum) {
		/* default generated stub */;
		return null;
	}
}
