package kr.or.kosta.moviesystem.member;

public class MemberDAO {

	/**
	 * ID�� ȸ���� ã�� �� �ִ� �޼���
	 * 
	 * @param memberid
	 */
	public Member selectMemberById(String memberid) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ȸ�� �Է��ϱ�
	 * 
	 * @param member
	 */
	public void insertMember(Member member) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ȸ��� 
	 * 
	 * @param memberid
	 * @param pw
	 */
	public Member editMember(String memberid, String pw) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ȸ�� ����
	 * 
	 * @param memberid
	 * @param pw
	 */
	public void removeMember(String memberid, String pw) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ü ȸ�� ����Ʈ�� �� �� �ִ� �޼���
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList selectMemberList(int length, int page) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ��ü ȸ���� ���� �� �� �ִ� �޼���
	 */
	public int selectMemberListCount() {
		/* default generated stub */;
		return null;
	}

	/**
	 * �̸����� ȸ�� ã��
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
	 * �̸����� ã�� ȸ���� ���� �� �� �ִ� �޼���
	 * 
	 * @param name
	 */
	public int searchMemberListByNameCount(String name) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �ڵ�����ȣ�� ȸ���� ã�� �� �ִ� ���
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
	 * ��ȭ��ȣ�� ã�� ȸ���� ���� �� �� �ִ� �޼���
	 * 
	 * @param phone
	 */
	public int searchMemberListByPhoneCount(String phone) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �̸��Ϸ� ȸ�� ã�� ���
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
	 * �̸��Ϸ� ã�� ȸ���� ���� �� �� �ִ� �޼���
	 * 
	 * @param email
	 */
	public int searchMemberListByEmailCount(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �ּҷ� ȸ���� ã�� �� �ִ� ���
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
	 * �ּҷ� ã�� ȸ���� ���� �� �� �ִ� �޼���
	 * 
	 * @param addr
	 */
	public int searchMemberListByAddrCount(String addr) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ���̵� �Ҿ���� ȸ���� �̸��ϰ� �̸����� ȸ���� ���̵� ã�� �� �ִ� �޼���
	 * 
	 * @param email
	 * @param name
	 */
	public Member findMemberById(String email, String name) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ȸ���� ��й�ȣ�� �Ҿ���� ȸ���� �̸���, �̸�, ���̵�� ȸ���� ��й�ȣ�� ã�� �� �ִ� �޼���
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
