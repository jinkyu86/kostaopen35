package kr.or.kosta.bookchange.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.or.kosta.util.ConnectionUtil;



import com.sun.corba.se.pept.transport.Connection;

public class MemberDAO {

	/**
	 * (������ ����)ȸ����� ��ȸ
	 * 
	 * @param length
	 * @param page
	 */
	public ArrayList<Member> selectMemberList(int length, int page, String email) {
		/* default generated stub */;
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Member> memberList=new ArrayList<Member>();
		try {
			con=(Connection) ConnectionUtil.getConnection();
			sql="select from where";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return memberList;
	}

	/**
	 * ��ü ȸ���� ����
	 */
	public int selectMemberCount() {
		/* default generated stub */;
		return 0;
	}

	/**
	 * ȸ����������
	 * 
	 * @param email
	 */
	public Member selectMember(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * Email�� ȸ�� �˻�(�α��ν� �ߺ� ���̵� �ִ��� �˻��� ���� �����ڰ� ȸ�� �˻� �� ���)
	 * 
	 * @param email
	 */
	public Member selectMemberbyEmail(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ȸ�����Խ� DB�� �߰�
	 * 
	 * @param member
	 */
	public void insertMember(Member member) {
		/* default generated stub */;
	}

	/**
	 * ȸ������
	 * 
	 * @param email
	 */
	public Member updateMember(String email) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ȸ��Ż��(DB���� ����)
	 * 
	 * @param email
	 */
	public void deleteMember(String email) {
		/* default generated stub */;
		
	}
}
