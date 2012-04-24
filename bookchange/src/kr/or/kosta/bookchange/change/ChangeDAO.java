package kr.or.kosta.bookchange.change;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ChangeDAO implements IChangeDAO{
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
	
	@Override
	public void insertChange(Change change) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.insert("Change.insertChange",change);
		session.update("Change.insertUpdateBoard",change);
		}
		finally{session.close();}
	}
		
	@Override
	public void matchChange(Change change) {
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.insert("Change.insertMatch",change);
			session.update("Change.matchUpdateChange",change);
			session.update("Change.matchUpdateBoard",change);
		}
		finally{session.close();}
	}

	@Override
	public void cancelChange(int demandBoardNo) {
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.delete("Change.cancelChange",demandBoardNo);
			session.update("Change.cancelUpdateBoard",demandBoardNo);
		}
		finally{session.close();}
	}
	
	@Override
	public void completeChange(int ChangeNo, int BoardNo){
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.update("Change.completeChangeUpdate",ChangeNo);
			session.update("Change.completeBoardUpdate",BoardNo);
		}
		finally{session.close();}
	}
	
	@Override
	public List<Change> selectChangeRequestList(int length, int page, String email) {
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
	
	@Override
	public int selectChangeRequestCount(String email) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Change.selectChangeRequestListCount",email);
		}
		finally{session.close();}
		return count;
	}
	
	@Override
 	public List<Change> selectChangeMyboardList(int length, int page, String email) {
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
	
	@Override
	public int selectChangeMyboardCount(String email) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Change.selectChangeMyboardListCount",email);
		}
		finally{session.close();}
		return count;
	}
	
	@Override
	public List<Change> selectMatchList(int length, int page, String email) {
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
	
	@Override
	public int selectMatchListCount(String email) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Change.selectMatchListCount",email);
		}
		finally{session.close();}
		return count;
	}
	
	@Override
	public void deleteChange(int boardNo){
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true);
			session.delete("Change.deleteChange",boardNo);
		}
		finally{session.close();}
	}
	
	@Override
	public List<Change> selectMatchResultList(int length, int page, String email) {
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
	
	@Override
	public int selectMatchResultListCount(String email) {
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

}
