package kr.or.kosta.betting.betting;

import java.util.ArrayList;
import java.util.Date;

public class BettingDAO {

	/**
	 * ���� �������� ��� ������ ��ȸ �ϴ� �޼���
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectBettingList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �ش� ��¥�� ����� �����͸� ��ȸ�ϴ� �޼���
	 * 
	 * @param Date
	 */
	public ArrayList selectBettingListByDate(Date Date) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ���� ������ �Է��ϴ� �޼���
	 * 
	 * @param betting
	 */
	public void insertBetting(Betting betting) {
		/* default generated stub */;
		
	}

	/**
	 * ���ù�ȣ�� ���õ� �������� ������Ʈ
	 * 
	 * @param num
	 * @param batRating
	 * @param seleRating
	 * @param totMineral
	 */
	public void updateBetting(String num, long batRating, long seleRating,
			long totMineral) {
		/* default generated stub */;
		
	}

	/**
	 * ���õ� ��ȣ�� ���÷� ��ȸ
	 * 
	 * @param num
	 */
	public long selectBettingRating(String num) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * ���õ� ��ȣ�� �������� ���÷�
	 * 
	 * @param num
	 */
	public long selectBettingSeleRating(String num) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * ���õ� ���� ��ȣ�� ���� ������ ���� �ݾ��� ��ȸ
	 * 
	 * @param num
	 */
	public long selectBettingTotMineral(String num) {
		/* default generated stub */;
		return 0;
	}
}
