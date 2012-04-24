package kr.or.kosta.auction.board;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



//import kr.or.kosta.util.ConnectionUtil;

public class BoardDAO {
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
	
	public static String insertBoard(Board board){
		SqlSession session = sqlMapper.openSession(true);
		session.insert("Board.insertBoard",board);
		return board.getbNum();
	}
	public static void updateBoard(
			 Board board){
		SqlSession session = null;
		try{
		session = sqlMapper.openSession(true);
		session.insert("Board.updateBoard",board);
		}
		finally{
			session.close();
		}
		
	}
	public static void deleteBoard(String boardno){
		SqlSession session = null;
		try{
		session = sqlMapper.openSession(true);
		session.delete("Board.updateBoard",boardno);
		}
		finally{
			session.close();
		}
	}
	public static Board selectBoard(String boardno){
		SqlSession session = null;
		Board board = null;
		try{
		session = sqlMapper.openSession(true);
		board = session.selectOne("selectBoard",boardno);
		
		}
		finally{
			session.close();
		}
		return board;
	}
	public static List<Board> selectBoardList(){
		SqlSession session = null;
		List<Board> boardList = null;
		try{
		session = sqlMapper.openSession(true);
		boardList = session.selectList("selectBoardList");
		
		}
		finally{
			session.close();
		}
		return boardList;
	}
	public static List<Board> selectBoardList(int page,int length){
		SqlSession session = null;
		List<Board> boardList = null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds = new RowBounds((page-1)*length,length);
		boardList = 
				session.selectList("selectBoardList",null,rowBounds);
		
		}
		finally{
			session.close();
		}
		return boardList;
	}

	public static int selectBoardCount(){
		SqlSession session= null;
		int count = 0;
		try{
		session = sqlMapper.openSession(true);
		count = 
				session.selectOne("selectBoardCount");
		
		}
		finally{
			session.close();
		}
		return count;
	}
	
	public static int selectBoardListByTitleCount(String title){
		SqlSession session= null;
		int count = 0;
		try{
		session = sqlMapper.openSession(true);
		count = 
				session.selectOne("selectBoardListByTitleCount","%"+title+"%");
		
		}
		finally{
			session.close();
		}
		return count;
	}
	
	public static int selectBoardListByUseridCount(String userid){
		SqlSession session = null;
		int count = 0;
		try{
		session = sqlMapper.openSession(true);
		count = 
				session.selectOne("selectBoardListByUseridCount","%"+userid+"%");
		}
		finally{
			session.close();
		}
		return count;
	}
	
	public static List<Board> selectBoardListByTitle(int page,int length,String title){
		SqlSession session = null;
		List<Board> boardList = null;
		try{		
		session = sqlMapper.openSession(true);
		RowBounds rowBounds = new RowBounds((page-1)*length,length);
		boardList = 
				session.selectList("selectBoardListByTitle","%"+title+"%",rowBounds);
		
		}
		finally{
			session.close();
		}
		return boardList;
	}
	public static List<Board> selectBoardListByUserid(int page,int length,String userid){
		SqlSession session = null;
		List<Board> boardList = null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds = new RowBounds((page-1)*length,length);
		boardList = 
				session.selectList("selectBoardListByUserid","%"+userid+"%",rowBounds);
		}
		finally{
			session.close();
		}
		return boardList;
	}
}
