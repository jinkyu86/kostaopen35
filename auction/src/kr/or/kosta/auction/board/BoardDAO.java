package kr.or.kosta.auction.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			
			psmt.setString(1,board.getTitle());
			psmt.setString(2,board.getContent());
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
					" WHERE b.userid=m.userid ");
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
		ArrayList<Board>boardList=
				new ArrayList<Board>();
		Board board = null;
		try {
			con=ConnectionUtil.getConnection();
			sql=" SELECT b_num, userid, title, content " +
					"  FROM board ";
			
				psmt=con.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()){
					String bNum=rs.getString(1);
					String userid=rs.getString(2);
					String title=rs.getString(3);
					String content=rs.getString(4);
					
					board = new Board();
					board.setbNum(bNum);
					board.setTitle(title);
					board.setContent(content);
					
					Member member = new Member();
					member.setUserid(userid);
					
					board.setMember(member);
					
					boardList.add(board);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	public static ArrayList<Board> selectBoardListByTitle(int length, int page, String title) {
		
		return null;
	}

	/**
	 * @param title
	 */
	public static int selectBoardListByTitleCount(String title) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * @param length
	 * @param page
	 * @param name
	 */
	public static ArrayList<Board> selectBoardListByName(int length, int page, String name) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param name
	 */
	public static int selectBoardListByNameCount(String name) {
		/* default generated stub */;
		return 0;
	}

	/**
	 * @param length
	 * @param page
	 * @param userid
	 */
	public ArrayList<Board> selectBoardListByUserid(int length, int page, String userid) {
		/* default generated stub */;
		return null;
	}

	/**
	 * @param userid
	 */
	public static int selectBoardListByUseridCount(String userid) {
		/* default generated stub */;
		return 0;
	}
}
