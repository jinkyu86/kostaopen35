package kr.or.kosta.betting.member;

import java.util.ArrayList;

public class MemberDAO {

	/**
	 * ����� ��� ��������Ʈ�� ��ȸ�ϴ� �޼���
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectMemberList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��� ������ ����
	 * 
	 * @param member
	 */
	public void insultMember(Member member) {
		/* default generated stub */;
	
	}

	/**
	 * ���̵� ���� ���õ� ��������� ��ȸ
	 * 
	 * @param ID
	 */
	public Member selectMemberByID(String ID) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ���̵�� ���õ� ������ ����
	 * 
	 * @param ID
	 */
	public void deleteMember(String ID) {
		/* default generated stub */;
		return;
	}

	/**
	 * �̳׶� ������ �������� ������ �������Ʈ
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectMemberRankingList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ���õ� ���̵��� ������ ������Ʈ ��
	 * 
	 * @param ID
	 * @param PW
	 * @param Email
	 * @param mineral
	 */
	public void updateMember(String ID, String PW, String Email, long mineral) {
		/* default generated stub */;
		
	}

	/**
	 * ������ ������ ���� ��� ī����
	 */
	public int countMember() {
		/* default generated stub */;
		return 0 ;
	}
}
