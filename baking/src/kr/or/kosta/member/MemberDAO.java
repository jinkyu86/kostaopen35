package kr.or.kosta.member;

public class MemberDAO {

	/**
	 * 회원가입 Member테이블의 회원정보삽입
	 * 
	 * @param member
	 */
	public void insertMember(Member member) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * 아이디찾기 회원이름,주민등록번호가 일치하는 아이디찾기
	 * 
	 * @param name
	 * @param reginum
	 */
	public Member selectMemberByid(String name, String reginum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 패스워드찾기 힌트의질문/답변과 일치하는 정보찾기
	 * 
	 * @param hint
	 * @param answer
	 */
	public Member selectMemberBypw(String hint, String answer) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원탈퇴 회원비밀번호, 주민등록번호가 일치시 회원탈퇴
	 * 
	 * @param pw
	 * @param reginum
	 */
	public void deleteMember(String pw, String reginum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원정보 수정
	 * 
	 * @param member
	 */
	public void updateMember(Member member) {
		/* default generated stub */;
		return null;
	}
}
