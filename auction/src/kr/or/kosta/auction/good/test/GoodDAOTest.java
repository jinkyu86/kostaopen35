package kr.or.kosta.auction.good.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;

import org.junit.Test;

public class GoodDAOTest {

	@Test
	public void testInsertGood() {
		Good good=GoodDAO.selectGood("1");
		GoodDAO.insertGood(good);
	}

	@Test
	public void testUpdateGood() {
		Good good=GoodDAO.selectGood("21");
		good.setgName("업데이트 테스트");
		good.setDetail("ㅅㅅㅅㅅㅂㅈㅌ");
		good.setImg("ss.jpg");
		GoodDAO.updateGood(good);
		
	}

	@Test
	public void testDeleteGood() {
		GoodDAO.deleteGood("22");
	}

	@Test
	public void testSelectGood() {
		Good good=GoodDAO.selectGood("1");
		System.out.println(good.toString());
	}

	@Test
	public void testSelectGoodList() {
			ArrayList<Good>goodList=
					GoodDAO.selectGoodList();
			for(int i=0; i<goodList.size(); i++){
				Good good=goodList.get(i);
				System.out.println(good.toString());
		}
	}

	@Test
	public void testSelectGoodListIntInt() {
		fail("Not yet implemented");
	}

}
