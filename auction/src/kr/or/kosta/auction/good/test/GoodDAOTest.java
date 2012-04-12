package kr.or.kosta.auction.good.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;

import org.junit.Test;

public class GoodDAOTest {

	@Test
	public void testInsertGood() {
		Good good=new Good();
		good.setgNum("21");
		good.setgName("±èÁø¼ö");
		good.setDetail("È¦·Ñ·Ñ·Î·Ñ");
		good.setImg("s1.jpg");
		GoodDAO.insertGood(good);
	}

	@Test
	public void testUpdateGood() {
		Good good=GoodDAO.selectGood("70");
		good.setgName("editGood");
		good.setDetail("TEST");
		good.setImg("s1.jpg");
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
		ArrayList<Good>good1List=GoodDAO.selectGoodList(5, 1);
		System.out.println("good1List:"+good1List);
	}

}
