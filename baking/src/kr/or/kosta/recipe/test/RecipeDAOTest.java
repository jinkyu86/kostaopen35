package kr.or.kosta.recipe.test;

import java.util.ArrayList;
import java.util.List;

import kr.or.kosta.good.Good;
import kr.or.kosta.good.GoodDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.recipe.RecipeDAO;

import org.junit.Test;

public class RecipeDAOTest {
//	
//	@Test
//	public void testinsertRecipe(){
//		Recipe recipe = new Recipe();
//		recipe.setRecipeNum(1000);
//		recipe.setTitle("Title");
//		recipe.setContent("Content");
//		recipe.setImg("Img.jpg");
//		recipe.setMaterial("Material");
//		
//		Good_division division = new  Good_division();
//		
//		division.setDivision(1);
//		
//		recipe.setGood_division(division);
//		
//		RecipeDAO.insertRecipe(recipe);
//		
//		System.out.println("insert 완료");
//		
//	}
//	
//	@Test
//	public void testupdateRecipe(){
//		Recipe recipe = new Recipe();
//		recipe.setRecipeNum(1000);
//		recipe.setTitle("Title1");
//		recipe.setContent("Content1");
//		recipe.setImg("Img1.jpg");
//		recipe.setMaterial("Material1");
//		RecipeDAO.updateRecipe(recipe);
//		System.out.println("update 완료");
//	}
	
//	@Test
//	public void testdeleteRecipe(){
//		RecipeDAO.deleteRecipe(1000);
//		System.out.println("delete 완료");
//	}
	
	@Test
	public void testselectrecipeList(){
		ArrayList<Good> arrayList =(ArrayList<Good>) GoodDAO.selectRecipeList(1);
	
		for (int i = 0; i < arrayList.size(); i++) {
			Good good = arrayList.get(i);
			System.out.println(good);
		}
	}
	
//	@Test
//	public void testselectrecipe(){
//		Recipe recipe=RecipeDAO.selectRecipe(1);
//		
//		System.out.println(recipe);
//	}
	
//	@Test
//	public void testselectrecipeList(){
//		ArrayList<Recipe> arrayList = RecipeDAO.selectRecipeList(5,2);
//
//		for (int i = 0; i < arrayList.size(); i++) {
//			Recipe recipe = arrayList.get(i);
//			System.out.println(recipe);
//		}
//	}
	
//	@Test
//	public void testselectRelationGood(){
//		Recipe recipe=RecipeDAO.selectRecipe(1);
//		ArrayList<Good>recipeRelativeGoodList=GoodDAO.selectRecipeList(1);
//		
//		System.out.println(recipe);
//		for (int i = 0; i < recipeRelativeGoodList.size(); i++) {
//			Good good = recipeRelativeGoodList.get(i);
//			System.out.println(good);
//		}
//	}

	
//	@Test
//	public void testselectGoodPhotoList(){
//		Good good= GoodDAO.selectGood(30);
//		ArrayList<Photo>arrayList=PhotoDAO.selectGoodPhotoList(30);
//		
//		System.out.println(good);
//		for (int i = 0; i < arrayList.size(); i++) {
//			Photo photo=arrayList.get(i);
//			System.out.println(photo);
//		}
//	}
//	
//	@Test
//	public void testselectGoodRelationRecipeList(){
//		ArrayList<Recipe> list=(ArrayList<Recipe>) RecipeDAO.selectGoodRelationRecipeList(7);
//		
//		for (int i = 0; i < list.size(); i++) {
//			Recipe recipe= list.get(i);
//			System.out.println(recipe);
//		}
//	}
	
//	@Test
//	public void testmaxRecipeNumber(){
//		int maxNumber=RecipeDAO.maxRecipeNumber();
//		System.out.println(maxNumber);
//	}
}
