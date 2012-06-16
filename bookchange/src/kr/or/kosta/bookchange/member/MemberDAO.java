package kr.or.kosta.bookchange.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;

import kr.or.kosta.bookchange.change.Change;

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

	/**
	 * ��ü ȸ���� ����
	 */
	@Override
	public  int selectMemberCount(){

		Integer count=null;
		SqlSession session =null;
		session=getSqlSession();
		count=session.selectOne("Member.selectMemberCount");
		return count;
	}

	/**
	 * (������ ����)ȸ����� ��ȸ
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
	
	
	
	/**
	 * ��ü ��� (�̸��Ϸ� �˻�)
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

@Override
public List<Member> searchMemberList(int page, int length, String email,
		String tel) {
	List<Member>memberList;
	SqlSession session=getSqlSession();
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	memberList=session.selectList("Member.searchMemberList",email,rowBounds);
	return memberList;
}

@Override
public List<Member> searchMemberListEmail(int page, int length, String email) {
	List<Member>memberList;
	SqlSession session=getSqlSession();
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	memberList=session.selectList("Member.searchMemberListEmail",email,rowBounds);
	return memberList;
}

@Override
public List<Member> searchMemberListTel(int page, int length, String tel) {
	List<Member>memberList;
	SqlSession session=getSqlSession();
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	memberList=session.selectList("Member.searchMemberListTel",tel,rowBounds);
	return memberList;
}

@Override
public List<Member> searchMemberListPw(int page, int length, String pw) {
	List<Member>memberList;
	SqlSession session=getSqlSession();
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	memberList=session.selectList("Member.searchMemberListPw",pw,rowBounds);
	return memberList;
}

@Override
public int searchMemberCountTel(String tel) {
	Integer count=null;
	SqlSession session=getSqlSession();

	count=session.selectOne("Member.searchMemberCountTel",tel);
	return count;
}

@Override
public int searchMemberCountEmail(String email) {
	Integer count;
	SqlSession session=getSqlSession();
	count=session.selectOne("Member.searchMemberCountEmail",email);
	return count;
}

@Override
public int searchMemberCountPw(String pw) {
	Integer count;
	SqlSession session=getSqlSession();

    count=session.selectOne("Member.searchMemberCountPw",pw);
	return count;
}

@Override
public List<Change> searchMemberListCondition(int page, int length,String condition) {
	List<Change> conditionList;
	SqlSession session=getSqlSession();
	RowBounds rowBounds=new RowBounds((page-1)*length,length);
	conditionList=session.selectList("Member.searchMemberListCondition",condition,rowBounds);
	return conditionList;
}
@Override
public int searchMemberListConditioncount(int page, int length) {
	Integer count;
	SqlSession session=getSqlSession();
    count=session.selectOne("Member.searchMemberListConditioncount");
	return count;
}

@Override
public List<Change> searchMemberListCondition(int page, int length) {
	// TODO Auto-generated method stub
	return null;
}	
	

}