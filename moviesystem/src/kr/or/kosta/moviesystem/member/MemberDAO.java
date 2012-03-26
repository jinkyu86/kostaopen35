package kr.or.kosta.moviesystem.member;

public class MemberDAO {

	/**
	 * ID로 회원을 찾을 수 있는 메서드
	 * 
	 * @param memberid
	 */
	public Member selectMemberById(String memberid) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원 입력하기
	 * 
	 * @param member
	 */
	public void insertMember(Member member) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회우너 
	 * 
	 * @param memberid
	 * @param pw
	 */
	public Member editMember(String memberid, String pw) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원 삭제
	 * 
	 * @param memberid
	 * @param pw
	 */
	public void removeMember(String memberid, String pw) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 전체 회원 리스트를 볼 수 있는 메서드
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList selectMemberList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 전체 회원의 수를 알 수 있는 메서드
	 */
	public int selectMemberListCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * 이름으로 회원 찾기
	 * 
	 * @param length
	 * @param page
	 * @param name
	 */
	public ArrayList searchMemberListByName(int length, int page, String name) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 이름으로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param name
	 */
	public int searchMemberListByNameCount(String name) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 핸드폰번호로 회원을 찾을 수 있는 기능
	 * 
	 * @param length
	 * @param page
	 * @param phone
	 */
	public ArrayList searchMemberListByPhone(int length, int page, String phone) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 전화번호로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param phone
	 */
	public int searchMemberListByPhoneCount(String phone) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 이메일로 회원 찾기 기능
	 * 
	 * @param length
	 * @param page
	 * @param email
	 */
	public ArrayList searchMemberListByEmail(int length, int page, String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 이메일로 찾을 회원의 수를 알 수 있는 메서드
	 * 
	 * @param email
	 */
	public int searchMemberListByEmailCount(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 주소로 회원을 찾을 수 있는 기능
	 * 
	 * @param length
	 * @param page
	 * @param addr
	 */
	public ArrayList searchMemberListByAddr(int length, int page, String addr) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 주소로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param addr
	 */
	public int searchMemberListByAddrCount(String addr) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 아이디를 잃어버려 회원의 이메일과 이름으로 회원의 아이디를 찾을 수 있는 메서드
	 * 
	 * @param email
	 * @param name
	 */
	public Member findMemberById(String email, String name) {
		/* default generated stub */;
		return null;
	}

	/**
	 * 회원이 비밀번호를 잃어버려 회원의 이메일, 이름, 아이디로 회원의 비밀번호를 찾을 수 있는 메서드
	 * 
	 * @param email
	 * @param name
	 * @param id
	 */
	public Member findMemberByPw(String email, String name, String id) {
		/* default generated stub */;
		return null;
	}
}
