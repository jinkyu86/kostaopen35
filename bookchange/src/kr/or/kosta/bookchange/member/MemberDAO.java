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
		memberList=session.selectList("selectMember",null,rowBounds);
				
		return memberList;
	}

	/**
	 * 전체 회원 수 보기(이메일)
	 */
	@Override
	public int selectMemberCountemail(String email){
		Integer count=null;
		SqlSession session =null;
		session=getSqlSession();

		count=session.selectOne("Member.selectMemberCountemail",email);
		//조회 결과가 1건또는 0건일때
		//selectOne(쿼리ID,파라미터 변수)
		//select쿼리를 실행하고 Vo객체 생성 조회 결과 속성에 담아서 리턴
		//-조회결과가 2건 이상이면 실행에러
		return count;
	}

	
	/**
	 * 회원정보보기
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
	 * 전체 명단 (이메일로 검색)
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