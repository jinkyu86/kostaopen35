package kr.or.kosta.order;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.good.Good;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class OrderDAO {
	
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
//주문하기
	public static void insertOrder(Order order) {
		SqlSession session=null;
		try{
			session=sqlMapper.openSession(true);
			session.insert("Order.insertOrder",order);
			}
		finally{
			session.close();
		}
	}
	
	public static Order selectOrder(int ordernum){
		SqlSession session=null;
		Order order=null;
		try{
		session=sqlMapper.openSession(true);
		order=session.selectOne("selectOrder",ordernum);
		}
		finally{
			session.close();
		}
		return order;
	}

	//번호가 일치하는 주문조회
//	public static Order selectOrder(int ordernum) {
//		Connection con=null;
//		PreparedStatement psmt=null;
//		ResultSet rs=null;
//		Order order=new Order();
//		try {
//			con=ConnectionUtil.getConnection();
//			psmt=con.prepareStatement(
//					"select g.good_num, g.name, g.explantion, g.img," +
//					"m.name, m.zipcode, m.address, m.str_address, m.phone_number, m.tel_number," +
//					"o.memberid, o.qty, o.price" +
//					" from good g, member m, g_order o" +
//					" where g.good_num=o.good_num and m.memberid=o.memberid and o.order_num=?");
//			psmt.setInt(1,ordernum);
//			rs=psmt.executeQuery();
//			while(rs.next()){
//				int goodnum=rs.getInt(1);
//				String name=rs.getString(2);
//				String explantion=rs.getString(3);
//				String img=rs.getString(4);
//				String mname=rs.getString(5);
//				String zipcode=rs.getString(6);
//				String address=rs.getString(7);
//				String straddress=rs.getString(8);
//				String phonenumber=rs.getString(9);
//				String telnumber=rs.getString(10);
//				String memberid=rs.getString(11);
//				int qty=rs.getInt(12);
//				int price=rs.getInt(13);
//				
//				Good good=new Good();
//				good.setGoodNum(goodnum);
//				good.setName(name);
//				good.setExplantion(explantion);
//				good.setImg(img);
//				
//				Member member=new Member();
//				member.setName(mname);
//				member.setZipcode(zipcode);
//				member.setAddress(address);
//				member.setStrAddress(straddress);
//				member.setPhoneNumber(phonenumber);
//				member.setTelNumber(telnumber);
//				
//				order.setMemberid(memberid);
//				order.setQty(qty);
//				order.setPrice(price);
//				
//				order.setGood(good);
//				order.setMember(member);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return order;
//	}

	public static List<Order> selectOrderList(String memberid){
		SqlSession session=null;
		List<Order> orderList=null;
		try{
		session=sqlMapper.openSession(true);
		orderList=session.selectList("Order.selectOrderList","%"+memberid+"%");
		}
		finally{
			session.close();
		}
		return orderList;
	}
//	//추가 아이디가 일치하는 구매목록 조회
//	public static ArrayList<Order>selectOrderList(String memberid){
//		Connection con=null;
//		PreparedStatement psmt=null;
//		ResultSet rs=null;
//		ArrayList<Order>orderList=new ArrayList<Order>();
//		try {
//			con=ConnectionUtil.getConnection();
//			psmt=con.prepareStatement(
//					"select o.memberid,o.order_num,o.qty,o.price,to_char(o.buy_date,'yyyy/mm/dd hh24:mi')," +
//					"g.good_num,g.name,g.explantion,g.img,g.g_option," +
//					"m.password,m.name,m.regi_number," +
//					"m.zipcode,m.address,m.str_address,m.email,m.phone_number,m.tel_number," +
//					"d.division,d.g_name" +
//					" from g_order o,good g,member m,good_division d" +
//					" where o.good_num=g.good_num and o.memberid=m.memberid" +
//					" and d.division=g.division and o.memberid=?");
//			psmt.setString(1,memberid);
//			rs=psmt.executeQuery();
//			while(rs.next()){
//				memberid=rs.getString(1);
//				int ordernum=rs.getInt(2);
//				int qty=rs.getInt(3);
//				int price=rs.getInt(4);
//				String buydate=rs.getString(5);
//				int goodnum=rs.getInt(6);
//				String gname=rs.getString(7);
//				String explantion=rs.getString(8);
//				String img=rs.getString(9);
//				String option=rs.getString(10);
//				String password=rs.getString(11);
//				String name=rs.getString(12);
//				String reginumber=rs.getString(13);
//				String zipcode=rs.getString(14);
//				String address=rs.getString(15);
//				String straddress=rs.getString(16);
//				String email=rs.getString(17);
//				String phonenumber=rs.getString(18);
//				String telnumber=rs.getString(19);
//				int division=rs.getInt(20);
//				String dname=rs.getString(21);
//				
//				Order order=new Order();
//				order.setMemberid(memberid);
//				order.setOrderNum(ordernum);
//				order.setQty(qty);
//				order.setPrice(price);
//				order.setBuyDate(buydate);
//				
//				Good good=new Good();
//				good.setGoodNum(goodnum);
//				good.setName(gname);
//				good.setExplantion(explantion);
//				good.setImg(img);
//				good.setOption(option);
//				
//				Member member=new Member();
//				member.setPassword(password);
//				member.setName(name);
//				member.setRegiNumber(reginumber);
//				member.setZipcode(zipcode);
//				member.setAddress(address);
//				member.setStrAddress(straddress);
//				member.setEmail(email);
//				member.setPhoneNumber(phonenumber);
//				member.setTelNumber(telnumber);
//				
//				Good_division gooddivision=new Good_division();
//				gooddivision.setDivision(division);
//				gooddivision.setgName(dname);
//				
//				good.setGood_division(gooddivision);
//				order.setGood(good);
//				order.setMember(member);
//				
//				orderList.add(order);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return orderList;
//	}
}
