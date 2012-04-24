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

import kr.or.kosta.good.Good;
import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.util.ConnectionUtil;

public class RecipeDAO implements IRecipeDAO{
	

	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
			try {
				sqlReader=Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(sqlReader);
	
	@Override
	public int maxRecipeNumber(){
		SqlSession session=null;
		Integer maxNumber=null;
		try{
		session = sqlMapper.openSession(true);
		maxNumber= session.selectOne("maxRecipeNumber");
		}finally{
			session.close();
		}
		return maxNumber;
	}
	
	//�������߰�
	@Override
	public void insertRecipe(Recipe recipe) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.insert("Recipe.insertRecipe",recipe);
		}finally{
			session.close();
		}
	}
	
	//�����Ǽ���
	@Override
	public void updateRecipe(Recipe recipe) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.update("Recipe.updateRecipe",recipe);
		}finally{
			session.close();
		}	
	}
	
	//�����Ǳۻ���
	@Override
	public void deleteRecipe(int recipenum) {
		SqlSession session=null;
		try{
		session = sqlMapper.openSession(true);
		session.delete("Recipe.deleteRecipe",recipenum);
		}finally{
			session.close();
		}	
	}
	
	//�����Ǹ���Ʈ
	@Override
	public List<Recipe> selectRecipeList() {
		SqlSession session=null;
		List<Recipe> recipeList=null;
		try{
		session = sqlMapper.openSession(true);
		recipeList=session.selectList("Recipe.selectRecipeList");
		}finally{
			session.close();
		}
		return recipeList;
		
	}
	
	//�����Ǳ��и���Ʈ
	@Override
	public List<Recipe> selectDivisionRecipeList(int divisionNum) {
		SqlSession session=null;
		List<Recipe> recipeList=null;
		try{
		session = sqlMapper.openSession(true);
		recipeList=session.selectList("Recipe.selectDivisionRecipeList",divisionNum);
		}finally{
			session.close();
		}
		return recipeList;
	}
	

	//����������
	@Override
	public Recipe selectRecipe(int recipe_num) {
		SqlSession session=null;
		Recipe recipe=null;
		try{
		session = sqlMapper.openSession(true);
		recipe=session.selectOne("Recipe.selectRecipe",recipe_num);
		}finally{
			session.close();
		}
		return recipe;
	}
	
	//��ǰ���� ��������ȸ
	@Override
	public List<Recipe>selectGoodRelationRecipeList(int goodNum){
		SqlSession session=null;
		List<Recipe> recipeList=null;
		try{
		session = sqlMapper.openSession(true);
		recipeList=session.selectList("Recipe.selectGoodRelationRecipeList",goodNum);
		}finally{
			session.close();
		}
		return recipeList;
	}
}
