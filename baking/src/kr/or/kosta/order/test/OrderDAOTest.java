package kr.or.kosta.order.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.order.Order;
import kr.or.kosta.order.OrderDAO;
import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.member.Member;

import org.junit.Test;

import sun.jdbc.odbc.OdbcDef;

public class OrderDAOTest {

//	@Test
//	public void testInsertOrder() {
//		Order order = new Order();
//		order.setQty(3);
//		Member member =new Member();
//		member.setMemberid("yubi");
//		order.setMember(member);
//		Good good = new Good();
//		good.setGoodNum(3);
//		good.setGoodPrice(13900);
//		order.setGood(good);
//		
//		
//		OrderDAO.insertOrder(order);
//		System.out.println(order);
//	}

//	@Test
//	public void testSelectOrder(){
//		Order order=new Order();
//		order=OrderDAO.selectOrder(1);
//		System.out.println(order);
//	}
	
//	@Test
//	public void testDeleteOrder(){
//		Order order=new Order();
//		order.setOrderNum(2);
//		OrderDAO.deleteOrder(order.getOrderNum());
//	}

//	@Test
//	public void testUpdateOrder(){
//		Order order=new Order();
//		order.setQty(1);
//		order.setOrderNum(1);
//		
//		OrderDAO.updateOrder(order);
//	}
	
//	@Test
//	public void testUpdateQty(){
//		Order order=new Order();
//		order.setQty(4);
//		order.setOrderNum(1);
//		
//		OrderDAO.updateQty(order);
//	}
	
	@Test
	public void testOrderList(){
		ArrayList<Order>orderList=OrderDAO.selectOrderList("yubi");
		System.out.println(orderList);
	}
	
} 

