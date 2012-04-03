package kr.or.kosta.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kosta.util.ConnectionUtil;

public class MemberDAO {

	/**
	 * ȸ������ Member���̺��� ȸ����������
	 * 
	 * @param member
	 */
	public void insertMember(Member member) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * ���̵�ã�� ȸ���̸�,�ֹε�Ϲ�ȣ�� ��ġ�ϴ� ���̵�ã��
	 * 
	 * @param name
	 * @param reginum
	 */
	public Member selectMemberByid(String name, String reginum) {
		/* default generated stub */;
		return null;
	}

	/**
	 * �н�����ã�� ��Ʈ������/�亯�� ��ġ�ϴ� ����ã��
	 * 
	 * @param hint
	 * @param answer
	 */
	public Member selectMemberBypw(String hint, String answer) {
		/* default generated stub */;
		return null;
	}

	/**
	 * ȸ��Ż�� ȸ����й�ȣ, �ֹε�Ϲ�ȣ�� ��ġ�� ȸ��Ż��
	 * 
	 * @param pw
	 * @param reginum
	 */
	public void deleteMember(String pw, String reginum) {
		/* default generated stub */;
//		return null;
	}

	/**
	 * ȸ������ ����
	 * 
	 * @param member
	 */
	public void updateMember(Member member) {
		/* default generated stub */;
//		return null;
	}
	
	public static Member login(String memberid,String password){
		Member member=null;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select memberid,password,name,regi_number,pw_hint,pw_answer,zipcode,address,str_address,email,phone_number,tel_number"+
				     " from member"+
				     " where memberid=? and password=?";
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, memberid);
			psmt.setString(2, password);
			rs=psmt.executeQuery();
			if(rs.next()){
				member = new Member(memberid,password,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
}