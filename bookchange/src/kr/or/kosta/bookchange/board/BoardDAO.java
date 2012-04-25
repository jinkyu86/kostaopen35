package kr.or.kosta.bookchange.board;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.bookchange.change.Condition;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class BoardDAO implements IBoardDAO {
	
	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
		try{
			sqlReader=Resources.getResourceAsReader(resource);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(sqlReader);
	@Override
	/**	 * 게시물리스트 조회 */
	
	public List<Board> selectBoardList(int length, int page) {
		SqlSession session=null;
		List<Board> boardList=null;
		try{
			session=sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			boardList=session.selectList("Board.selectBoardList",null,rowBounds);
		}finally{
			session.close();
		}
		return boardList;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, " +
				 "c.category_name, c2.condition_ing, m.tel, m.address, b.board_want " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String boardNo=rs.getString(1);
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String email=rs.getString(4);
				String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String categoryName=rs.getString(7);
				String conditionIng=rs.getString(8);
				String tel=rs.getString(9);
				String address=rs.getString(10);
				String boardWant=rs.getString(11);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				board.setBoardWant(boardWant);
				
				Member member=new Member();
				member.setEmail(email);
				member.setTel(tel);
				member.setAddress(address);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;
		*/
	}
	@Override
	/**	 * 전체게시물 수 리턴 */
	public int selectBoardCount() {
		SqlSession session=null;
		int count;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("selectBoardCount");
		}finally{
			session.close();
		}
		return count;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int boardCount=0;		
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select count(board_no) " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result");
			
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardCount;*/
	}
	@Override
	/**	 * 카테고리별 게시물 조회 */
	public List<Board> selectBoardListbyCategory(int length, int page, String categoryNo) {
		SqlSession session=null;
		List<Board> boardList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		boardList=session.selectList("Board.selectBoardListByCategory",categoryNo,rowBounds);
		}finally{
			session.close();
		}
		return boardList;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, c.category_name, c2.condition_ing " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.category_no=? ");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,categoryNo);
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String boardNo=rs.getString(1);
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String email=rs.getString(4);
				//String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String categoryName=rs.getString(7);
				String conditionIng=rs.getString(8);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				
				Member member=new Member();
				member.setEmail(email);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;*/
	}
	@Override
	/**
	 * 카테고리별 게시물 수 리턴	 */
	public int selectBoardCategoryCount(String categoryNo) {
		SqlSession session=null;
		int count;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("selectBoardListByCategoryCount",categoryNo);
		}finally{
			session.close();
		}
		return count;
	
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int boardCount=0;
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select count(board_no) " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.category_no=? " +
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,categoryNo);
			rs=ps.executeQuery();
			
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardCount;*/
	}
	@Override
	/**
	 * 제목으로 검색한 게시물 조회	 */
	public List<Board> selectBoardListbyTitle(int length, int page, String title) {
		SqlSession session=null;
		List<Board> boardList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		boardList=session.selectList("Board.selectBoardListByTitle","%"+title+"%",rowBounds);
		}finally{
			session.close();
		}
		return boardList;
		
	/*	Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, c.category_name, c2.condition_ing " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.board_title like ? "+
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,"%"+title+"%");
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String boardNo=rs.getString(1);
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String email=rs.getString(4);
				String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String categoryName=rs.getString(7);
				String conditionIng=rs.getString(8);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				
				Member member=new Member();
				member.setEmail(email);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;*/
	}
	@Override
	/**
	 * 제목으로 검색한  게시물 수 리턴	 */
	public int selectBoardTitleCount(String title) {
		SqlSession session=null;
		int count;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("selectBoardListByTitleCount","%"+title+"%");
		}finally{
			session.close();
		}
		return count;
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int boardCount=0;
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select count(board_no) " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.board_title like ?");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,"%"+title+"%");
			rs=ps.executeQuery();
			
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardCount;*/
	}
	@Override
	/**
	 * 게시물 보기	 */
	public Board selectBoard(String boardNo) {
		SqlSession session=null;
		Board board=null;
		try{
			session=sqlMapper.openSession(true);
			board=session.selectOne("Board.selectBoard",boardNo);
		}finally{
			session.close();
		}
		return board;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		Board board=null;		
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result," +
				 "b.board_want, b.board_content, d.deal_no, " +
				 "c.category_name, c2.condition_ing, d.deal_way, m.tel, m.address " +
				 //"q.qa_content, q.email " +
					 "from tb_board b, tb_member m, tb_category c, tb_condition c2, tb_deal d " +
					 "where b.email=m.email " +
					 "and b.category_no=c.category_no " +
					 "and b.condition_result=c2.condition_result " +
					 "and b.deal_no=d.deal_no " +
					// "and b.board_no=q.board_no " +
					 "and b.board_no=?");
			
			ps=con.prepareStatement(sql);
			ps.setString(1, boardNo);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String email=rs.getString(4);
				String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String boardWant=rs.getString(7);
				String boardContent=rs.getString(8);
				String dealNo=rs.getString(9);
				String categoryName=rs.getString(10);
				String conditionIng=rs.getString(11);
				String dealWay=rs.getString(12);
				String tel=rs.getString(13);
				String address=rs.getString(14);
				//String qaContent=rs.getString(13);
				//String qaEmail=rs.getString(14);
				
				board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				board.setBoardWant(boardWant);
				board.setBoardContent(boardContent);
				
				Member member=new Member();
				member.setEmail(email);
				member.setTel(tel);
				member.setAddress(address);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				Deal deal=new Deal();
				deal.setDealNo(Integer.parseInt(dealNo));
				deal.setDealWay(dealWay);
				board.setDeal(deal);
				
				Qa qa=new Qa();
				qa.setQaContent(qaContent);
				Member member2=new Member();
				member2.setEmail(qaEmail);
				qa.setMember(member2);
				
				board.setQa(qa);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return board;	*/
	}
	@Override
	/**
	 * 게시물 추가(물품 등록)	 */
	public void insertBoard(Board board) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.insert("Board.insertBoard",board);
		}finally{
			session.close();
		}
		
		/*Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		
		try {
			ps=con.prepareStatement("insert into tb_board" +
					"(board_no,board_title,board_want,board_photo,board_content," +
					"email,category_no,deal_no,condition_result)" +
					" values(board_seq.nextval,?,?,?,?,?,?,?,0)");
			ps.setString(1, board.getBoardTitle());
			ps.setString(2, board.getBoardWant());
			ps.setString(3, board.getBoardPhoto());
			ps.setString(4, board.getBoardContent());
			ps.setString(5, board.getMember().getEmail());
			ps.setInt(6, board.getCategory().getCategoryNo());
			ps.setInt(7, board.getDeal().getDealNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}
	@Override
	/**
	 * 게시물 수정	 */
	public void updateBoard(Board board) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.update("Board.updateBoard",board);
		}finally{
			session.close();
		}
		
		
		/*Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		
		try {
			ps=con.prepareStatement("update tb_board " +
					                "set board_title=?, board_want=?, board_photo=?, board_content=?," +
					                "category_no=?, deal_no=?, condition_result=? " +
					                " where board_no=?");
			
			ps.setString(1, board.getBoardTitle());
			ps.setString(2, board.getBoardWant());
			ps.setString(3, board.getBoardPhoto());
			ps.setString(4, board.getBoardContent());
			ps.setInt(5, board.getCategory().getCategoryNo());
			ps.setInt(6, board.getDeal().getDealNo());
			ps.setInt(7, board.getCondition().getConditionResult());
			ps.setInt(8, board.getBoardNo());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	@Override
	/**
	 * 게시물 삭제	 */
	public void deleteBoard(String boardNo) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.delete("Board.deleteBoard",boardNo);
		}finally{
			session.close();
		}
		
		/*Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		QaDAO.deleteQabyBoardNo(boardNo);//게시물 삭제됐을때 여기 딸려있던 문의글도 다 삭제해버림
		
		try {
			ps=con.prepareStatement("delete from tb_board where board_no=?");
			ps.setString(1,boardNo);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
	}
	@Override
	/**	 * 자기가 올린 게시물 조회 */
	public List<Board> selectBoardListbyEmail(int length, int page, String email) {
		SqlSession session=null;
		List<Board> boardList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		boardList=session.selectList("Board.selectBoardListByEmail","%"+email+"%",rowBounds);
		}finally{
			session.close();
		}
		return boardList;
		
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, c.category_name, c2.condition_ing " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.email like ? " +
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,"%"+email+"%");
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String boardNo=rs.getString(1);
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String realEmail=rs.getString(4);
				String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String categoryName=rs.getString(7);
				String conditionIng=rs.getString(8);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				
				Member member=new Member();
				member.setEmail(realEmail);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;*/
	}
	@Override
	/**
	 * 자기가 올린 게시물 수 리턴	 */
	public int selectBoardEmailCount(String email) {
		SqlSession session=null;
		int count;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("selectBoardListByEmailCount","%"+email+"%");
		}finally{
			session.close();
		}
		return count;
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int boardCount=0;
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select count(board_no) " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.email like ?");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,"%"+email+"%");
			rs=ps.executeQuery();
			
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardCount;*/
	}
	@Override
	/**	 * 카테고리&제목 게시물 조회 */
	public List<Board> selectBoardListbyCategoryandTitle(int length, int page, String categoryNo, String title) {
		SqlSession session=null;
		List<Board> boardList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		HashMap<String,String> parameters=new HashMap<String,String>();
		parameters.put("categoryNo", categoryNo);
		parameters.put("title", "%"+title+"%");//들어가는 값이 두개 이상일때 요렇게 한다.
		boardList=session.selectList("Board.selectBoardListByCategoryAndTitle",parameters,rowBounds);
		}finally{
			session.close();
		}
		return boardList;
		
		/*	Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, c.category_name, c2.condition_ing " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.category_no=? " +
				 "and b.board_title like ? " +
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,categoryNo);
			ps.setString(2,"%"+title+"%");
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String boardNo=rs.getString(1);
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String email=rs.getString(4);
				//String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String categoryName=rs.getString(7);
				String conditionIng=rs.getString(8);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				
				Member member=new Member();
				member.setEmail(email);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;*/
	}
	@Override
	/**
	 * 카테고리&제목 게시물 수 리턴	 */
	public int selectBoardCategoryandTitleCount(String categoryNo, String title) {
		SqlSession session=null;
		int count;
		try{
		session = sqlMapper.openSession(true);
		HashMap<String,String>parameters=new HashMap<String,String>();
		parameters.put("categoryNo", categoryNo);
		parameters.put("title", "%"+title+"%");//들어가는 값이 두개 이상일때 요렇게 한다.
		count=session.selectOne("selectBoardListByCategoryAndTitleCount",parameters);
		}finally{
			session.close();
		}
		return count;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int boardCount=0;
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select count(board_no) " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.category_no=? " +
				 "and b.board_title like ? " +
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,categoryNo);
			ps.setString(2,"%"+title+"%");
			rs=ps.executeQuery();
			
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardCount;*/
	}
	@Override
	/**	 * 카테고리&이메일 검색 게시물 조회 */
	public List<Board> selectBoardListbyCategoryandEmail(int length, int page, String categoryNo, String email) {
		SqlSession session=null;
		List<Board> boardList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		HashMap<String,String>parameters=new HashMap<String,String>();
		parameters.put("categoryNo", categoryNo);
		parameters.put("email", "%"+email+"%");//들어가는 값이 두개 이상일때 요렇게 한다.
		boardList=session.selectList("Board.selectBoardListByCategoryAndEmail",parameters,rowBounds);
		}finally{
			session.close();
		}
		return boardList;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, c.category_name, c2.condition_ing " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.category_no=? " +
				 "and b.email like ? " +
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,categoryNo);
			ps.setString(2,"%"+email+"%");
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String boardNo=rs.getString(1);
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String realEmail=rs.getString(4);
				//String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String categoryName=rs.getString(7);
				String conditionIng=rs.getString(8);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				
				Member member=new Member();
				member.setEmail(realEmail);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;*/
	}
	@Override
	/**
	 * 카테고리&이메일 검색 게시물 수 리턴	 */
	public int selectBoardCategoryandEmailCount(String categoryNo, String email) {
		SqlSession session=null;
		int count;
		try{
		session = sqlMapper.openSession(true);
		HashMap<String,String>parameters=new HashMap<String,String>();
		parameters.put("categoryNo", categoryNo);
		parameters.put("email", "%"+email+"%");//들어가는 값이 두개 이상일때 요렇게 한다.
		count=session.selectOne("selectBoardListByCategoryAndEmailCount",parameters);
		}finally{
			session.close();
		}
		return count;
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int boardCount=0;
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select count(board_no) " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.category_no=? " +
				 "and b.email like ? " +
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,categoryNo);
			ps.setString(2,"%"+email+"%");
			rs=ps.executeQuery();
			
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardCount;*/
	}
	@Override
	/**	 * 자기가 올린 게시물 조회 교환가능한것만!*/
	public List<Board> selectBoardListbyEmailWhenAdd(int length, int page, String email) {
		SqlSession session=null;
		List<Board> boardList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		boardList=session.selectList("Board.selectBoardListByEmailWhenAdd","%"+email+"%",rowBounds);
		}finally{
			session.close();
		}
		return boardList;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, c.category_name, c2.condition_ing " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.condition_result=0 " +
				 "and b.email like ? " +
				 "order by board_no desc");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,"%"+email+"%");
			rs=ps.executeQuery();
			
			if(page>1){rs.absolute((page-1)*length);}
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				String boardNo=rs.getString(1);
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String realEmail=rs.getString(4);
				String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String categoryName=rs.getString(7);
				String conditionIng=rs.getString(8);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				
				Member member=new Member();
				member.setEmail(realEmail);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;*/
	}
	@Override
	/**
	 * 자기가 올린 게시물 수 리턴	 */
	public int selectBoardEmailWhenAddCount(String email) {
		SqlSession session=null;
		int count;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Board.selectBoardListByEmailWhenAddCount","%"+email+"%");
		}finally{
			session.close();
		}
		return count;
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int boardCount=0;
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select count(board_no) " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.condition_result=0 " +
				 "and b.email like ?");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,email);
			rs=ps.executeQuery();
			
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardCount;*/
	}
	@Override
	/*멤버 정보 오픈*/
	public Member viewMemberInfo(String email){
		SqlSession session=null;
		Member member=null;
		try{
		session = sqlMapper.openSession(true);
		member=session.selectOne("Board.viewMemberInfo",email);
		}finally{
			session.close();
		}
		return member;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Member member=null;
		
		con=ConnectionUtil.getConnection();
		try {
			ps=con.prepareStatement("select email, tel, address from tb_member where email=?");
			ps.setString(1, email);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				String tel=rs.getString(2);
				String address=rs.getString(3);
				
				member=new Member();
				member.setEmail(email);
				member.setTel(tel);
				member.setAddress(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
		*/
	}
	@Override
	/**
	 * 게시물 삭제 탈퇴했을때! 테스트 안해봤음.	 */
	public void deleteBoardbyEmail(String email) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.delete("Board.deleteBoardByEmail",email);
		}finally{
			session.close();
		}
		
		/*Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		//QaDAO.deleteQabyBoardNo(boardNo);//게시물 삭제됐을때 여기 딸려있던 문의글도 다 삭제해버림
		
		try {
			ps=con.prepareStatement("delete from tb_board where email=?");
			ps.setString(1,email);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
	}
	@Override
	/**	 * 자기가 올린 게시물 조회 (지울때? 언제 쓰는지 모르겠네 일단 테스트 안 해봤음)*/
	public List<Board> selectBoardListbyEmailWhenDelete(String email) {
		SqlSession session=null;
		List<Board> boardList=null;
		try{
		session = sqlMapper.openSession(true);
		boardList=session.selectList("Board.selectBoardListByEmail",email);
		}finally{
			session.close();
		}
		return boardList;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, c.category_name, c2.condition_ing " +
				 "from tb_board b, tb_member m, tb_category c, tb_condition c2 " +
				 "where m.email=b.email " +
				 "and b.category_no=c.category_no " +
				 "and b.condition_result=c2.condition_result " +
				 "and b.email=?");
			
			ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setString(1,email);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String boardNo=rs.getString(1);
				String boardTitle=rs.getString(2);
				String boardPhoto=rs.getString(3);
				String realEmail=rs.getString(4);
				String categoryNo=rs.getString(5);
				String conditionResult=rs.getString(6);
				String categoryName=rs.getString(7);
				String conditionIng=rs.getString(8);
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				
				Member member=new Member();
				member.setEmail(realEmail);
				board.setMember(member);
				
				Category category=new Category();
				category.setCategoryNo(Integer.parseInt(categoryNo));
				category.setCategoryName(categoryName);
				board.setCategory(category);
				
				Condition condition=new Condition();
				condition.setConditionResult(Integer.parseInt(conditionResult));
				condition.setConditionIng(conditionIng);
				board.setCondition(condition);
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;*/
	}
}
