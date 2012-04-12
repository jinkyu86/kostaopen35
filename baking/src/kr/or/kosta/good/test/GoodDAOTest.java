package kr.or.kosta.good.test;

import java.util.List;

import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.recipe.RecipeDAO;

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
	
/*	@Test
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
	}*/
	

	/*@Test
	public void testSelectGoodList() {
		GoodDAO goodDAO = new GoodDAO();
		ArrayList<Good> page1List=goodDAO.selectGoodList(5, 1);
		System.out.println("page1List:"+page1List);
	}
	*/
	/*@Test
	public void testSelectGood(){
		GoodDAO goodDAO=new GoodDAO();
		Good good=goodDAO.selectGood(1);
		System.out.println(good);
	}*/
	
	@Test
	public void testSelectRecipeList(){
		List<Recipe> arrayList = RecipeDAO.selectGoodToRecipeList(7);
		for(int i=0;i<arrayList.size();i++){
			Recipe recipe = arrayList.get(i);
			System.out.println(recipe);
		}
	}
}
