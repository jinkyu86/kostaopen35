package kr.or.kosta.moviesystem.buy;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import kr.or.kosta.moviesystem.good.Good;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BuyDAO {
	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
		try {
			sqlReader=Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
			}
		}
	private static SqlSessionFactory sqlMapper =new SqlSessionFactoryBuilder().build(sqlReader);
	
	public static void insertBuy(Buy buy) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.insert("Buy.insertBuy",buy);
		}finally{
			session.close();
		}
	}
	
	public static List<Buy> selectBuyList(String userid,int length,int page) {
		SqlSession session=null;
		List<Buy> buyList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		buyList=session.selectList("Buy.selectBuyList", userid ,rowBounds);
		
		}finally{
			session.close();
		}
		return buyList;
	}
	
	public static int selectBuyCountByUerid(String userid) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Buy.selectBuyCountByUerid", userid);
		
		}finally{
			session.close();
		}
		return count;
	}

	public static List<Buy> selectCancelableBuyList(String userid, int length, int page) {
		SqlSession session=null;
		List<Buy> buyList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		buyList=session.selectList("Buy.selectCancelableBuyList", userid ,rowBounds);
		
		}finally{
			session.close();
		}
		return buyList;
	}
	
	public static int selectCancelableBuyListCount(String userid) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Buy.selectCancelableBuyListCount", userid);
		
		}finally{
			session.close();
		}
		return count;
	}

	public static List<Buy> selectCanceledBuyList(String userid, int length, int page) {
		SqlSession session=null;
		List<Buy> buyList=null;
		try{
		session = sqlMapper.openSession(true);
		RowBounds rowBounds=new RowBounds((page-1)*length,length);
		buyList=session.selectList("Buy.selectCanceledBuyList", userid ,rowBounds);
		
		}finally{
			session.close();
		}
		return buyList;
		
	}
	
	public static int selectCanceledBuyListCount(String userid) {
		SqlSession session=null;
		Integer count=null;
		try{
		session = sqlMapper.openSession(true);
		count=session.selectOne("Buy.selectCanceledBuyListCount", userid);
		
		}finally{
			session.close();
		}
		return count;
	}
//	public static ArrayList<Buy> selectCanceledBuyList(String userid1, int length, int page) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement psmt=null;
//		ResultSet rs=null;
//		Member member=null;
//		Good good=null;
//		Buy buy=null;
//		
//		ArrayList<Buy>buyList=new ArrayList<Buy>();
//	
//		try {
//		con=ConnectionUtil.getConnection();
//		String sql="SELECT user_num,m.userid,name,email,phone,zipcode,addr," +
//				"g.g_num,g_name,detail,g_price,photo," +
//				"buy_num,qty,buy_date,cancel_date,pay_state,total_price " +
//				"FROM member m,good g, buy b " +
//				"WHERE m.userid=b.userid AND g.g_num=b.g_num AND m.userid=? AND pay_state=1 ORDER BY cancel_date DESC ";
//		
//			psmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//			psmt.setString(1, userid1);
//			psmt.executeUpdate();
//			rs=psmt.executeQuery();
//			
//			if(page>1){
//				rs.absolute((page-1)*length);
//			}
//			int getRecordCount=0;
//			while(rs.next()&&getRecordCount<length){
//				getRecordCount++;
//				String user_num=rs.getString(1);
//				String userid=rs.getString(2);
//				String name=rs.getString(3);
//				String email=rs.getString(4);
//				String phone=rs.getString(5);
//				String zipcode=rs.getString(6);
//				String addr=rs.getString(7);
//				
//				String g_num=rs.getString(8);
//				String g_name=rs.getString(9);
//				String detail=rs.getString(10);
//				long g_price=Long.parseLong(rs.getString(11));
//				String photo =rs.getString(12);
//				
//				String buy_num=rs.getString(13);
//				long qty=Long.parseLong(rs.getString(14));
//				Date buy_date=rs.getDate(15);
//				Date cancel_date=rs.getDate(16);
//				String pay_state=rs.getString(17);
//				long total_price=Long.parseLong(rs.getString(18));
//				
//				member=new Member();
//				member.setUserNum(user_num);
//				member.setUserid(userid);
//				member.setName(name);
//				member.setEmail(email);
//				member.setPhone(phone);
//				member.setZipcode(zipcode);
//				member.setAddr(addr);
//				
//				good=new Good();
//				good.setGnum(g_num);
//				good.setGname(g_name);
//				good.setDetail(detail);
//				good.setGprice(g_price);
//				good.setPhoto(photo);
//				
//				buy=new Buy();
//				buy.setBuynum(buy_num);
//				buy.setQty(qty);
//				buy.setBuyDate(buy_date);
//				buy.setcancelbuyDate(cancel_date);
//				buy.setPayState(pay_state);
//				buy.setTotalPrice(total_price);
//				
//				buy.setMember(member);
//				buy.setGood(good);
//				
//				buyList.add(buy);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return buyList;
//	}
//	public static int selectCanceledBuyListCount(String userid1) {
//		/* default generated stub */;
//		Connection con=null;
//		PreparedStatement psmt=null;
//		ResultSet rs=null;
//		int buyCount=0;
//		
//		con=ConnectionUtil.getConnection();
//		
//		try {
//		String sql="SELECT count(g.g_num) FROM member m,good g, buy b " +
//				"WHERE m.userid=b.userid AND g.g_num=b.g_num AND m.userid=? AND pay_state=1 ORDER BY buy_date DESC ";
//		
//			psmt=con.prepareStatement(sql);
//			psmt.setString(1, userid1);
//			rs=psmt.executeQuery();
//			
//			if(rs.next()){
//				buyCount=rs.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return buyCount;
//	}
	
	//구매취소하기 (buy table의 pay_state를 1로 set, cancel_date를 취소날짜로 set)
	public static void cancelBuy(String buynum){
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.update("Buy.cancelBuy", buynum);
		}finally{
			session.close();
		}
	}
		
	
}
