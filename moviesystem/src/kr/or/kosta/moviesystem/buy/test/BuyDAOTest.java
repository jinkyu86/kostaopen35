package kr.or.kosta.moviesystem.buy.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.moviesystem.buy.Buy;
import kr.or.kosta.moviesystem.buy.BuyDAO;
import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.member.Member;

import org.junit.Test;

public class BuyDAOTest {

	@Test
	public void testinsertBuy() {
		Buy buy =new Buy();
		Good good=new Good();
		Member member=new Member();
		
		good.setGnum("10");
		buy.setQty(1);
		member.setUserid("mandu");
		buy.setPayState("1");
		buy.setTotalPrice(2000);
		
		buy.setGood(good);
		buy.setMember(member);
		
		BuyDAO.insertBuy(buy);
		
	}
	
//	@Test
//	public void testselectBuyList() {
//		ArrayList<Buy> buyList=BuyDAO.selectBuyList("mandu", 1, 1);
//		
//		for(int i=0;i<buyList.size();i++){
//			Buy buy=buyList.get(i);
//			System.out.println(buy);
//		}
//
//	}
//	@Test
//	public void testselectBuyCount() {
//		int buyCount=BuyDAO.selectBuyCount("jun123");
//		System.out.println(buyCount);
//	}
//	
//	@Test
//	public void testdeleteBuy() {
//		BuyDAO.deleteBuy("2");
//	}
//	
//	@Test
//	public void testeditBuy() {
//		Buy buy=new Buy();
//		buy.setBuynum("1");
//		buy.setQty(3);
//		buy.setTotalPrice(6000);
//		BuyDAO.editBuy(buy);
//	}
//	
//	@Test
//	public void testpayBuy() {
//		BuyDAO.payBuy("1");
//	}

	@Test
	public void testselectCancelableBuyList() {
		ArrayList<Buy> buyList=BuyDAO.selectCancelableBuyList("jun123", 1, 1);
		
		for(int i=0;i<buyList.size();i++){
			Buy buy=buyList.get(i);
			System.out.println(buy);
		}

	}
	
}
