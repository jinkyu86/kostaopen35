package kr.or.kosta.moviesystem.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import kr.or.kosta.moviesystem.util.ConnectionUtil;



public class MemberDAO {

	/**
	 * ID로 회원을 찾을 수 있는 메서드
	 * 
	 * @param memberid
	 */
	public static Member selectMemberById(String userid) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Member member=null;
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state " +
					"FROM member WHERE userid=?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1,userid);
			rs=psmt.executeQuery();
			if(rs.next()){
				String userNum=rs.getString(1);
				userid=rs.getString(2);
				String name=rs.getString(3);
				String pw=rs.getString(4);
				String email=rs.getString(5);
				String phone=rs.getString(6);
				String zipcode=rs.getString(7);
				String addr=rs.getString(8);
				Date regDate=rs.getDate(9);
				String memState=rs.getString(10);
				
				member=new Member();
				member.setUserNum(userNum);
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				member.setRegDate(regDate);
				member.setMemState(memState);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	/**
	 * 회원 입력하기
	 * 
	 * @param member
	 */
	public static void insertMember(Member member) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try{	
			psmt=con.prepareStatement(
					"INSERT INTO MEMBER" +
					"(user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state)" +
					"VALUES (mem_seq.nextval,?,?,?,?,?,?,?,sysdate,'1')"
					);
			psmt.setString(1,member.getUserid());
			psmt.setString(2,member.getName());
			psmt.setString(3,member.getPw());
			psmt.setString(4,member.getEmail());
			psmt.setString(5,member.getPhone());
			psmt.setString(6,member.getZipcode());
			psmt.setString(7,member.getAddr());
			
			psmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	/**
	 * 회원수정
	 * 
	 * @param memberid
	 * @param pw
	 */
	public static void editMember(Member member) {
		 Connection con=null;
		 PreparedStatement psmt=null;
		 con=ConnectionUtil.getConnection();
		 
		 try {
			 psmt=con.prepareStatement
					  ("UPDATE MEMBER SET pw=?,email=?,phone=?,zipcode=?,addr=? " +
					  	"WHERE userid=?");
			 psmt.setString(1, member.getPw());
			 psmt.setString(2,member.getEmail());
			 psmt.setString(3,member.getPhone());
			 psmt.setString(4,member.getZipcode());
			 psmt.setString(5,member.getAddr());
			 psmt.setString(6,member.getUserid());
			 
			 psmt.executeUpdate();
		 }catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * 회원 탈퇴
	 * 
	 * @param memberid
	 * @param pw
	 */
	public static void dropMember(Member member) {
		 Connection con=null;
		 PreparedStatement psmt=null;
		 con=ConnectionUtil.getConnection();
		 
		 try {
			 psmt=con.prepareStatement
					  ("UPDATE MEMBER " +
					  	"SET name=?,pw=?,email=?,phone=?,zipcode=?,addr=?," +
					  	"mem_state='2',drop_reason=?,drop_date=sysdate WHERE userid=?");
			 
			 psmt.setString(1,"  ");
			 psmt.setString(2,"  ");
			 psmt.setString(3,"  ");
			 psmt.setString(4,"  ");
			 psmt.setString(5,"  ");
			 psmt.setString(6,"  ");
			 psmt.setString(7,member.getDropReason());
			 psmt.setString(8,member.getUserid());
		
			 
			 psmt.executeUpdate();
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	/**
	 * 전체 회원 리스트를 볼 수 있는 메서드
	 * 
	 * @param length
	 * @param page
	 */
	public static ArrayList<Member> selectMemberList(int length, int page) {
		 Connection con = null;
		 String sql = null;
		 ResultSet rs = null;
		 PreparedStatement psmt=null;
		 ArrayList<Member>memberList=new ArrayList<Member>();
		 
		 try{
			 con = ConnectionUtil.getConnection();
			 sql="SELECT user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state " +
					 "FROM member";
			 psmt = con.prepareStatement
						(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 rs = psmt.executeQuery();
			 
			 if(page>1){
					rs.absolute((page-1)*length);
					}
			 int getRecordCount=0;
			 while(rs.next()&&getRecordCount<length){
				 getRecordCount++;
				 String userNum=rs.getString(1);
				 String userid=rs.getString(2);
				 String name=rs.getString(3);
				 String pw=rs.getString(4);
					String email=rs.getString(5);
					String phone=rs.getString(6);
					String zipcode=rs.getString(7);
					String addr=rs.getString(8);
					Date regDate=rs.getDate(9);
					String memState=rs.getString(10);
					
					Member member=new Member();
					member.setUserNum(userNum);
					member.setUserid(userid);
					member.setName(name);
					member.setPw(pw);
					member.setEmail(email);
					member.setPhone(phone);
					member.setZipcode(zipcode);
					member.setAddr(addr);
					member.setRegDate(regDate);
					member.setMemState(memState);
					
					memberList.add(member);
					
			 }
			 
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		 
		return memberList;
	}

	/**
	 * 전체 회원의 수를 알 수 있는 메서드
	 */
	public static int selectMemberListCount() {
		 Connection con = null;
		 PreparedStatement psmt=null;
		 String sql = null;
		 ResultSet rs = null;
		 int memberCount=0;
		 try {
			 con = ConnectionUtil.getConnection();
			 sql="SELECT count(userid)" +
			 		"FROM member";
			 psmt = con.prepareStatement(sql);
			 rs = psmt.executeQuery();
				
			 if(rs.next()){
					memberCount=rs.getInt(1);
				}
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		return memberCount;
	}

	/**
	 * 이름으로 회원 찾기
	 * 
	 * @param length
	 * @param page
	 * @param name
	 */
	public static ArrayList<Member> searchMemberListByName(int length, int page, String name) {
		Connection con = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement psmt=null;
		ArrayList<Member>memberList=new ArrayList<Member>();
		
		 try {
			 con = ConnectionUtil.getConnection();
			 sql="SELECT user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state " +
			 		"FROM member WHERE name like ?";
			 
			 psmt = con.prepareStatement
						(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 psmt.setString(1,"%"+name+"%");
			 rs = psmt.executeQuery();
			 
			 if(page>1){
					rs.absolute((page-1)*length);
					}
			 int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String userNum=rs.getString(1);
				String userid=rs.getString(2);
				name=rs.getString(3);
				String pw=rs.getString(4);
				String email=rs.getString(5);
				String phone=rs.getString(6);
				String zipcode=rs.getString(7);
				String addr=rs.getString(8);
				Date regDate=rs.getDate(9);
				String memState=rs.getString(10);
				
				Member member=new Member();
				member.setUserNum(userNum);
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				member.setRegDate(regDate);
				member.setMemState(memState);
				
				memberList.add(member);
			}
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		return memberList;
	}

	/**
	 * 이름으로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param name
	 */
	public static int searchMemberListByNameCount(String name) {
		 Connection con = null;
		 String sql = null;
		 ResultSet rs = null;
		 PreparedStatement psmt=null;
		 int  memberCount=0;
		 
		 try{
			 con = ConnectionUtil.getConnection();
			 sql="SELECT count(name)" +
			 		"FROM member WHERE name like ?";
			 psmt = con.prepareStatement(sql);
			 psmt.setString(1,"%"+name+"%");
			 rs = psmt.executeQuery();
			 
			 if(rs.next()){
				 memberCount=rs.getInt(1);
				}
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		
		return memberCount;
	}

	/**
	 * 핸드폰번호로 회원을 찾을 수 있는 기능
	 * 
	 * @param length
	 * @param page
	 * @param phone
	 */
	public static ArrayList<Member> searchMemberListByPhone(int length, int page, String phone) {
		Connection con = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement psmt=null;
		ArrayList<Member>memberList=new ArrayList<Member>();
		
		 try {
			 con = ConnectionUtil.getConnection();
			 sql="SELECT user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state " +
			 		"FROM member WHERE phone like ?";
			 
			 psmt = con.prepareStatement
						(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 psmt.setString(1,"%"+phone+"%");
			 rs = psmt.executeQuery();
			 
			 if(page>1){
					rs.absolute((page-1)*length);
					}
			 int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String userNum=rs.getString(1);
				String userid=rs.getString(2);
				String name=rs.getString(3);
				String pw=rs.getString(4);
				String email=rs.getString(5);
				phone=rs.getString(6);
				String zipcode=rs.getString(7);
				String addr=rs.getString(8);
				Date regDate=rs.getDate(9);
				String memState=rs.getString(10);
				
				Member member=new Member();
				member.setUserNum(userNum);
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				member.setRegDate(regDate);
				member.setMemState(memState);
				
				memberList.add(member);
			}
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		return memberList;
	}

	/**
	 * 전화번호로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param phone
	 */
	public static int searchMemberListByPhoneCount(String phone) {
		 Connection con = null;
		 String sql = null;
		 ResultSet rs = null;
		 PreparedStatement psmt=null;
		 int  memberCount=0;
		 
		 try{
			 con = ConnectionUtil.getConnection();
			 sql="SELECT count(phone)" +
			 		"FROM member WHERE phone like ?";
			 psmt = con.prepareStatement(sql);
			 psmt.setString(1,"%"+phone+"%");
			 rs = psmt.executeQuery();
			 
			 if(rs.next()){
				 memberCount=rs.getInt(1);
				}
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		
		return memberCount;
	}

	/**
	 * 이메일로 회원 찾기 기능
	 * 
	 * @param length
	 * @param page
	 * @param email
	 */
	public static ArrayList<Member> searchMemberListByEmail(int length, int page, String email) {
		Connection con = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement psmt=null;
		ArrayList<Member>memberList=new ArrayList<Member>();
		
		 try {
			 con = ConnectionUtil.getConnection();
			 sql="SELECT user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state " +
			 		"FROM member WHERE email like ?";
			 
			 psmt = con.prepareStatement
						(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 psmt.setString(1,"%"+email+"%");
			 rs = psmt.executeQuery();
			 
			 if(page>1){
					rs.absolute((page-1)*length);
					}
			 int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String userNum=rs.getString(1);
				String userid=rs.getString(2);
				String name=rs.getString(3);
				String pw=rs.getString(4);
				email=rs.getString(5);
				String phone=rs.getString(6);
				String zipcode=rs.getString(7);
				String addr=rs.getString(8);
				Date regDate=rs.getDate(9);
				String memState=rs.getString(10);
				
				Member member=new Member();
				member.setUserNum(userNum);
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				member.setRegDate(regDate);
				member.setMemState(memState);
				
				memberList.add(member);
			}
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		return memberList;
	}

	/**
	 * 이메일로 찾을 회원의 수를 알 수 있는 메서드
	 * 
	 * @param email
	 */
	public static int searchMemberListByEmailCount(String email) {
		 Connection con = null;
		 String sql = null;
		 ResultSet rs = null;
		 PreparedStatement psmt=null;
		 int  memberCount=0;
		 
		 try{
			 con = ConnectionUtil.getConnection();
			 sql="SELECT count(email)" +
			 		"FROM member WHERE email like ?";
			 psmt = con.prepareStatement(sql);
			 psmt.setString(1,"%"+email+"%");
			 rs = psmt.executeQuery();
			 
			 if(rs.next()){
				 memberCount=rs.getInt(1);
				}
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		
		return memberCount;
	}

	/**
	 * 주소로 회원을 찾을 수 있는 기능
	 * 
	 * @param length
	 * @param page
	 * @param addr
	 */
	public static ArrayList<Member> searchMemberListByAddr(int length, int page, String addr) {
		Connection con = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement psmt=null;
		ArrayList<Member>memberList=new ArrayList<Member>();
		
		 try {
			 con = ConnectionUtil.getConnection();
			 sql="SELECT user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state " +
			 		"FROM member WHERE addr like ?";
			 
			 psmt = con.prepareStatement
						(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 psmt.setString(1,"%"+addr+"%");
			 rs = psmt.executeQuery();
			 
			 if(page>1){
					rs.absolute((page-1)*length);
					}
			 int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String userNum=rs.getString(1);
				String userid=rs.getString(2);
				String name=rs.getString(3);
				String pw=rs.getString(4);
				String email=rs.getString(5);
				String phone=rs.getString(6);
				String zipcode=rs.getString(7);
				addr=rs.getString(8);
				Date regDate=rs.getDate(9);
				String memState=rs.getString(10);
				
				Member member=new Member();
				member.setUserNum(userNum);
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				member.setRegDate(regDate);
				member.setMemState(memState);
				
				memberList.add(member);
			}
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		return memberList;
	}

	/**
	 * 주소로 찾은 회원의 수를 알 수 있는 메서드
	 * 
	 * @param addr
	 */
	public static int searchMemberListByAddrCount(String addr) {
		 Connection con = null;
		 String sql = null;
		 ResultSet rs = null;
		 PreparedStatement psmt=null;
		 int  memberCount=0;
		 
		 try{
			 con = ConnectionUtil.getConnection();
			 sql="SELECT count(addr)" +
			 		"FROM member WHERE addr like ?";
			 psmt = con.prepareStatement(sql);
			 psmt.setString(1,"%"+addr+"%");
			 rs = psmt.executeQuery();
			 
			 if(rs.next()){
				 memberCount=rs.getInt(1);
				}
			 
		 }catch (SQLException e) {
				e.printStackTrace();
			}	
		
		return memberCount;
	}

	/**
	 * 아이디를 잃어버려 회원의 이메일과 이름으로 회원의 아이디를 찾을 수 있는 메서드
	 * 
	 * @param email
	 * @param name
	 */
	public static Member findMemberById(String email, String name) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Member member=null;
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state " +
					"FROM member WHERE email=? AND name=?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1,email);
			psmt.setString(2,name);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				String userNum=rs.getString(1);
				String userid=rs.getString(2);
				name=rs.getString(3);
				String pw=rs.getString(4);
				email=rs.getString(5);
				String phone=rs.getString(6);
				String zipcode=rs.getString(7);
				String addr=rs.getString(8);
				Date regDate=rs.getDate(9);
				String memState=rs.getString(10);
				
				member=new Member();
				member.setUserNum(userNum);
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				member.setRegDate(regDate);
				member.setMemState(memState);
			}
		}catch (SQLException e) {
				e.printStackTrace();
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
	public static Member findMemberByPw(String email, String name, String userid) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Member member=null;
		try{
			con=ConnectionUtil.getConnection();
			sql="SELECT user_num,userid,name,pw,email,phone,zipcode,addr,reg_date,mem_state " +
					"FROM member WHERE email=? AND name=? AND userid=?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1,email);
			psmt.setString(2,name);
			psmt.setString(3,userid);
			
			rs=psmt.executeQuery();
			
			if(rs.next()){
				String userNum=rs.getString(1);
				userid=rs.getString(2);
				name=rs.getString(3);
				String pw=rs.getString(4);
				email=rs.getString(5);
				String phone=rs.getString(6);
				String zipcode=rs.getString(7);
				String addr=rs.getString(8);
				Date regDate=rs.getDate(9);
				String memState=rs.getString(10);
				
				member=new Member();
				member.setUserNum(userNum);
				member.setUserid(userid);
				member.setName(name);
				member.setPw(pw);
				member.setEmail(email);
				member.setPhone(phone);
				member.setZipcode(zipcode);
				member.setAddr(addr);
				member.setRegDate(regDate);
				member.setMemState(memState);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return member;
	}
}
