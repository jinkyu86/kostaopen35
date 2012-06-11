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
	 * ID로 회원을 찾을 수 있는 메서드
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
	 * 회원 입력하기
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
	 * 회원수정
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
	 * 회원 탈퇴
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
	 * 전체 회원 리스트를 볼 수 있는 메서드
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
	 * 전체 회원의 수를 알 수 있는 메서드
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
	 * 이름으로 회원 찾기
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
	 * 이름으로 찾은 회원의 수를 알 수 있는 메서드
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
	 * 핸드폰번호로 회원을 찾을 수 있는 기능
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
	 * 전화번호로 찾은 회원의 수를 알 수 있는 메서드
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
	 * 이메일로 회원 찾기 기능
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
	 * 이메일로 찾을 회원의 수를 알 수 있는 메서드
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
	 * 주소로 회원을 찾을 수 있는 기능
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
	 * 주소로 찾은 회원의 수를 알 수 있는 메서드
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
	 * 아이디를 잃어버려 회원의 이메일과 이름으로 회원의 아이디를 찾을 수 있는 메서드
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
	 * 회원이 비밀번호를 잃어버려 회원의 이메일, 이름, 아이디로 회원의 비밀번호를 찾을 수 있는 메서드
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
