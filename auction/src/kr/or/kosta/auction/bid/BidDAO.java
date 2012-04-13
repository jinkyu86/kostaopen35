package kr.or.kosta.auction.bid;

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

import kr.or.kosta.auction.auction.Auction;
import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.member.Member;
import kr.or.kosta.auction.util.ConnectionUtil;

public class BidDAO {
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
	
	public static void insertBid(Bid bid) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.insert("Bid.insertBid",bid);
		}finally{
			session.close();
		}
	}

	public static void updateBid(Bid bid) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.update("Bid.updateBid",bid);
		}finally{
			session.close();
		}
	}

	public static Bid selectBid(String bidNum) {
		SqlSession session=null;
		Bid bid=null;
		try{
			session=sqlMapper.openSession(true);
			bid=session.selectOne("Bid.selectBid",bidNum);
		}finally{
			session.close();
		}
		return bid;
	}

	public static List<Bid> selectBidList() {
		SqlSession session=null;
		List<Bid> bidList=null;
		try{
			session=sqlMapper.openSession(true);
			bidList=session.selectList("Bid.selectBidList");
		}finally{
			session.close();
		}
		return bidList;
	}

	public static List<Bid> selectBidList(int length, int page) {
		SqlSession session=null;
		List<Bid> bidList=null;
		try{
			session=sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			bidList=session.selectList("Bid.selectBidList",null,rowBounds);
		}finally{
			session.close();
		}
		return bidList;
	}

	public static List<Bid> selectBidListByID(int length, int page, String userid) {
		SqlSession session=null;
		List<Bid> bidList=null;
		try{
			session=sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds((page-1)*length,length);
			bidList=session.selectList("Bid.selectBidListByID",userid,rowBounds);
		}finally{
			session.close();
		}
		return bidList;
	}

	public static List<Bid> selectBidListByAuctionNum(String aNum, int size) {
		SqlSession session=null;
		List<Bid> bidList=null;
		try{
			session=sqlMapper.openSession(true);
			RowBounds rowBounds=new RowBounds(0,size);
			bidList=session.selectList("Bid.selectBidListByAuctionNum",aNum,rowBounds);
		}finally{
			session.close();
		}
		return bidList;
	}

	public static void deleteBidById(String userid) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.delete("Bid.deleteBidById",userid);
		}finally{
			session.close();
		}	
	}
	
	//ID별로 환불완료 표시
	public static void updateMoneybackById(String userid) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.update("Bid.updateMoneybackById",userid);
		}finally{
			session.close();
		}
	}
	
	//해당경매의 ID별로 환불완료 표시
	public static void updateMoneybackByIdInAuction(String userid,String aNum) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			HashMap<String,String>parameters=new HashMap<String,String>();
			parameters.put("userid", userid);
			parameters.put("aNum",aNum);
			session.update("Bid.updateMoneybackById",parameters);
		}finally{
			session.close();
		}
	}
	
	public static int selectMoneybackByIdCount(String userid) {
		SqlSession session=null;
		Integer count=null;
		try{
			session = sqlMapper.openSession(true);
			count=session.selectOne("Bid.selectMoneybackByIdCount",userid);
				
		}finally{
			//Connection을 ConnectionPool에 반납
			session.close();
		}
		return count;
	}

}
