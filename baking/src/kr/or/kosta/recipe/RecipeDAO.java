package kr.or.kosta.recipe;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.or.kosta.good.Good;
import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.util.ConnectionUtil;

public class RecipeDAO extends SqlSessionDaoSupport implements IRecipeDAO{
	

	
	@Override
	public int maxRecipeNumber(){
		SqlSession session=null;
		Integer maxNumber=null;
		
		session = getSqlSession();
		maxNumber= session.selectOne("maxRecipeNumber");
		
		return maxNumber;
	}
	
	//�������߰�
	@Override
	public void insertRecipe(Recipe recipe) {
		SqlSession session=null;
		
		session = getSqlSession();
		session.insert("Recipe.insertRecipe",recipe);
		
	}
	
	//�����Ǽ���
	@Override
	public void updateRecipe(Recipe recipe) {
		SqlSession session=null;
		
		session = getSqlSession();
		session.update("Recipe.updateRecipe",recipe);
			
	}
	
	//�����Ǳۻ���
	@Override
	public void deleteRecipe(int recipenum) {
		SqlSession session=null;
		
		session = getSqlSession();
		session.delete("Recipe.deleteRecipe",recipenum);
			
	}
	
	//�����Ǹ���Ʈ
	@Override
	public List<Recipe> selectRecipeList() {
		SqlSession session=null;
		List<Recipe> recipeList=null;
		
		session = getSqlSession();
		recipeList=session.selectList("Recipe.selectRecipeList");
		
		return recipeList;
		
	}
	
	//�����Ǳ��и���Ʈ
	@Override
	public List<Recipe> selectDivisionRecipeList(int divisionNum) {
		SqlSession session=null;
		List<Recipe> recipeList=null;
		
		session = getSqlSession();
		recipeList=session.selectList("Recipe.selectDivisionRecipeList",divisionNum);
		
		return recipeList;
	}
	

	//����������
	@Override
	public Recipe selectRecipe(int recipe_num) {
		SqlSession session=null;
		Recipe recipe=null;
		session = getSqlSession();
		recipe=session.selectOne("Recipe.selectRecipe",recipe_num);
		
		return recipe;
	}
	
	//��ǰ���� ��������ȸ
	@Override
	public List<Recipe>selectGoodRelationRecipeList(int goodNum){
		SqlSession session=null;
		List<Recipe> recipeList=null;
		session = getSqlSession();
		recipeList=session.selectList("Recipe.selectGoodRelationRecipeList",goodNum);
		
		return recipeList;
	}
}
