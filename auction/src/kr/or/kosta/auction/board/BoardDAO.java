package kr.or.kosta.auction.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.util.ConnectionUtil;

public class BoardDAO {

	public static void insertBoard(Board board) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try{	
			psmt=con.prepareStatement(
					" INSERT INTO board " +
					"  (b_num, userid, title, content) " +
					"   VALUES (board_seq.nextval,?,?,?)");
			psmt.setString(1, board.getMember().getUserid());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getContent());
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void updateBoard(Board board) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try{	
			psmt=con.prepareStatement(
					" UPDATE board " +
					" SET title=?," +
					" content=?" +
					" WHERE b_num=?" );
			
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getbNum());
			
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deleteBoard(String bNum) {
		Connection con = null;
		PreparedStatement psmt = null;
		con = ConnectionUtil.getConnection();
		try {
			psmt = con.prepareStatement(" DELETE FROM board "
					+ " WHERE b_num = ? ");
			psmt.setString(1, bNum);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Board selectBoard(String bNum) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Board board=null;
		try {
			con=ConnectionUtil.getConnection();
			sql=" SELECT b.b_num, m.userid, b.title, b.content " +
					" FROM board b, member m " +
					" WHERE b.userid=m.userid AND b_num=? ";
			
				psmt=con.prepareStatement(sql);
				psmt.setString(1,bNum);
				rs=psmt.executeQuery();
				while(rs.next()){
					
					String userid=rs.getString(2);
					String title=rs.getString(3);
					String content=rs.getString(4);
					
					board=new Board();
					board.setbNum(bNum);
					board.setTitle(title);
					board.setContent(content);
					
					Member member=new Member();
					member.setUserid(userid);
					
					board.setMember(member);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	public static ArrayList<Board> selectBoardList() {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ArrayList<Board>boardList=new ArrayList<Board>();
		Board board=null;
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(
					" SELECT b.b_num, m.userid, b.title, b.content " +
					" FROM board b, member m " +
					" WHERE b.userid=m.userid " +
					" ORDER BY b.b_num DESC");
			rs=psmt.executeQuery();
			while(rs.next()){
				String bNum=rs.getString(1);
				String userid=rs.getString(2);
				String title=rs.getString(3);
				String content=rs.getString(4);
				
				board=new Board();
				board.setbNum(bNum);
				board.setTitle(title);
				board.setContent(content);
				
				Member member=new Member();
				member.setUserid(userid);
				
				board.setMember(member);
				
				boardList.add(board);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	public static ArrayList<Board> selectBoardList(int length, int page) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Board board=null;
		Member member=null;
		ArrayList<Board>boardList=new ArrayList<Board>();

		try {
			con=ConnectionUtil.getConnection();
			sql=" SELECT b_num, title, content, userid " +
					"FROM board ";
			
			psmt=con.prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			
			int getRecordCount=0;
			
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String bNum=rs.getString(1);
				String title=rs.getString(2);
				String content=rs.getString(3);
				String userid=rs.getString(4);
				
				board=new Board();
				
				board.setbNum(bNum);
				board.setTitle(title);
				board.setContent(content);
				
				member=new Member();
				
				member.setUserid(userid);
				board.setMember(member);
				
				boardList.add(board);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	public static int selectBoardCount(){
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		int boardCount=0;
		try {
			con=ConnectionUtil.getConnection();
			sql=" SELECT  count(b_num) " +
					"  FROM  board ";
			
				psmt=con.prepareStatement(sql);
				rs=psmt.executeQuery();
				if(rs.next()){
					boardCount=rs.getInt(1);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardCount;
	}

	public static ArrayList<Board> selectBoardListByTitle(int length, int page, String title) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Board board=null;
		Member member=null;
		ArrayList<Board>boardList=new ArrayList<Board>();
		con=ConnectionUtil.getConnection();
		try {
		sql="SELECT b_num, title, content, userid "+
			  "FROM board "+
			  "WHERE title LIKE ?";
		
			psmt=con.prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, "%"+title+"%");
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			
			int getRecordCount=0;
			
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String bNum=rs.getString(1);
				title=rs.getString(2);
				String content=rs.getString(3);
				String userid=rs.getString(4);
				
				board=new Board();
				
				board.setbNum(bNum);
				board.setTitle(title);
				board.setContent(content);
				
				member=new Member();
				member.setUserid(userid);
				board.setMember(member);
				
				boardList.add(board);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	public static int selectBoardListByTitleCount(String title) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		con=ConnectionUtil.getConnection();
		int boardCount=0;
		try {
		sql="SELECT COUNT(b_num) "+
			  "FROM board " +
			  "WHERE title LIKE ?";
		psmt=con.prepareStatement(sql);
		psmt.setString(1, "%"+title+"%");
		rs=psmt.executeQuery();
		
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardCount;
	}

	public static ArrayList<Board> selectBoardListByUserid(int length, int page, String userid) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		Board board=null;
		Member member=null;
		ArrayList<Board>boardList=new ArrayList<Board>();
		con=ConnectionUtil.getConnection();
		
		try {
		sql="SELECT b.b_num, b.title, b.content, b.userid "+
			  "FROM board b, member m "+
			  "WHERE b.userid=m.userid AND b.userid LIKE ?";
		
			psmt=con.prepareStatement(sql, 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			psmt.setString(1, "%"+userid+"%");
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			
			int getRecordCount=0;
			
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String bNum=rs.getString(1);
				String title=rs.getString(2);
				String content=rs.getString(3);
				userid=rs.getString(4);
				
				board=new Board();
				member=new Member();
				
				board.setbNum(bNum);
				board.setTitle(title);
				board.setContent(content);
				
				member.setUserid(userid);
				board.setMember(member);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	public static int selectBoardListByUseridCount(String userid) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql=null;
		ResultSet rs=null;
		con=ConnectionUtil.getConnection();
		int boardCount=0;
		try {
		sql="SELECT COUNT(b.b_num) "+
				  "FROM board b, member m "+
				  "WHERE b.userid=m.userid AND b.userid LIKE ?";
				psmt=con.prepareStatement(sql);
				psmt.setString(1, "%"+userid+"%");
				rs=psmt.executeQuery();
				
					if(rs.next()){
						boardCount=rs.getInt(1);
					}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		return boardCount;
		}
}

