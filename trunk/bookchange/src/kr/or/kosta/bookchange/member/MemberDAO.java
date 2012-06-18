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
	 * 회원가입시 DB에 추가
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
	 * 회원수정
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
	 * 회원탈퇴(DB에서 삭제)
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
	 * 전체 회원수 리턴
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
	 * 회원정보보기
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
	 * 회원 비밀번호 리턴(전화번호와 이메일로 검색)
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
	 * 전화번호로 이메일 검색
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
	 * (관리자 전용)회원명단 조회
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
	 * 전체 명단 (전화번호로 검색)
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
	 * 전체 명단 (이메일로 검색)
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
	 * 이메일 갯수 
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