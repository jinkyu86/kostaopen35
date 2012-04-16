package kr.or.kosta.bookchange.change;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ChangeDAO {
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
	
	/**교환 요청(교환신청 클릭시)
	 *  TB_BOARD의 condition_result값을 1(교환요청)으로 변경
	 * condition_result의 값이 1일때 교환 요청할수 없음**/
	public static void insertChange(Change change) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.insert("Change.insertChange",change);
		session.update("Change.insertUpdateBoard",change);
		}
		finally{session.close();}
	}
		
	/**교환 요청 수락(교환요청 수락버튼 클릭시) 
	 * TB_BOARD의 condition_result값을 2(교환중)으로 변경**/
	public static void matchChange(Change change) {
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.insert("Change.insertMatch",change);
			session.update("Change.matchUpdateChange",change);
			session.update("Change.matchUpdateBoard",change);
		}
		finally{session.close();}
	}

	/**교환 취소(교환취소 클릭시) 
	 * TB_BOARD의 condition_result값을 0(교환가능)으로 변경, TB_CHANGE 에서 삭제
	 * condition_result의 값이 1(교환요청)일때만 실행
	 * 상대방이 교환요청 수락하였을 경우 취소 불가.... **/
	public static void cancelChange(int demandBoardNo) {
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.delete("Change.cancelChange",demandBoardNo);
			session.update("Change.cancelUpdateBoard",demandBoardNo);
		}
		finally{session.close();}
	}
	
	/** 교환 완료(교환완료 클릭시)
	 * condition_result의 값이 2(교환중)일때만 실행
	 * tb_change, tb_board의 condition_result의 값을 3(교환완료)으로 변경,**/
	public static void completeChange(int ChangeNo, int BoardNo){
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.update("Change.completeChangeUpdate",ChangeNo);
			session.update("Change.completeBoardUpdate",BoardNo);
		}
		finally{session.close();}
	}
	
	/**내가 교환을 신청한 사람 조회(자신의 email로 조회)**/
	public static List<Change> selectChangeRequestList(int length, int page, String email) {
		SqlSession session=null;
		List<Change> changeList=null;
		try{
			session = sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length, length);
			changeList=session.selectList("Change.selectChangeRequestList",email,rowBounds);
		}
		finally{session.close();}
		return changeList;
	}
	/**내가 교환을 신청한 사람의 수 리턴**/
	public static int selectChangeRequestCount(String email) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Change.selectChangeRequestListCount",email);
		}
		finally{session.close();}
		return count;
	}
	
	/**내 게시물번호로 교환리스트 검색(나에게 교환을 요청한 사람들 검색)**/
 	public static List<Change> selectChangeMyboardList(int length, int page, String email) {
 		SqlSession session=null;
		List<Change> changeList=null;
		try{
			session = sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length, length);
			changeList=session.selectList("Change.selectChangeMyboardList",email,rowBounds);
		}
		finally{session.close();}
		return changeList;
	}
	
	/**내 게시물 번호로 검색한 게시물 수 리턴**/
	public static int selectChangeMyboardCount(String email) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Change.selectChangeMyboardListCount",email);
		}
		finally{session.close();}
		return count;
	}
	
	/**나와 교환중인 사람 리스트 보기**/
	public static List<Change> selectMatchList(int length, int page, String email) {
		SqlSession session=null;
		List<Change> changeList=null;
		try{
			session = sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length, length);
			changeList=session.selectList("Change.selectMatchList",email,rowBounds);
		}
		finally{session.close();}
		return changeList;
	}
	
	public static int selectMatchListCount(String email) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Change.selectMatchListCount",email);
		}
		finally{session.close();}
		return count;
	}
	
	/**
	 * 회원 탈퇴시 교환정보 모두 삭제
	 */
	public static void deleteChange(int boardNo){
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.delete("Change.deleteChange",boardNo);
		}
		finally{session.close();}
	}
	
	/**나와 교환완료된 사람 리스트 보기 교환완료 눌렀을때 **/
	public static List<Change> selectMatchResultList(int length, int page, String email) {
		SqlSession session=null;
		List<Change> changeList=null;
		try{
			session = sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length, length);
			changeList=session.selectList("Change.selectMatchResultList",email,rowBounds);
		}
		finally{session.close();}
		return changeList;
	}
	
	public static int selectMatchResultListCount(String email) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Change.selectMatchResultListCount",email);
		}
		finally{session.close();}
		return count;
	}
	
