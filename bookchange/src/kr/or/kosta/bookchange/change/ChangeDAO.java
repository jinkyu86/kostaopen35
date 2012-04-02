package kr.or.kosta.bookchange.change;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import kr.or.kosta.bookchange.board.Board;
import kr.or.kosta.bookchange.board.Category;
import kr.or.kosta.bookchange.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class ChangeDAO {
	
	/**교환리스트 보기(관리자만사용)**/
	public static ArrayList<Change> selectChangeList(int length, int page) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Change>changeList=new ArrayList<Change>();
		String sql=null;
		
		try {
			con=ConnectionUtil.getConnection();
			sql="Select c.change_no, c.change_date, c.condition_result, c.agree_board_no, c.demand_board_no, " +
					"d.condition_result, d.condition_ing, a.board_no, a.board_title, a.board_want, a.board_photo, " +
					"a.board_content, a.email, a.deal_no, a.condition_result, a.category_no, b.board_no, b.board_title,	" +
					"b.board_want, b.board_photo, b.board_content, b.email, b.deal_no, b.condition_result, " +
					"b.category_no, ca.category_no, ca.category_name " +
					"FROM tb_change c, tb_board a, tb_board b, tb_condition d, tb_category ca " +
					"WHERE c.agree_board_no=a.board_no AND c.demand_board_no=b.board_no " +
					"AND c.condition_result=d.condition_result AND ca.category_no=a.category_no " +
					"ORDER BY c.change_no";
			ps=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs=ps.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			int recordCount=0;
			while(rs.next()&&recordCount<length){
				recordCount++;
				int changeNo=rs.getInt(1);
				Date changeDate=rs.getDate(2);
				int changeConditionResult=rs.getInt(3);
				int changeAgreeBoardNo=rs.getInt(4);
				int changeDemandBoardNo=rs.getInt(5);
				String conditionIng=rs.getString(7);
				String agreeBoardTitle=rs.getString(9);
				String agreeBoardWant=rs.getString(10);
				String agreeBoardPhoto=rs.getString(11);
				String agreeBoardContent=rs.getString(12);
				String agreeBoardEmail=rs.getString(13);
				int agreeBoardConditionResult=rs.getInt(15);
				int agreeBoardCategoryNo=rs.getInt(16);
				String demandBoardTitle=rs.getString(18);
				String demandBoardWant=rs.getString(19);
				String demandBoardPhoto=rs.getString(20);
				String demandBoardContent=rs.getString(21);
				String demandBoardEmail=rs.getString(22);
				int demandBoardConditionResult=rs.getInt(24);
				int demandBoardCategoryNo=rs.getInt(25);
				String categoryName=rs.getString(27);
				
				
				Category agreeCategory=new Category();
				agreeCategory.setCategoryNo(agreeBoardCategoryNo);
				agreeCategory.setCategoryName(categoryName);
				Category demandCategory=new Category();
				demandCategory.setCategoryNo(demandBoardCategoryNo);
				demandCategory.setCategoryName(categoryName);
				
				Condition agreeCondition=new Condition();
				agreeCondition.setConditionResult(agreeBoardConditionResult);
				Condition demandCondition=new Condition();
				demandCondition.setConditionResult(demandBoardConditionResult);
				Condition changeCondition=new Condition();
				changeCondition.setConditionResult(changeConditionResult);
				changeCondition.setConditionIng(conditionIng);
				
				Member agreeMember=new Member();
				agreeMember.setEmail(agreeBoardEmail);
				Member demandMember=new Member();
				demandMember.setEmail(demandBoardEmail);
				
				Board agreeBoard=new Board();
				agreeBoard.setBoardNo(changeAgreeBoardNo);
				agreeBoard.setBoardPhoto(agreeBoardPhoto);
				agreeBoard.setBoardContent(agreeBoardContent);
				agreeBoard.setBoardTitle(agreeBoardTitle);
				agreeBoard.setBoardWant(agreeBoardWant);
				agreeBoard.setCategory(agreeCategory);
				agreeBoard.setCondition(agreeCondition);
				agreeBoard.setMember(agreeMember);
				
				Board demandBoard=new Board();
				demandBoard.setBoardContent(demandBoardContent);
				demandBoard.setBoardNo(changeDemandBoardNo);
				demandBoard.setBoardPhoto(demandBoardPhoto);
				demandBoard.setBoardTitle(demandBoardTitle);
				demandBoard.setBoardWant(demandBoardWant);
				demandBoard.setCategory(demandCategory);
				demandBoard.setCondition(demandCondition);
				demandBoard.setMember(demandMember);
				
				Change change=new Change();
				change.setChangeNo(changeNo);
				change.setChangeDate(changeDate);
				change.setCondition(changeCondition);
				change.setAgreeBoard(agreeBoard);
				change.setDemandBoard(demandBoard);
				
				changeList.add(change);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return changeList;
	}

	/**등록 된 교환 수 리턴**/
	public static int selectChangeCount() {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet rs=null;
		int changeCount=0;
		try {
			con=ConnectionUtil.getConnection();
			sql="SELECT  count(change_no) " +
				"FROM  tb_change c,tb_condition d,tb_board b " +
				"WHERE c.condition_result=d.condition_result and b.board_no=c.demand_board_no";
			
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					changeCount=rs.getInt(1);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return changeCount;
	}

	/**교환 요청(교환신청 클릭시)
	 *  TB_BOARD의 condition_result값을 1(교환요청)으로 변경
	 * condition_result의 값이 1일때 교환 요청할수 없음**/
	public static void insertChange(Change change) {
		Connection con=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		String sql1=null;
		String sql2=null;
				
		try {
			con=ConnectionUtil.getConnection();
			sql1="Insert into tb_change(change_no, change_date, condition_result, agree_board_no, demand_board_no) " +
				"values(change_seq.nextval,sysdate,1,?,?)";
			sql2="Update tb_board set condition_result=1 where board_no=?";
			
			ps1=con.prepareStatement(sql1);
			ps2=con.prepareStatement(sql2);
			
			ps1.setInt(1, change.getAgreeBoard().getBoardNo());
			ps1.setInt(2, change.getDemandBoard().getBoardNo());
			
			ps2.setInt(1, change.getDemandBoard().getBoardNo());
			
			ps1.executeUpdate();
			ps2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**내 게시물번호로 교환리스트 검색(나에게 교환을 요청한 사람들 검색)**/
	public static ArrayList<Change> selectChangeMyboardList(int length, int page, String email) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Change>changeList=new ArrayList<Change>();
		String sql=null;
		
		try {
			con=ConnectionUtil.getConnection();
			sql="Select c.change_no, c.change_date, c.condition_result, c.agree_board_no, c.demand_board_no, " +
					"d.condition_result, d.condition_ing, a.board_no, a.board_title, a.board_want, a.board_photo, " +
					"a.board_content, a.email, a.deal_no, a.condition_result, a.category_no, b.board_no, b.board_title,	" +
					"b.board_want, b.board_photo, b.board_content, b.email, b.deal_no, b.condition_result, " +
					"b.category_no, ca.category_no, ca.category_name " +
					"FROM tb_change c, tb_board a, tb_board b, tb_condition d, tb_category ca " +
					"WHERE b.email=? AND c.agree_board_no=b.board_no AND c.demand_board_no=a.board_no " +
					"AND c.condition_result=d.condition_result AND ca.category_no=a.category_no " +
					"ORDER BY c.change_no";
			ps=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			int recordCount=0;
			while(rs.next()&&recordCount<length){
				recordCount++;
				int changeNo=rs.getInt(1);
				Date changeDate=rs.getDate(2);
				int changeConditionResult=rs.getInt(3);
				int changeAgreeBoardNo=rs.getInt(4);
				int changeDemandBoardNo=rs.getInt(5);
				String conditionIng=rs.getString(7);
				String agreeBoardTitle=rs.getString(9);
				String agreeBoardWant=rs.getString(10);
				String agreeBoardPhoto=rs.getString(11);
				String agreeBoardContent=rs.getString(12);
				String agreeBoardEmail=rs.getString(13);
				int agreeBoardConditionResult=rs.getInt(15);
				int agreeBoardCategoryNo=rs.getInt(16);
				String demandBoardTitle=rs.getString(18);
				String demandBoardWant=rs.getString(19);
				String demandBoardPhoto=rs.getString(20);
				String demandBoardContent=rs.getString(21);
				String demandBoardEmail=rs.getString(22);
				int demandBoardConditionResult=rs.getInt(24);
				int demandBoardCategoryNo=rs.getInt(25);
				String categoryName=rs.getString(27);
				
				
				Category agreeCategory=new Category();
				agreeCategory.setCategoryNo(agreeBoardCategoryNo);
				agreeCategory.setCategoryName(categoryName);
				Category demandCategory=new Category();
				demandCategory.setCategoryNo(demandBoardCategoryNo);
				demandCategory.setCategoryName(categoryName);
				
				Condition agreeCondition=new Condition();
				agreeCondition.setConditionResult(agreeBoardConditionResult);
				Condition demandCondition=new Condition();
				demandCondition.setConditionResult(demandBoardConditionResult);
				Condition changeCondition=new Condition();
				changeCondition.setConditionResult(changeConditionResult);
				changeCondition.setConditionIng(conditionIng);
				
				Member agreeMember=new Member();
				agreeMember.setEmail(agreeBoardEmail);
				Member demandMember=new Member();
				demandMember.setEmail(demandBoardEmail);
				
				Board agreeBoard=new Board();
				agreeBoard.setBoardNo(changeAgreeBoardNo);
				agreeBoard.setBoardPhoto(agreeBoardPhoto);
				agreeBoard.setBoardContent(agreeBoardContent);
				agreeBoard.setBoardTitle(agreeBoardTitle);
				agreeBoard.setBoardWant(agreeBoardWant);
				agreeBoard.setCategory(agreeCategory);
				agreeBoard.setCondition(agreeCondition);
				agreeBoard.setMember(agreeMember);
				
				Board demandBoard=new Board();
				demandBoard.setBoardContent(demandBoardContent);
				demandBoard.setBoardNo(changeDemandBoardNo);
				demandBoard.setBoardPhoto(demandBoardPhoto);
				demandBoard.setBoardTitle(demandBoardTitle);
				demandBoard.setBoardWant(demandBoardWant);
				demandBoard.setCategory(demandCategory);
				demandBoard.setCondition(demandCondition);
				demandBoard.setMember(demandMember);
				
				Change change=new Change();
				change.setChangeNo(changeNo);
				change.setChangeDate(changeDate);
				change.setCondition(changeCondition);
				change.setAgreeBoard(agreeBoard);
				change.setDemandBoard(demandBoard);
				
				changeList.add(change);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return changeList;
	}
	
	/**내 게시물 번호로 검색한 게시물 수 리턴**/
	public static int selectChangeMyboardCount(String email) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="SELECT  count(change_no) " +
				"FROM  tb_change c, tb_condition d, tb_board b " +
				"WHERE b.email=? and c.agree_board_no=b.board_no " +
				"and c.condition_result=d.condition_result";
		ResultSet rs=null;
		int changeMyCount=0;
		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
				
			if(rs.next()){
				changeMyCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return changeMyCount;
	}
	
	/**내가 교환을 신청한 사람 검색(자신의 email로 조회)**/
	public static ArrayList<Change> selectChangeRequestList(int length, int page, String email) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Change>changeList=new ArrayList<Change>();
		String sql=null;
		
		try {
			con=ConnectionUtil.getConnection();
			sql="Select c.change_no, c.change_date, c.condition_result, c.agree_board_no, c.demand_board_no, " +
					"d.condition_result, d.condition_ing, a.board_no, a.board_title, a.board_want, a.board_photo, " +
					"a.board_content, a.email, a.deal_no, a.condition_result, a.category_no, b.board_no, b.board_title,	" +
					"b.board_want, b.board_photo, b.board_content, b.email, b.deal_no, b.condition_result, " +
					"b.category_no, ca.category_no, ca.category_name " +
					"FROM tb_change c, tb_board a, tb_board b, tb_condition d, tb_category ca " +
					"WHERE a.email=? AND c.agree_board_no=b.board_no AND c.demand_board_no=a.board_no " +
					"AND c.condition_result=d.condition_result AND ca.category_no=a.category_no " +
					"ORDER BY c.change_no";
			ps=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			int recordCount=0;
			while(rs.next()&&recordCount<length){
				recordCount++;
				int changeNo=rs.getInt(1);
				Date changeDate=rs.getDate(2);
				int changeConditionResult=rs.getInt(3);
				int changeAgreeBoardNo=rs.getInt(4);
				int changeDemandBoardNo=rs.getInt(5);
				String conditionIng=rs.getString(7);
				String agreeBoardTitle=rs.getString(9);
				String agreeBoardWant=rs.getString(10);
				String agreeBoardPhoto=rs.getString(11);
				String agreeBoardContent=rs.getString(12);
				String agreeBoardEmail=rs.getString(13);
				int agreeBoardConditionResult=rs.getInt(15);
				int agreeBoardCategoryNo=rs.getInt(16);
				String demandBoardTitle=rs.getString(18);
				String demandBoardWant=rs.getString(19);
				String demandBoardPhoto=rs.getString(20);
				String demandBoardContent=rs.getString(21);
				String demandBoardEmail=rs.getString(22);
				int demandBoardConditionResult=rs.getInt(24);
				int demandBoardCategoryNo=rs.getInt(25);
				String categoryName=rs.getString(27);
				
				
				Category agreeCategory=new Category();
				agreeCategory.setCategoryNo(agreeBoardCategoryNo);
				agreeCategory.setCategoryName(categoryName);
				Category demandCategory=new Category();
				demandCategory.setCategoryNo(demandBoardCategoryNo);
				demandCategory.setCategoryName(categoryName);
				
				Condition agreeCondition=new Condition();
				agreeCondition.setConditionResult(agreeBoardConditionResult);
				Condition demandCondition=new Condition();
				demandCondition.setConditionResult(demandBoardConditionResult);
				Condition changeCondition=new Condition();
				changeCondition.setConditionResult(changeConditionResult);
				changeCondition.setConditionIng(conditionIng);
				
				Member agreeMember=new Member();
				agreeMember.setEmail(agreeBoardEmail);
				Member demandMember=new Member();
				demandMember.setEmail(demandBoardEmail);
				
				Board agreeBoard=new Board();
				agreeBoard.setBoardNo(changeAgreeBoardNo);
				agreeBoard.setBoardPhoto(agreeBoardPhoto);
				agreeBoard.setBoardContent(agreeBoardContent);
				agreeBoard.setBoardTitle(agreeBoardTitle);
				agreeBoard.setBoardWant(agreeBoardWant);
				agreeBoard.setCategory(agreeCategory);
				agreeBoard.setCondition(agreeCondition);
				agreeBoard.setMember(agreeMember);
				
				Board demandBoard=new Board();
				demandBoard.setBoardContent(demandBoardContent);
				demandBoard.setBoardNo(changeDemandBoardNo);
				demandBoard.setBoardPhoto(demandBoardPhoto);
				demandBoard.setBoardTitle(demandBoardTitle);
				demandBoard.setBoardWant(demandBoardWant);
				demandBoard.setCategory(demandCategory);
				demandBoard.setCondition(demandCondition);
				demandBoard.setMember(demandMember);
				
				Change change=new Change();
				change.setChangeNo(changeNo);
				change.setChangeDate(changeDate);
				change.setCondition(changeCondition);
				change.setAgreeBoard(demandBoard);
				change.setDemandBoard(agreeBoard);
				
				changeList.add(change);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return changeList;
	}

	/**내가 교환을 신청한 사람의 수 리턴**/
	public static int selectChangeRequestCount(String email) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="SELECT  count(change_no) " +
					"FROM  tb_change c, tb_condition d, tb_board b " +
					"WHERE b.email=? and c.demand_board_no=b.board_no and c.condition_result=d.condition_result";
		ResultSet rs=null;
		int changeRequestCount=0;
		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
				
			if(rs.next()){
				changeRequestCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return changeRequestCount;
	}
}
