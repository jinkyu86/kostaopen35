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
	
	//��������ϱ� (buy table�� pay_state�� 1�� set, cancel_date�� ��ҳ�¥�� set)
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
