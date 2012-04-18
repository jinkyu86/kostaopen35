package kr.or.kosta.bookchange.member;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.servlet.ServletException;



import kr.or.kosta.util.ConnectionUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
		try{
		sqlReader=Resources.getResourceAsReader(resource);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static SqlSessionFactory sqlMapper=
			new SqlSessionFactoryBuilder().build(sqlReader);
	
	/**
	 * 회원가입시 DB에 추가
	 * 
	 * @param member
	 */
	public static void insertMember(Member member) {
		SqlSession session =null;
		try{
		session=sqlMapper.openSession(true);
		session.insert("Member.insertMember",member);
		}finally{
			session.close();
		}
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
	public static void updateMember(
			 Member member){
		SqlSession session =null;
		try{
		session=sqlMapper.openSession(true);
		session.update("Member.updateMember",member);
		}finally{
			session.close();
		}
	 
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
	 * 회원탈퇴(DB에서 삭제)
	 * 
	 * @param email
	 */

	public static void deleteMember(
			 String email){
		SqlSession session =null;
		try{
		session=sqlMapper.openSession(true);
		session.delete("Member.deleteMember",email);
		}finally{
			session.close();
		}
	 
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
	 * 전체 회원수 리턴
	 */
	
	public static int selectMemberCount(){
		SqlSession session =null;
		Integer count=null;
		try{
		session=sqlMapper.openSession(true);
		count=session.selectOne("Member.selectMemberCount");
		//조회 결과가 1건또는 0건일때
		//selectOne(쿼리ID,파라미터 변수)
		//select쿼리를 실행하고 Vo객체 생성 조회 결과 속성에 담아서 리턴
		//-조회결과가 2건 이상이면 실행에러
		}finally{
			session.close();
		}
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
	 * (관리자 전용)회원명단 조회
	 * 
	 * @param length
	 * @param page
	 */
	public static List <Member> selectMemberList(
			 int page,int length){
		SqlSession session =null;
		 
		List<Member> memberList;
		try {
			session=sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("selectMember",null,rowBounds);
				
		} finally {
			// TODO: handle exception
			session.close();
		}
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
//		//가져온 레코드 개수
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
	 * 전체 회원 수 보기(이메일)
	 */
	public static int selectMemberCountemail(String email){
		SqlSession session =null;
		Integer count=null;
		try{
		session=sqlMapper.openSession(true);
		count=session.selectOne("Member.selectMemberCountemail",email);
		//조회 결과가 1건또는 0건일때
		//selectOne(쿼리ID,파라미터 변수)
		//select쿼리를 실행하고 Vo객체 생성 조회 결과 속성에 담아서 리턴
		//-조회결과가 2건 이상이면 실행에러
		}finally{
			session.close();
		}
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
	 * 회원정보보기
	 * 
	 * @param email
	 */

	public static Member selectMemberemail(String email){
		SqlSession session=null;
		Member member=null;
		try{
			session=sqlMapper.openSession(true);
			member=session.selectOne("selectMemberemail",email);
		}finally{
			session.close();
		}
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
	 * 전체 명단 (이메일로 검색)
	 * 
	 * @param length
	 * @param page
	 */
	public static List <Member> selectMemberListByEmail(
			 int page,int length,String email){
		SqlSession session =null;
		 
		List<Member> memberList;
		try {
			session=sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			memberList=session.selectList("Member.selectMemberListByEmail","%"+email+"%",rowBounds);
				
		} finally {
			// TODO: handle exception
			session.close();
		}
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
//			//가져온 레코드 개수
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
	 * 회원 비밀번호 리턴(전화번호와 이메일로 검색)
	 */
	public static Member selectMemberListByPw(String email,String tel){
		SqlSession session=null;
		Member member=null;
		try{
			session=sqlMapper.openSession(true);
			HashMap<String, String> parameters=new HashMap<String, String>();
			parameters.put("email", email);
			parameters.put("tel", tel);
			member=session.selectOne("Member.selectMemberListByPw",parameters);
		}finally{
			session.close();
		}
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
	 * 전화번호로 이메일 검색
	 * @param request
	 * @param response
	 * @return 
	 * @throws IOException
	 * @throws ServletException
	 */
	public static Member selectMemberemailTel(String tel){
		SqlSession session=null;
		Member member=null;
		try{
			session=sqlMapper.openSession(true);
			member=session.selectOne("selectMemberListByTel",tel);
		}finally{
			session.close();
		}
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