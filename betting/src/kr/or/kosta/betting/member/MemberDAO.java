package kr.or.kosta.betting.member;

import java.util.ArrayList;

public class MemberDAO {

	/**
	 * 멤버의 모든 정보리스트를 조회하는 메서드
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectMemberList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 멤버 데이터 삽입
	 * 
	 * @param member
	 */
	public void insultMember(Member member) {
		/* default generated stub */;
	
	}

	/**
	 * 아이디를 통해 선택된 멤버데이터 조회
	 * 
	 * @param ID
	 */
	public Member selectMemberByID(String ID) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 아이디로 선택된 데이터 삭제
	 * 
	 * @param ID
	 */
	public void deleteMember(String ID) {
		/* default generated stub */;
		return;
	}

	/**
	 * 미네랄 순으로 오름차순 정열된 멤버리스트
	 * 
	 * @param page
	 * @param length
	 */
	public ArrayList selectMemberRankingList(int page, int length) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 선택된 아이디의 정보를 업데이트 함
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
	 * 페이지 설정을 위한 멤버 카운터
	 */
	public int countMember() {
		/* default generated stub */;
		return 0 ;
	}
}
