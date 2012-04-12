package kr.or.kosta.auction.good.test;

import java.util.ArrayList;
import java.util.List;

import kr.or.kosta.auction.good.Good;
import kr.or.kosta.auction.good.GoodDAO;
import org.junit.Test;

public class GoodDAOTest {

	@Test
	public void testInsertGood() {
		Good good=new Good();
		good.setgNum("22");
		good.setgName("±èÁø¼ö");
		good.setDetail("È¦·Ñ·Ñ·Î·Ñ");
		good.setImg("s1.jpg");
		GoodDAO.insertGood(good);
	}

	@Test
	public void testUpdateGood() {
		Good good=new Good();
		good.setgName("editGood");
		good.setDetail("TEST");
		good.setImg("s1.jpg");
		good.setgNum("122");
		GoodDAO.updateGood(good);
		
	}

	@Test
	public void testDeleteGood() {
		GoodDAO.deleteGood("122");
	}

	@Test
	public void testSelectGood() {
		Good good=GoodDAO.selectGood("121");
		System.out.println(good.toString());
	}

	@Test
	public void testSelectGoodList() {
		List<Good> goodList=GoodDAO.selectGoodList();
		System.out.println("GoodDAO:selectGood:good"+goodList);
	}

	@Test
	public void testSelectGoodListIntInt() {
		List<Good>good1List=GoodDAO.selectGoodList(1, 2);
		System.out.println("good1List:"+good1List);
	}

}
