package kr.or.kosta.bookchange.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.bookchange.change.Condition;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class BoardDAO {

	/**	 * 게시물리스트 조회 */
	public static ArrayList<Board> selectBoardList(int length, int page) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			con=ConnectionUtil.getConnection();
			sql=("select board_no, board_title, board_photo, m.email, b.category_no, b.condition_result, " +
				 "c.category_name, c2.condition_ing, m.tel, m.address " +
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
				
				Board board=new Board();
				board.setBoardNo(Integer.parseInt(boardNo));
				board.setBoardTitle(boardTitle);
				board.setBoardPhoto(boardPhoto);
				
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
		
	}

	/**	 * 전체게시물 수 리턴 */
	public static int selectBoardCount() {
		Connection con=null;
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
		return boardCount;
	}

	/**	 * 카테고리별 게시물 조회 */
	public static ArrayList<Board> selectBoardListbyCategory(int length, int page, String categoryNo) {
		Connection con=null;
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
		return boardList;
	}

	/**
	 * 카테고리별 게시물 수 리턴	 */
	public static int selectBoardCategoryCount(String categoryNo) {
		Connection con=null;
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
		return boardCount;
	}

	/**
	 * 제목으로 검색한 게시물 조회	 */
	public static ArrayList<Board> selectBoardListbyTitle(int length, int page, String title) {
		Connection con=null;
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
		return boardList;
	}

	/**
	 * 제목으로 검색한  게시물 수 리턴	 */
	public static int selectBoardTitleCount(String title) {
		Connection con=null;
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
		return boardCount;
	}

	/**
	 * 게시물 보기	 */
	public static Board selectBoard(String boardNo) {
		Connection con=null;
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
				
				/*Qa qa=new Qa();
				qa.setQaContent(qaContent);
				Member member2=new Member();
				member2.setEmail(qaEmail);
				qa.setMember(member2);
				
				board.setQa(qa);*/
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return board;	
	}

	/**
	 * 게시물 추가(물품 등록)	 */
	public static void insertBoard(Board board) {
		Connection con=null;
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
		}

	}

	/**
	 * 게시물 수정	 */
	public static void updateBoard(Board board) {
		Connection con=null;
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
		}
	}

	/**
	 * 게시물 삭제	 */
	public static void deleteBoard(String boardNo) {
		Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		QaDAO.deleteQabyBoardNo(boardNo);//게시물 삭제됐을때 여기 딸려있던 문의글도 다 삭제해버림
		
		try {
			ps=con.prepareStatement("delete from tb_board where board_no=?");
			ps.setString(1,boardNo);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**	 * 자기가 올린 게시물 조회 */
	public static ArrayList<Board> selectBoardListbyEmail(int length, int page, String email) {
		Connection con=null;
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
		return boardList;
	}

	/**
	 * 자기가 올린 게시물 수 리턴	 */
	public static int selectBoardEmailCount(String email) {
		Connection con=null;
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
			ps.setString(1,email);
			rs=ps.executeQuery();
			
			if(rs.next()){
				boardCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardCount;
	}

	/**	 * 카테고리&제목 게시물 조회 */
	public static ArrayList<Board> selectBoardListbyCategoryandTitle(int length, int page, String categoryNo, String title) {
		Connection con=null;
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
		return boardList;
	}

	/**
	 * 카테고리&제목 게시물 수 리턴	 */
	public static int selectBoardCategoryandTitleCount(String categoryNo, String title) {
		Connection con=null;
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
		return boardCount;
	}

	/**	 * 카테고리&이메일 검색 게시물 조회 */
	public static ArrayList<Board> selectBoardListbyCategoryandEmail(int length, int page, String categoryNo, String email) {
		Connection con=null;
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
		return boardList;
	}

	/**
	 * 카테고리&이메일 검색 게시물 수 리턴	 */
	public static int selectBoardCategoryandEmailCount(String categoryNo, String email) {
		Connection con=null;
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
		return boardCount;
	}

	/**	 * 자기가 올린 게시물 조회 */
	public static ArrayList<Board> selectBoardListbyEmailWhenAdd(int length, int page, String email) {
		Connection con=null;
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
		return boardList;
	}

	/**
	 * 자기가 올린 게시물 수 리턴	 */
	public static int selectBoardEmailWhenAddCount(String email) {
		Connection con=null;
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
		return boardCount;
	}
}
