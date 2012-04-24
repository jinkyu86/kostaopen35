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

public class BuyDAO implements IBuyDAO{
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
	
	@Override
	public void insertBuy(Buy buy) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.insert("Buy.insertBuy",buy);
		}finally{
			session.close();
		}
	}
	@Override
	public List<Buy> selectBuyList(String userid,int length,int page) {
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
	@Override
	public int selectBuyCountByUerid(String userid) {
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
	@Override
	public List<Buy> selectCancelableBuyList(String userid, int length, int page) {
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
	@Override
	public int selectCancelableBuyListCount(String userid) {
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
	@Override
	public List<Buy> selectCanceledBuyList(String userid, int length, int page) {
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
	@Override
	public int selectCanceledBuyListCount(String userid) {
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
	
	//구매취소하기 (buy table의 pay_state를 1로 set, cancel_date를 취소날짜로 set)
	@Override
	public void cancelBuy(String buynum){
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.update("Buy.cancelBuy", buynum);
		}finally{
			session.close();
		}
	}
		
	
}
