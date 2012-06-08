package kr.or.kosta.bookchange.board;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class QaDAO extends SqlSessionDaoSupport implements IQaDAO {
	
	@Override
	/**
	 * 상품문의 내용 보기	 */
	public List<Qa> selectQaList(int length, int page, String boardNo) {
		SqlSession session=null;
		List<Qa> qaList=null;
		
			session=getSqlSession();
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			qaList=session.selectList("Qa.selectQaList",boardNo,rowBounds);
		
		return qaList;
		/*Connection con=null;
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
		return qaList;*/
	}
	@Override
	/**
	 * 상품문의 추가	 */
	public void insertQa(Qa qa) {
		SqlSession session=null;
		
			session=getSqlSession();
			session.insert("insertQa",qa);
		
		
		/*Connection con=null;
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
		}*/
	}
	@Override
	/**	 * 상품문의 수정 */
	public void updateQa(Qa qa) {
		SqlSession session=null;
		
			session=getSqlSession();
			session.update("updateQa",qa);
		
		/*Connection con=null;
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
		
		*/
	}
	@Override
	/**	 * 상품문의 삭제(직접 삭제했을때)	 */
	public void deleteQabyQaNo(String qaNo) {
		SqlSession session=null;
		
			session=getSqlSession();
			session.delete("deleteQa",qaNo);
		
		
		/*Connection con=null;
		PreparedStatement ps=null;
		
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement
					("delete tb_qa where qa_no=?");
			ps.setString(1, qaNo);
			ps.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
				
	}
	@Override
	/**	 * 상품문의 삭제(관련 게시물이 삭제됐을때)	 */
	public void deleteQabyBoardNo(String boardNo) {
		SqlSession session=null;
		
			session=getSqlSession();
			session.delete("deleteQaByBoardNo",boardNo);
		
		
		/*	Connection con=null;
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
		*/
				
	}
	@Override
	/**
	 * 상품문의 카운트 수	 */
	public int selectQaCount(String boardNo) {
		SqlSession session=null;
		int count;
		
			session=getSqlSession();
			count=session.selectOne("selectQaCount",boardNo);
		
		return count;
	}
	
		/*Connection con=null;
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
	}*/
}
