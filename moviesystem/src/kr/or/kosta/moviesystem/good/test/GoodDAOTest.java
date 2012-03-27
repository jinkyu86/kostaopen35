package kr.or.kosta.moviesystem.good.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.moviesystem.good.Good;
import kr.or.kosta.moviesystem.good.GoodDAO;

import org.junit.Test;

public class GoodDAOTest {

	@Test
	public void testselectGoodList() {
		Good good =null;
		ArrayList<Good> goodList= GoodDAO.selectGoodList(1,1);
		
		
		for(int i=0;i<goodList.size();i++){
			good=goodList.get(i);
			System.out.println(good);
		}
	}
	
	@Test
	public void testselectGood() {
		Good good = GoodDAO.selectGood("2");
		System.out.println(good);
		
	}
	
	@Test
	public void testselectGoodListByName() {
		Good good =null;
		ArrayList<Good> goodList= GoodDAO.selectGoodListByName(1, 1, "ÆËÄÜ");
		
		for(int i=0;i<goodList.size();i++){
			good=goodList.get(i);
			System.out.println(good);
		}
	}
	
	@Test
	public void testselectGoodCount() {
		int goodCount = GoodDAO.selectGoodCount();
		System.out.println(goodCount);
	}
	
	@Test
	public void testselectGoodByNameCount() {
		int goodCount = GoodDAO.selectGoodListByNameCount("ÆËÄÜ");
		System.out.println(goodCount);
	}
	
	@Test
	public void testinsertGood() {
		Good good=new Good();
		good.setGname("ÄÞº¸");
		good.setDetail("ÄÞº¸ ±¸¼º : ÆËÄÜ(´ë)1 + À½·á(Áß) 2, ÄÞº¸ ÁßÀÇ º£½ºÆ®¼¿·¯ »óÇ° CGVÄÞº¸!");
		good.setGprice(7500);
		good.setPhoto("21good.jpg");
		
		GoodDAO.insertGood(good);
	}

}
