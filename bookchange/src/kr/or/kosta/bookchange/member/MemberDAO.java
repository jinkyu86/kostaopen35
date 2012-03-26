package $301_도메인.$301_AN00_분석.AN30_요구사항정의.AN33_클래스모델개발.$35조_중고도서물물교환시스템_클래스모델개발;

public class MemberDAO {

	/**
	 * (관리자 전용)회원명단 조회
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList selectMemberList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 전체 회원수 리턴
	 */
	public int selectMemberCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원정보보기
	 * 
	 * @param email
	 */
	public Member selectMember(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * Email로 회원 검색(로그인시 중복 아이디 있는지 검색할 때나 관리자가 회원 검색 시 사용)
	 * 
	 * @param email
	 */
	public Member selectMemberbyEmail(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원가입시 DB에 추가
	 * 
	 * @param member
	 */
	public void insertMember(Member member) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원수정
	 * 
	 * @param email
	 */
	public Member updateMember(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원탈퇴(DB에서 삭제)
	 * 
	 * @param email
	 */
	public void deleteMember(String email) {
		/* default generated stub */;
		return null;
	}
}
