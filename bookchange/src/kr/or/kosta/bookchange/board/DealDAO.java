package kr.or.kosta.bookchange.board;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.util.ConnectionUtil;

public class DealDAO implements IDealDAO {
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
	public List<Deal> selectDeal(){
		SqlSession session=null;
		List<Deal> dealList=null;
		try{
			session=sqlMapper.openSession(true);
			dealList=session.selectList("Deal.selectDealList");
		}finally{
			session.close();
		}
		return dealList;
		
		/*Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		String sql=null;
		ResultSet rs=null;
		ArrayList<Deal> dealList=new ArrayList<Deal>();
		
		try{
		sql="select deal_no, deal_way from tb_deal";
		ps=con.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
		String dealNo=rs.getString(1);
		String dealWay=rs.getString(2);
		
		Deal deal=new Deal();
		deal.setDealNo(Integer.parseInt(dealNo));
		deal.setDealWay(dealWay);
		
		dealList.add(deal);		
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dealList;
		
	}*/
}
}
