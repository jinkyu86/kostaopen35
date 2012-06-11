package kr.or.kosta.moviesystem.member;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;



public class MemberDAO extends SqlSessionDaoSupport implements IMemberDAO{
	
	
	/**
	 * ID�� ȸ���� ã�� �� �ִ� �޼���
	 * 
	 * @param memberid
	 */
	
	@Override
	public Member selectMemberById(String userid) {
		SqlSession session = null;
		Member member=null;
		
			session=getSqlSession();
			member=session.selectOne("Member.selectMemberById",userid);
	
		return member;
	}
	
	@Override
	public Member selectMember(String userNum) {
		SqlSession session = null;
		Member member=null;
		
			session=getSqlSession();
			member=session.selectOne("Member.selectMember",userNum);

		return member;
	}

	/**
	 * ȸ�� �Է��ϱ�
	 * 
	 * @param member
	 */
	
	@Override
	public String insertMember(Member member) {
		SqlSession session=null;

			session=getSqlSession();
			session.insert("Member.insertMember",member);

	
		return member.getUserid();
	}

	/**
	 * ȸ������
	 * 
	 * @param memberid
	 * @param pw
	 */
	
	@Override
	public void editMember(Member member) {
		SqlSession session = null;

			session=getSqlSession();
			session.update("Member.editMember",member);

	}

	/**
	 * ȸ�� Ż��
	 * 
	 * @param memberid
	 * @param pw
	 */
	
	@Override
	public void dropMember(Member member) {
		SqlSession session = null;

			session=getSqlSession();
			session.update("Member.dropMember",member);
	
	}

	/**
	 * ��ü ȸ�� ����Ʈ�� �� �� �ִ� �޼���
	 * 
	 * @param length
	 * @param page
	 */
	@Override
	public List<Member> selectMemberList(int length, int page) {
		SqlSession session = null;
		List<Member> memberList=null;

			session=getSqlSession();
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.selectMemberList",null,rowBounds);
			
		return memberList;
	 }
	
	@Override
	public  List<Member> selectMemberList(){
		SqlSession session=null;
		List<Member>memberList=null;
	
		session = getSqlSession();
		memberList=
				session.selectList("Member.selectMemberList");
		
		return memberList;
		
	}


	/**
	 * ��ü ȸ���� ���� �� �� �ִ� �޼���
	 */
	
	@Override
	public int selectMemberListCount() {
		SqlSession session = null;
		Integer count=null;

			session=getSqlSession();
			count=session.selectOne("Member.selectMemberListCount");
			

		return count;
	}

	/**
	 * �̸����� ȸ�� ã��
	 * 
	 * @param length
	 * @param page
	 * @param name
	 */
	@Override
	public List<Member> searchMemberListByName(int length, int page, String name) {
		SqlSession session = null;
		List<Member> memberList=null;

			session=getSqlSession();
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.searchMemberListByName","%"+name+"%",rowBounds);
			

		return memberList;
	}

	/**
	 * �̸����� ã�� ȸ���� ���� �� �� �ִ� �޼���
	 * 
	 * @param name
	 */
	@Override
	public int searchMemberListByNameCount(String name) {
		SqlSession session = null;
		Integer count=null;

			session=getSqlSession();
			count=session.selectOne("Member.searchMemberListByNameCount","%"+name+"%");
			

		return count;
	}

	/**
	 * �ڵ�����ȣ�� ȸ���� ã�� �� �ִ� ���
	 * 
	 * @param length
	 * @param page
	 * @param phone
	 */
	
	@Override
	public List<Member> searchMemberListByPhone(int length, int page, String phone) {
		SqlSession session = null;
		List<Member> memberList=null;

			session=getSqlSession();
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.searchMemberListByPhone","%"+phone+"%",rowBounds);
	
		return memberList;
	}

	/**
	 * ��ȭ��ȣ�� ã�� ȸ���� ���� �� �� �ִ� �޼���
	 * 
	 * @param phone
	 */
	
	@Override
	public int searchMemberListByPhoneCount(String phone) {
		SqlSession session = null;
		Integer count=null;

			session=getSqlSession();
			count=session.selectOne("Member.searchMemberListByPhoneCount","%"+phone+"%");
			

		return count;
	}

	/**
	 * �̸��Ϸ� ȸ�� ã�� ���
	 * 
	 * @param length
	 * @param page
	 * @param email
	 */
	
	@Override
	public List<Member> searchMemberListByEmail(int length, int page, String email) {
		SqlSession session = null;
		List<Member> memberList=null;

			session=getSqlSession();
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.searchMemberListByEmail","%"+email+"%",rowBounds);
			
		return memberList;
	}

	/**
	 * �̸��Ϸ� ã�� ȸ���� ���� �� �� �ִ� �޼���
	 * 
	 * @param email
	 */
	
	@Override
	public int searchMemberListByEmailCount(String email) {
		SqlSession session = null;
		Integer count=null;

			session=getSqlSession();
			count=session.selectOne("Member.searchMemberListByEmailCount","%"+email+"%");
			

		return count;
	}

	/**
	 * �ּҷ� ȸ���� ã�� �� �ִ� ���
	 * 
	 * @param length
	 * @param page
	 * @param addr
	 */
	
	@Override
	public List<Member> searchMemberListByAddr(int length, int page, String addr) {
		SqlSession session = null;
		List<Member> memberList=null;

			session=getSqlSession();
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.searchMemberListByAddr","%"+addr+"%",rowBounds);
			
		return memberList;
	}

	/**
	 * �ּҷ� ã�� ȸ���� ���� �� �� �ִ� �޼���
	 * 
	 * @param addr
	 */
	
	@Override
	public int searchMemberListByAddrCount(String addr) {
		SqlSession session = null;
		Integer count=null;

			session=getSqlSession();
			count=session.selectOne("Member.searchMemberListByAddrCount","%"+addr+"%");
			

		return count;
	}

	/**
	 * ���̵� �Ҿ���� ȸ���� �̸��ϰ� �̸����� ȸ���� ���̵� ã�� �� �ִ� �޼���
	 * 
	 * @param email
	 * @param name
	 */
	
	@Override
	public Member findMemberId(String email, String name) {
		SqlSession session = null;
		Member member=null;

			session=getSqlSession();
			HashMap<String,String> parameter=new HashMap<String,String>();
			parameter.put("email",email);
			parameter.put("name",name);
			member=session.selectOne("Member.findIdMember",parameter);
			

		return member;
	}

	/**
	 * ȸ���� ��й�ȣ�� �Ҿ���� ȸ���� �̸���, �̸�, ���̵�� ȸ���� ��й�ȣ�� ã�� �� �ִ� �޼���
	 * 
	 * @param email
	 * @param name
	 * @param id
	 */
	
	@Override
	public Member findMemberPw(String email, String name, String userid) {
		SqlSession session = null;
		Member member=null;

			session=getSqlSession();
			HashMap<String,String> parameter=new HashMap<String,String>();
			parameter.put("email",email);
			parameter.put("name",name);
			parameter.put("userid",userid);
			member=session.selectOne("Member.findIdMember",parameter);
			
		return member;
	}


}
