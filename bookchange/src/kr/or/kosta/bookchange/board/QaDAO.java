package kr.or.kosta.bookchange.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class QaDAO {

	/**
	 * 상품문의 내용 보기	 */
	public static ArrayList<Qa> selectQaList(int length, int page, String boardNo) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Qa> qaList=new ArrayList<Qa>();
		
		try {

			con=ConnectionUtil.getConnection();
			sql="select q.email, qa_content, qa_no, q.board_no " +
					"from tb_qa q, tb_member m, tb_board b " +
					"where b.board_no=q.board_no " +
					"and m.email=q.email " +
					"and q.board_no=? " +
					"order by q.qa_no asc";
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, boardNo);
			
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String email=rs.getString(1);
				String qaContent=rs.getString(2);
				String qaNo=rs.getString(3);
				
				Qa qa=new Qa();
				
				qa.setQaNo(Integer.parseInt(qaNo));
				qa.setQaContent(qaContent);
				
				Member member=new Member();
				member.setEmail(email);
				qa.setMember(member);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				qa.setBoard(board);
				
				qaList.add(qa);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qaList;
	}

	/**
	 * 상품문의 추가	 */
	public static void insertQa(Qa qa) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try{
		con=ConnectionUtil.getConnection();
		sql="insert into tb_qa (qa_no, email, qa_content, board_no)" +
				" values (qa_seq.nextval,?,?,?)";
		ps=con.prepareStatement(sql);
		
		ps.setString(1, qa.getMember().getEmail());
		ps.setString(2, qa.getQaContent());
		ps.setInt(3, qa.getBoard().getBoardNo());
		ps.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	/**	 * 상품문의 수정 */
	public static void updateQa(Qa qa) {
		Connection con=null;
		PreparedStatement ps=null;
		
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement("update tb_qa " +
					                "set qa_content=? " +
					                "where qa_no=?");
			ps.setString(1, qa.getQaContent());
			ps.setInt(2, qa.getQaNo());
			ps.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**	 * 상품문의 삭제(직접 삭제했을때)	 */
	public static void deleteQabyQaNo(String qaNo) {
		Connection con=null;
		PreparedStatement ps=null;
		
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement
					("delete tb_qa where qa_no=?");
			ps.setString(1, qaNo);
			ps.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	}
	
	/**	 * 상품문의 삭제(관련 게시물이 삭제됐을때)	 */
	public static void deleteQabyBoardNo(String boardNo) {
		Connection con=null;
		PreparedStatement ps=null;
		
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement
					("delete tb_qa where board_No=?");
			ps.setString(1, boardNo);
			ps.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	}

	/**
	 * 상품문의 카운트 수	 */
	public static int selectQaCount(String boardNo) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int qaCount=0;
		
		try {
	
			con=ConnectionUtil.getConnection();
			sql="select count(qa_no) " +
					"from tb_qa q, tb_member m, tb_board b " +
					"where b.board_no=q.board_no " +
					"and m.email=q.email " +
					"and q.board_no=?";
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, boardNo);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				qaCount=rs.getInt(1);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qaCount;
	}
}
