package kr.or.kosta.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kosta.good.Good;
import kr.or.kosta.member.Member;
import kr.or.kosta.util.ConnectionUtil;

public class OrderDAO {

	/**
	 * 주문하기
	 * 
	 * @param order
	 */
	public static void insertOrder(Order order) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"insert into g_order" +
					" (order_num,memberid,good_num,qty,price,buy_date) " +
					" values(?, ?, ?, ?, ?, sysdate)");
			
			psmt.setInt(1,order.getOrderNum());
			psmt.setString(2,order.getMember().getMemberid());
			psmt.setInt(3,order.getGood().getGoodNum());
			psmt.setInt(4,order.getGood().getQty());
			psmt.setInt(5,order.getGood().getGoodPrice());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 주문조회
	 * @return 
	 */
	//번호가 일치하는 주문조회
	public static Order selectOrder(int ordernum) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Order order=new Order();
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(
					"select g.good_num, g.name, g.explantion, g.img," +
					"m.name, m.zipcode, m.address, m.str_address, m.phone_number, m.tel_number," +
					"o.memberid, o.qty, o.price" +
					" from good g, member m, g_order o" +
					" where g.good_num=o.good_num and m.memberid=o.memberid and o.order_num=?");
			psmt.setInt(1,ordernum);
			rs=psmt.executeQuery();
			while(rs.next()){
				int goodnum=rs.getInt(1);
				String name=rs.getString(2);
				String explantion=rs.getString(3);
				String img=rs.getString(4);
				String mname=rs.getString(5);
				String zipcode=rs.getString(6);
				String address=rs.getString(7);
				String straddress=rs.getString(8);
				String phonenumber=rs.getString(9);
				String telnumber=rs.getString(10);
				String memberid=rs.getString(11);
				int qty=rs.getInt(12);
				int price=rs.getInt(13);
				
				Good good=new Good();
				good.setGoodNum(goodnum);
				good.setName(name);
				good.setExplantion(explantion);
				good.setImg(img);
				
				Member member=new Member();
				member.setName(mname);
				member.setZipcode(zipcode);
				member.setAddress(address);
				member.setStrAddress(straddress);
				member.setPhoneNumber(phonenumber);
				member.setTelNumber(telnumber);
				
				order.setMemberid(memberid);
				order.setQty(qty);
				order.setPrice(price);
				
				order.setGood(good);
				order.setMember(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	/**
	 * 주문취소
	 * 
	 * @param ordernum
	 */
	public static void deleteOrder(int ordernum) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"delete from g_order" +
					" where order_num=?");
			psmt.setInt(1, ordernum);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 주문수정
	 * 
	 * @param order
	 */
	public static void updateOrder(Order order) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(
					"update g_order" +
					" set qty=?" +
					" where order_num=?");
			psmt.setInt(1,order.getQty());
			psmt.setInt(2,order.getOrderNum());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
