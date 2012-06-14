package kr.or.kosta.bookchange.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MemberDAO extends SqlSessionDaoSupport implements IMemberDAO{

	
	/**
	 * ȸ�����Խ� DB�� �߰�
	 * 
	 * @param member
	 */
	@Override
	public void insertMember(Member member) {
		SqlSession session =null;
		session=getSqlSession();
		session.insert("Member.insertMember",member);
	}

//	public static void insertMember(Member member) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement ps=null;
//		con=ConnectionUtil.getConnection();
//		try {
//			ps=con.prepareStatement("insert into tb_member " +
//					"(email,tel,address,pw)" +
//					"values(?,?,?,?)");
//			ps.setString(1, member.getEmail());
//			ps.setString(2, member.getTel());
//			ps.setString(3, member.getAddress());
//			ps.setString(4, member.getPw());
//			ps.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
 
	/**
	 * ȸ������
	 * 
	 * @param email
	 */
	@Override
	public void updateMember(
			 Member member){
		
		SqlSession session=getSqlSession();

		session.update("Member.updateMember",member);

	}
	
	

//	public static void updateMember(Member member) {
//		/* default generated stub */;
//		Connection con= null;
//		PreparedStatement ps=null;
//		con=ConnectionUtil.getConnection();
//		
//		try {
//			ps=con.prepareStatement(
//					"update tb_member " +
//					"set tel=?,pw=?,address=? where email=?");
//			ps.setString(1, member.getTel());
//			ps.setString(2, member.getPw());
//			ps.setString(3, member.getAddress());
//			ps.setString(4, member.getEmail());
//			ps.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	
//	}
	/**
	 * ȸ��Ż��(DB���� ����)
	 * 
	 * @param email
	 */
	@Override
	public void deleteMember(
			 String email){
		SqlSession session =null;
		session=getSqlSession();
		session.delete("Member.deleteMember",email);
	 
	}
	
//	public static void deleteMember(String email) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement ps=null;
//		
//		con=ConnectionUtil.getConnection();
//		
//		try {
//			ps=con.prepareStatement("DELETE FROM tb_member where email=?");
//			ps.setString(1, email);
//			ps.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//			
//		}
//	
//	}
	
	
	/**
	 * ��ü ȸ���� ����
	 */
	@Override
	public  int selectMemberCount(){

		Integer count=null;
		SqlSession session =null;
		session=getSqlSession();
		count=session.selectOne("Member.selectMemberCount");
		//��ȸ ����� 1�ǶǴ� 0���϶�
		//selectOne(����ID,�Ķ���� ����)
		//select������ �����ϰ� Vo��ü ���� ��ȸ ��� �Ӽ��� ��Ƽ� ����
		//-��ȸ����� 2�� �̻��̸� ���࿡��
		return count;
	}
//	public static int selectMemberCount() {
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		int memberCount=0;
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="select count(email) from tb_member "; 
//			ps=con.prepareStatement(sql);
//			rs=ps.executeQuery();
//			if(rs.next()){
//				memberCount=rs.getInt(1);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return memberCount;
//	}

	/**
	 * (������ ����)ȸ������ ��ȸ
	 * 
	 * @param length
	 * @param page
	 */
	@Override
	public List <Member> selectMemberList(
			 int page,int length){
		SqlSession session=getSqlSession();
		List<Member> memberList;
			
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		memberList=session.selectList("selectMember",null,rowBounds);
				
		return memberList;
	}


//	public static ArrayList<Member> selectMemberList(int length, int page) {
//	/* default generated stub */;
//	Connection con=null;
//	PreparedStatement ps=null;
//	String sql=null;
//	ResultSet rs=null;
//	ArrayList<Member> memberList=new ArrayList<Member>();
//	try {
//		con=ConnectionUtil.getConnection();
//		sql="select email,tel,address,pw from tb_member ";
//		ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
//									ResultSet.CONCUR_READ_ONLY);
//		rs=ps.executeQuery();
//		if(page>1){
//			rs.absolute((page-1)*length);
//		}
//		//������ ���ڵ� ����
//		int getRecord=0;
//		while (rs.next()&&getRecord<length) {
//			
//			getRecord++;
//			String email=rs.getString(1);
//			String tel=rs.getString(2);
//			String address=rs.getString(3);
//			String pw=rs.getString(4);
//			
//			Member member=new Member();
//			member.setEmail(email);
//			member.setAddress(address);
//			member.setTel(tel);
//			member.setPw(pw);
//			memberList.add(member);
//		}
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//	
//	return memberList;
//}

	/**
	 * ��ü ȸ�� �� ����(�̸���)
	 */
	@Override
	public int selectMemberCountemail(String email){
		Integer count=null;
		SqlSession session =null;
		session=getSqlSession();

		count=session.selectOne("Member.selectMemberCountemail",email);
		//��ȸ ����� 1�ǶǴ� 0���϶�
		//selectOne(����ID,�Ķ���� ����)
		//select������ �����ϰ� Vo��ü ���� ��ȸ ��� �Ӽ��� ��Ƽ� ����
		//-��ȸ����� 2�� �̻��̸� ���࿡��
		return count;
	}

//	public static int selectMemberCount(String email) {
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		
//		int memberCount=0;
//		
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="select count(email) from tb_member "; 
//			ps=con.prepareStatement(sql);
//			
//			rs=ps.executeQuery();
//			if(rs.next()){
//				memberCount=rs.getInt(1);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return memberCount;
//	}
//
//	
	
	/**
	 * ȸ����������
	 * 
	 * @param email
	 */
	@Override
	public Member selectMemberemail(String email){
		Member member=null;
		SqlSession session =null;
		session=getSqlSession();

		member=session.selectOne("selectMemberemail",email);
		return member;
	}
	
	
	
//	public static Member selectMember(String email) {
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		Member member=null;
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="select email,tel,address,pw from tb_member where email=?";
//			ps=con.prepareStatement(sql);
//			ps.setString(1, email);
//			rs=ps.executeQuery();
//			
//			if (rs.next()) {
//				 
//				 email=rs.getString(1);
//				 String tel=rs.getString(2);
//				 String address=rs.getString(3);
//				 String pw=rs.getString(4);
//				 
//				 member=new Member();
//				 member.setEmail(email);
//				 member.setTel(tel);
//				 member.setAddress(address);
//				 member.setPw(pw);
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return member;
//	}
	/**
	 * ��ü ���� (�̸��Ϸ� �˻�)
	 * 
	 * @param length
	 * @param page
	 */
	
	@Override
	public List <Member> selectMemberListByEmail(
			 int page,int length,String email){
		 
		List<Member> memberList;
		SqlSession session=getSqlSession();
	
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.selectMemberListByEmail","%"+email+"%",rowBounds);
				
		return memberList;
	}
//	public static ArrayList<Member> selectMemberListByEmail(int length, int page, String email) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		ArrayList<Member> memberList=new ArrayList<Member>();
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="select email,tel,address,pw from tb_member where email=? ";
//			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
//										ResultSet.CONCUR_READ_ONLY);
//			ps.setString(1, email);
//			rs=ps.executeQuery();
//			if(page>1){
//				rs.absolute((page-1)*length);
//			}
//			//������ ���ڵ� ����
//			int getRecord=0;
//			while (rs.next()&&getRecord<length) {
//				
//				getRecord++;
//				email=rs.getString(1);
//				String tel=rs.getString(2);
//				String address=rs.getString(3);
//				String pw=rs.getString(4);
//				
//				Member member=new Member();
//				member.setEmail(email);
//				member.setAddress(address);
//				member.setTel(tel);
//				member.setPw(pw);
//				memberList.add(member);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return memberList;
//	}
	/**
	 * ȸ�� ��й�ȣ ����(��ȭ��ȣ�� �̸��Ϸ� �˻�)
	 */
	@Override
	public  Member selectMemberListByPw(String email,String tel){
	
		Member member=null;
		SqlSession session =getSqlSession();
		
		
		HashMap<String, String> parameters=new HashMap<String, String>();
		parameters.put("email", email);
		parameters.put("tel", tel);
		member=session.selectOne("Member.selectMemberListByPw",parameters);
		return member;
	}
	
//	public static Member selectMember(String email,String tel){
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		con=ConnectionUtil.getConnection();
//		ResultSet rs=null;
//		Member member=null;
//		try {
//		
//			sql="select pw,email,tel from tb_member where email=? and tel=?";
//			ps=con.prepareStatement(sql);
//			ps.setString(1,email);
//			ps.setString(2,tel);
//			ps.executeQuery();
//			rs=ps.executeQuery();
//			
//			while (rs.next()) {
//				
//				String pw=rs.getString(1);
//				String realemail=rs.getString(2);
//				String realtel=rs.getString(3);
//				
//				member=new Member();
//				
//				member.setPw(pw);
//				member.setEmail(realemail);
//				member.setTel(realtel);
//			}		
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return member;
//	}
	
	/**
	 * ��ȭ��ȣ�� �̸��� �˻�
	 * @param request
	 * @param response
	 * @return 
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public  Member selectMemberemailTel(String tel){
		Member member=null;
		SqlSession session =null;
		session=getSqlSession();
	
		member=session.selectOne("selectMemberListByTel",tel);
		return member;
	}
	
	
//	  public static Member selectMemberTel(String tel){
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		con=ConnectionUtil.getConnection();
//		ResultSet rs=null;
//		Member member=null;
//		try {
//			sql="select email, tel from tb_member where tel=?";
//			ps=con.prepareStatement(sql);
//			
//			ps.setString(1,tel);			
//			rs=ps.executeQuery();
//			
//			while(rs.next()){
//				String email=rs.getString(1);
//				String realTel=rs.getString(2);
//				
//				member=new Member();
//				member.setEmail(email);
//				member.setTel(realTel);
//			}
//						
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return member;
//				
//	  }
//	

}