//	/**교환리스트 보기(관리자만사용)**/
//	public static ArrayList<Change> selectChangeList(int length, int page) {
//		Connection con=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		ArrayList<Change>changeList=new ArrayList<Change>();
//		String sql=null;
//		
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="Select c.change_no, c.change_date, c.condition_result, c.agree_board_no, c.demand_board_no, " +
//					"d.condition_result, d.condition_ing, a.board_no, a.board_title, a.board_want, a.board_photo, " +
//					"a.board_content, a.email, a.deal_no, a.condition_result, a.category_no, b.board_no, b.board_title,	" +
//					"b.board_want, b.board_photo, b.board_content, b.email, b.deal_no, b.condition_result, " +
//					"b.category_no, ca.category_no, ca.category_name " +
//					"FROM tb_change c, tb_board a, tb_board b, tb_condition d, tb_category ca " +
//					"WHERE c.agree_board_no=a.board_no AND c.demand_board_no=b.board_no " +
//					"AND c.condition_result=d.condition_result AND ca.category_no=a.category_no " +
//					"ORDER BY c.change_no";
//			ps=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			rs=ps.executeQuery();
//			
//			if(page>1){
//				rs.absolute((page-1)*length);
//			}
//			int recordCount=0;
//			while(rs.next()&&recordCount<length){
//				recordCount++;
//				int changeNo=rs.getInt(1);
//				Date changeDate=rs.getDate(2);
//				int changeConditionResult=rs.getInt(3);
//				int changeAgreeBoardNo=rs.getInt(4);
//				int changeDemandBoardNo=rs.getInt(5);
//				String conditionIng=rs.getString(7);
//				String agreeBoardTitle=rs.getString(9);
//				String agreeBoardWant=rs.getString(10);
//				String agreeBoardPhoto=rs.getString(11);
//				String agreeBoardContent=rs.getString(12);
//				String agreeBoardEmail=rs.getString(13);
//				int agreeBoardConditionResult=rs.getInt(15);
//				int agreeBoardCategoryNo=rs.getInt(16);
//				String demandBoardTitle=rs.getString(18);
//				String demandBoardWant=rs.getString(19);
//				String demandBoardPhoto=rs.getString(20);
//				String demandBoardContent=rs.getString(21);
//				String demandBoardEmail=rs.getString(22);
//				int demandBoardConditionResult=rs.getInt(24);
//				int demandBoardCategoryNo=rs.getInt(25);
//				String categoryName=rs.getString(27);
//				
//				
//				Category agreeCategory=new Category();
//				agreeCategory.setCategoryNo(agreeBoardCategoryNo);
//				agreeCategory.setCategoryName(categoryName);
//				Category demandCategory=new Category();
//				demandCategory.setCategoryNo(demandBoardCategoryNo);
//				demandCategory.setCategoryName(categoryName);
//				
//				Condition agreeCondition=new Condition();
//				agreeCondition.setConditionResult(agreeBoardConditionResult);
//				Condition demandCondition=new Condition();
//				demandCondition.setConditionResult(demandBoardConditionResult);
//				Condition changeCondition=new Condition();
//				changeCondition.setConditionResult(changeConditionResult);
//				changeCondition.setConditionIng(conditionIng);
//				
//				Member agreeMember=new Member();
//				agreeMember.setEmail(agreeBoardEmail);
//				Member demandMember=new Member();
//				demandMember.setEmail(demandBoardEmail);
//				
//				Board agreeBoard=new Board();
//				agreeBoard.setBoardNo(changeAgreeBoardNo);
//				agreeBoard.setBoardPhoto(agreeBoardPhoto);
//				agreeBoard.setBoardContent(agreeBoardContent);
//				agreeBoard.setBoardTitle(agreeBoardTitle);
//				agreeBoard.setBoardWant(agreeBoardWant);
//				agreeBoard.setCategory(agreeCategory);
//				agreeBoard.setCondition(agreeCondition);
//				agreeBoard.setMember(agreeMember);
//				
//				Board demandBoard=new Board();
//				demandBoard.setBoardContent(demandBoardContent);
//				demandBoard.setBoardNo(changeDemandBoardNo);
//				demandBoard.setBoardPhoto(demandBoardPhoto);
//				demandBoard.setBoardTitle(demandBoardTitle);
//				demandBoard.setBoardWant(demandBoardWant);
//				demandBoard.setCategory(demandCategory);
//				demandBoard.setCondition(demandCondition);
//				demandBoard.setMember(demandMember);
//				
//				Change change=new Change();
//				change.setChangeNo(changeNo);
//				change.setChangeDate(changeDate);
//				change.setCondition(changeCondition);
//				change.setAgreeBoard(agreeBoard);
//				change.setDemandBoard(demandBoard);
//				
//				changeList.add(change);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return changeList;
//	}
//
//	/**등록 된 교환 수 리턴**/
//	public static int selectChangeCount() {
//		Connection con=null;
//		PreparedStatement ps=null;
//		String sql=null;
//		ResultSet rs=null;
//		int changeCount=0;
//		try {
//			con=ConnectionUtil.getConnection();
//			sql="SELECT  count(change_no) " +
//				"FROM  tb_change c,tb_condition d,tb_board b " +
//				"WHERE c.condition_result=d.condition_result and b.board_no=c.demand_board_no";
//			
//				ps=con.prepareStatement(sql);
//				rs=ps.executeQuery();
//				if(rs.next()){
//					changeCount=rs.getInt(1);
//				}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return changeCount;
//	}
//
//	
//
//	
//	
//	
//	

//	

//	

//	

//

//	


//

//
//	
}
