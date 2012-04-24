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


import kr.or.kosta.util.ConnectionUtil;

public class MemberDAO implements IMemberDAO{
	
	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
			try {
				sqlReader=Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(sqlReader);
	
	//회원가입
	@Override
	public  void insertMember(Member member) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.insert("Member.insertMember",member);
		}finally{
			session.close();
		}
	}
	
	//회원정보수정
	@Override
	public  void updateMember(Member member) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.update("Member.updateMember",member);
		}finally{
			session.close();
		}	
	}
	
	//회원삭제
	@Override
	public  void deleteMember(String memberId) {
			SqlSession session=null;
			try{
			session = sqlMapper.openSession(true);
			session.delete("Member.deleteMember",memberId);
			}finally{
				session.close();
			}	
		}
	//아이디찾기 회원이름,주민등록번호가 일치하는 아이디찾기
	@Override
	public  Member selectMemberByid(Member member) {
			SqlSession session=null;
			Member member2= null;
			try{
			session = sqlMapper.openSession(true);
			member2=session.selectOne("Member.idSearchMember",member);
			}finally{
				session.close();
			}
			return member2;
	}

	//패스워드 찾기
	@Override
	public  Member selectMemberBypw(Member member) {
		SqlSession session=null;
		Member member2= null;
		try{
		session = sqlMapper.openSession(true);
		member2=session.selectOne("Member.pwSearchMember",member);
		}finally{
			session.close();
		}
		return member2;
	}
	
	@Override
	public  Member login(Member member){
		SqlSession session=null;
		Member member2= null;
		try{
		session = sqlMapper.openSession(true);
		member2=session.selectOne("Member.login",member);
		}finally{
			session.close();
		}
		return member2;
	}
	
	@Override
	public  Member selsctMember(String memberid){
		SqlSession session=null;
		Member member2= null;
		try{
		session = sqlMapper.openSession(true);
		member2=session.selectOne("Member.selectMember",memberid);
		}finally{
			session.close();
		}
		return member2;
	}
}