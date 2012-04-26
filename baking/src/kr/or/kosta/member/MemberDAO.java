package kr.or.kosta.member;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;


import kr.or.kosta.util.ConnectionUtil;

public class MemberDAO extends SqlSessionDaoSupport implements IMemberDAO{
	
	//ȸ������
	@Override
	public  void insertMember(Member member) {
		SqlSession session=null;
		
		session = getSqlSession();
		session.insert("Member.insertMember",member);
		
	}
	
	//ȸ����������
	@Override
	public  void updateMember(Member member) {
		SqlSession session=null;

		session = getSqlSession();
		session.update("Member.updateMember",member);	
	}
	
	//ȸ������
	@Override
	public  void deleteMember(String memberId) {
			SqlSession session=null;
			session = getSqlSession();
			session.delete("Member.deleteMember",memberId);	
		}
	//���̵�ã�� ȸ���̸�,�ֹε�Ϲ�ȣ�� ��ġ�ϴ� ���̵�ã��
	@Override
	public  Member selectMemberByid(Member member) {
			SqlSession session=null;
			Member member2= null;
			session = getSqlSession();
			member2=session.selectOne("Member.idSearchMember",member);
			
			return member2;
	}

	//�н����� ã��
	@Override
	public  Member selectMemberBypw(Member member) {
		SqlSession session=null;
		Member member2= null;
		session = getSqlSession();
		member2=session.selectOne("Member.pwSearchMember",member);

		return member2;
	}
	
	@Override
	public  Member login(Member member){
		SqlSession session=null;
		Member member2= null;
		session = getSqlSession();
		member2=session.selectOne("Member.login",member);
		
		return member2;
	}
	
	@Override
	public  Member selsctMember(String memberid){
		SqlSession session=null;
		Member member2= null;
		session = getSqlSession();
		member2=session.selectOne("Member.selectMember",memberid);

		return member2;
	}
}