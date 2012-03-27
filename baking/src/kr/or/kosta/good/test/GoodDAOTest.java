package kr.or.kosta.good.test;

import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.gooddivision.Good_division;

import org.junit.Test;

public class GoodDAOTest {

/*	@Test
	public void testInsertGood() {
		Good good = new Good();
		Good_division good_division = new Good_division();
		
		good_division.setDivision(1);
		good.setGood_division(good_division);
		good.setGoodPrice(4000);
		good.setQty(100);
		good.setName("테스트");
		good.setExplantion("테스트");
		good.setImg("test");
		good.setOption("");
		
		GoodDAO goodDAO=new GoodDAO();
		goodDAO.insertGood(good);
	}*/
	
/*	@Test
	public void testDeleteGood(){
		Good good = new Good();
		good.setGoodNum(40);		
		
		GoodDAO goodDAO = new GoodDAO();
		goodDAO.deleteGood(good.getGoodNum());
	}*/
	
	@Test
	public void testUpdateGood(){
		Good good = new Good();
		Good_division good_division = new Good_division();
		
		good_division.setDivision(1);
		good.setGood_division(good_division);
		good.setGoodPrice(4000);
		good.setQty(100);
		good.setName("JUNIT 업데이트 테스트");
		good.setExplantion("JUNIT 업데이트 테스트");
		good.setImg("JUNIT test");
		good.setOption("JUNIT test");
		good.setGoodNum(39);
		
		GoodDAO goodDAO = new GoodDAO();
		goodDAO.updateGood(good);
	}
}
