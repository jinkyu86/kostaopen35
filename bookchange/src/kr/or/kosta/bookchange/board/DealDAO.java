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
import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.or.kosta.util.ConnectionUtil;

public class DealDAO extends SqlSessionDaoSupport implements IDealDAO {
	
	@Override
	public List<Deal> selectDeal(){
		SqlSession session=null;
		List<Deal> dealList=null;
		
			session=getSqlSession();
			dealList=session.selectList("Deal.selectDealList");
		
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
