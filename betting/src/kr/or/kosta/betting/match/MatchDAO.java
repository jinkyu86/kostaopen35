package kr.or.kosta.betting.match;

import java.util.ArrayList;
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
		
	}

	/**
	 * ��ġ ���̼� ���� �޼���
	 * 
	 * @param match
	 */
	public void insertMatch(Match match) {
		/* default generated stub */;
	
	}

	/**
	 * ������ ������ ���� ī���� �޼���
	 */
	public int countMatch() {
		/* default generated stub */;
		return 0;
	}

	/**
	 * ���õ� ��¥�� ����� ����ŭ ī�����ϴ� �޼���
	 * 
	 * @param date
	 */
	public int countMatchByDate(Date date) {
		/* default generated stub */;
		return 0;
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
