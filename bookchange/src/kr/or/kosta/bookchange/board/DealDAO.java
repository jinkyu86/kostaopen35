package kr.or.kosta.bookchange.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.util.ConnectionUtil;

public class DealDAO {
	public static ArrayList<Deal> selectDeal(){
		Connection con=null;
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
		
	}
}
