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



public class MemberDAO {
	
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
	
	/**
	 * ID로 회원을 찾을 수 있는 메서드
	 * 
	 * @param memberid
	 */
	public static Member selectMemberById(String userid) {
		SqlSession session = null;
		Member member=null;
		try{
			session= sqlMapper.openSession(true);
			member=session.selectOne("Member.selectMemberById",userid);
			
		}finally{
			session.close();
		}
		return member;
	}

	/**
	 * 회원 입력하기
	 * 
	 * @param member
	 */
	public static void insertMember(Member member) {
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.insert("Member.insertMember",member);
		}//Exxeption여부와 상관업이 반드시 실행
		finally{
			//Connection을 ConnectionPoll에 반납
			session.close();
		}
	}

	/**
	 * 회원수정
	 * 
	 * @param memberid
	 * @param pw
	 */
	public static void editMember(Member member) {
		SqlSession session = null;
		try{
			session=sqlMapper.openSession(true);
			session.update("Member.editMember",member);
		}finally{
			session.close();
		}
	}

	/**
	 * 회원 탈퇴
	 * 
	 * @param memberid
	 * @param pw
	 */
	public static void dropMember(Member member) {
		SqlSession session = null;
		try{
			session=sqlMapper.openSession(true);
			session.update("Member.dropMember",member);
		}finally{
			session.close();
		}		
	}

	/**
	 * 전체 회원 리스트를 볼 수 있는 메서드
	 * 
	 * @param length
	 * @param page
	 */
	public static List<Member> selectMemberList(int length, int page) {
		SqlSession session = null;
		List<Member> memberList=null;
		try{
			session=sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.selectMemberList",null,rowBounds);
			
		}finally{
			session.close();
		}
		return memberList;
	 }


	/**
	 * 전체 회원의 수를 알 수 있는 메서드
	 */
	public static int selectMemberListCount() {
		SqlSession session = null;
		Integer count=null;
		try{
			session=sqlMapper.openSession(true);
			count=session.selectOne("Member.selectMemberListCount");
			
		}finally{
			session.close();
		}
		return count;
	}

	/**
	 * 이름으로 회원 찾기
	 * 
	 * @param length
	 * @param page
	 * @param name
	 */
	public static List<Member> searchMemberListByName(int length, int page, String name) {
		SqlSession session = null;
		List<Member> memberList=null;
		try{
			session= sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.searchMemberListByName","%"+name+"%",rowBounds);
			
		}finally{
			session.close();
		}
		return memberList;
	}

	/**
	 * 이름으로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param name
	 */
	public static int searchMemberListByNameCount(String name) {
		SqlSession session = null;
		Integer count=null;
		try{
			session=sqlMapper.openSession(true);
			count=session.selectOne("Member.searchMemberListByNameCount","%"+name+"%");
			
		}finally{
			session.close();
		}
		return count;
	}

	/**
	 * 핸드폰번호로 회원을 찾을 수 있는 기능
	 * 
	 * @param length
	 * @param page
	 * @param phone
	 */
	public static List<Member> searchMemberListByPhone(int length, int page, String phone) {
		SqlSession session = null;
		List<Member> memberList=null;
		try{
			session= sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.searchMemberListByPhone","%"+phone+"%",rowBounds);
			
		}finally{
			session.close();
		}
		return memberList;
	}

	/**
	 * 전화번호로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param phone
	 */
	public static int searchMemberListByPhoneCount(String phone) {
		SqlSession session = null;
		Integer count=null;
		try{
			session=sqlMapper.openSession(true);
			count=session.selectOne("Member.searchMemberListByPhoneCount","%"+phone+"%");
			
		}finally{
			session.close();
		}
		return count;
	}

	/**
	 * 이메일로 회원 찾기 기능
	 * 
	 * @param length
	 * @param page
	 * @param email
	 */
	public static List<Member> searchMemberListByEmail(int length, int page, String email) {
		SqlSession session = null;
		List<Member> memberList=null;
		try{
			session= sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.searchMemberListByEmail","%"+email+"%",rowBounds);
			
		}finally{
			session.close();
		}
		return memberList;
	}

	/**
	 * 이메일로 찾을 회원의 수를 알 수 있는 메서드
	 * 
	 * @param email
	 */
	public static int searchMemberListByEmailCount(String email) {
		SqlSession session = null;
		Integer count=null;
		try{
			session=sqlMapper.openSession(true);
			count=session.selectOne("Member.searchMemberListByEmailCount","%"+email+"%");
			
		}finally{
			session.close();
		}
		return count;
	}

	/**
	 * 주소로 회원을 찾을 수 있는 기능
	 * 
	 * @param length
	 * @param page
	 * @param addr
	 */
	public static List<Member> searchMemberListByAddr(int length, int page, String addr) {
		SqlSession session = null;
		List<Member> memberList=null;
		try{
			session= sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.searchMemberListByAddr","%"+addr+"%",rowBounds);
			
		}finally{
			session.close();
		}
		return memberList;
	}

	/**
	 * 주소로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param addr
	 */
	public static int searchMemberListByAddrCount(String addr) {
		SqlSession session = null;
		Integer count=null;
		try{
			session=sqlMapper.openSession(true);
			count=session.selectOne("Member.searchMemberListByAddrCount","%"+addr+"%");
			
		}finally{
			session.close();
		}
		return count;
	}

	/**
	 * 아이디를 잃어버려 회원의 이메일과 이름으로 회원의 아이디를 찾을 수 있는 메서드
	 * 
	 * @param email
	 * @param name
	 */
	public static Member findMemberId(String email, String name) {
		SqlSession session = null;
		Member member=null;
		try{
			session= sqlMapper.openSession(true);
			HashMap<String,String> parameter=new HashMap<String,String>();
			parameter.put("email",email);
			parameter.put("name",name);
			member=session.selectOne("Member.findIdMember",parameter);
			
		}finally{
			session.close();
		}
		return member;
	}

	/**
	 * 회원이 비밀번호를 잃어버려 회원의 이메일, 이름, 아이디로 회원의 비밀번호를 찾을 수 있는 메서드
	 * 
	 * @param email
	 * @param name
	 * @param id
	 */
	public static Member findMemberPw(String email, String name, String userid) {
		SqlSession session = null;
		Member member=null;
		try{
			session= sqlMapper.openSession(true);
			HashMap<String,String> parameter=new HashMap<String,String>();
			parameter.put("email",email);
			parameter.put("name",name);
			parameter.put("userid",userid);
			member=session.selectOne("Member.findIdMember",parameter);
			
		}finally{
			session.close();
		}
		return member;
	}


}
