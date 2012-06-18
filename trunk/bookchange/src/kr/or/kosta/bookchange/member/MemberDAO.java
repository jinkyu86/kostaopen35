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
	 * ȸ����������
	 * 
	 * @param email
	 */
	@Override
	public Member selectMemberEmail(String email){
		Member member=null;
		SqlSession session =null;
		session=getSqlSession();

		member=session.selectOne("selectMemberEmail",email);
		return member;
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
	public  Member selectMemberEmailTel(String tel){
		Member member=null;
		SqlSession session =null;
		session=getSqlSession();
	
		member=session.selectOne("Member.selectMemberEmailTel",tel);
		return member;
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
		memberList=session.selectList("Member.selectMemberList",null,rowBounds);
				
		return memberList;
	}

	/**
	 * ��ü ��� (��ȭ��ȣ�� �˻�)
	 * 
	 * @param length
	 * @param page
	 */
	
	@Override
	public List <Member> selectMemberListByTel(
			 int page,int length,String tel){
		 
		List<Member> memberList;
		SqlSession session=getSqlSession();
	
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.selectMemberListByTel","%"+tel+"%",rowBounds);
				
		return memberList;
	}
	/**
	 * ��ü ��� (�̸��Ϸ� �˻�)
	 * 
	 * @param length
	 * @param page
	 */
	
	@Override
	public List<Member> selectMemberListByEmail(int page, int length, String email){

		 
		List<Member> memberList;
		SqlSession session=getSqlSession();
	
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.selectMemberListByEmail",email,rowBounds);
				
		return memberList;
	}
	/**
	 * �̸��� ���� 
	 * 
	 * @param length
	 * @param page
	 */
	

	@Override
	public int selectMemberCountEmail(String email) {
		Integer count=null;
		SqlSession session =null;
		session=getSqlSession();
		count=session.selectOne("Member.selectMemberCount",email);
		return count;
	}

}