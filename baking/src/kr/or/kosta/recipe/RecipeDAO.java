package kr.or.kosta.recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.good.Good;
import kr.or.kosta.gooddivision.GoodDivisionDAO;
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.util.ConnectionUtil;

public class RecipeDAO {

	
	//레시피추가
	public static void insertRecipe(Recipe recipe) {
		Connection con =null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="";
		
		try {
			sql="insert into RECIPE(RECIPE_NUM, TITLE, CONTENT, IMG, MATERIAL) " +
//				" values(recipe_seq.nextval, ?, ?, ?, ?)";
				" values(1000, ?, ?, ?, ?)";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, recipe.getTitle());
			psmt.setString(2, recipe.getContent());
			psmt.setString(3, recipe.getImg());
			psmt.setString(4, recipe.getMaterial());
			psmt.executeUpdate();
			
		} catch (SQLException e) {	e.printStackTrace();}
	}

	//레시피리스트_페이징
	public static ArrayList<Recipe> selectRecipeList(int length, int page) {
		Connection con =null;
		PreparedStatement psmt =null;
		con=ConnectionUtil.getConnection();
		ResultSet rs =null;
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		
		String sql="";
		
		try {
			sql="select R.RECIPE_NUM ,R.TITLE, R.CONTENT, R.IMG, R.MATERIAL, R.DIVISION, G.g_NAME " +
			    " from RECIPE R, GOOD_DIVISION G " +
			    " where R.DIVISION=G.DIVISION ";
			
			psmt=con.prepareStatement(sql);
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			int getRecordCount=0;
			
			while (rs.next() && getRecordCount<length) {
				getRecordCount++;
				Recipe recipe = new Recipe();
				Good_division good_division = new Good_division();
				int recipe_num=rs.getInt(1);
				String title=rs.getString(2);
				String content=rs.getString(3);
				String img=rs.getString(4);
				String material=rs.getString(5);
				int division=rs.getInt(6);
				String g_name=rs.getString(7);
				
				recipe.setRecipeNum(recipe_num);
				recipe.setTitle(title);
				recipe.setContent(content);
				recipe.setImg(img);
				recipe.setMaterial(material);
				
				good_division.setDivision(division);
				good_division.setgName(g_name);
		
				recipe.setGood_division(good_division);
				
				recipeList.add(recipe);
			}
		} catch (SQLException e) {	e.printStackTrace();}
		
		return recipeList;
	}	
	
	//레시피리스트
	public static ArrayList<Recipe> selectRecipeList() {
		Connection con =null;
		PreparedStatement psmt =null;
		con=ConnectionUtil.getConnection();
		ResultSet rs =null;
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		String sql="";
		
		try {
			sql="select R.RECIPE_NUM ,R.TITLE, R.CONTENT, R.IMG, R.MATERIAL, R.DIVISION, G.g_NAME " +
			    " from RECIPE R, GOOD_DIVISION G " +
			    " where R.DIVISION=G.DIVISION ";
			
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				Recipe recipe = new Recipe();
				Good_division good_division = new Good_division();
				int recipe_num=rs.getInt(1);
				String title=rs.getString(2);
				String content=rs.getString(3);
				String img=rs.getString(4);
				String material=rs.getString(5);
				int division=rs.getInt(6);
				String g_name=rs.getString(7);
				
				recipe.setRecipeNum(recipe_num);
				recipe.setTitle(title);
				recipe.setContent(content);
				recipe.setImg(img);
				recipe.setMaterial(material);
				
				good_division.setDivision(division);
				good_division.setgName(g_name);
		
				recipe.setGood_division(good_division);
				
				recipeList.add(recipe);
			}
		} catch (SQLException e) {	e.printStackTrace();}
		
		return recipeList;
	}
	
	//레시피구분리스트
		public static ArrayList<Recipe> selectDivisionRecipeList(int divisionNum) {
			Connection con =null;
			PreparedStatement psmt =null;
			con=ConnectionUtil.getConnection();
			ResultSet rs =null;
			ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
			String sql="";
			
			try {
				sql="select R.RECIPE_NUM ,R.TITLE, R.CONTENT, R.IMG, R.MATERIAL, R.DIVISION, G.g_NAME " +
				    " from RECIPE R, GOOD_DIVISION G " +
				    " where R.DIVISION=G.DIVISION and R.DIVISION=?";
				
				con=ConnectionUtil.getConnection();
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, divisionNum);
				rs=psmt.executeQuery();
				
				while (rs.next()) {
					Recipe recipe = new Recipe();
					Good_division good_division = new Good_division();
					int recipe_num=rs.getInt(1);
					String title=rs.getString(2);
					String content=rs.getString(3);
					String img=rs.getString(4);
					String material=rs.getString(5);
					int division=rs.getInt(6);
					String g_name=rs.getString(7);
					
					recipe.setRecipeNum(recipe_num);
					recipe.setTitle(title);
					recipe.setContent(content);
					recipe.setImg(img);
					recipe.setMaterial(material);
					
					good_division.setDivision(division);
					good_division.setgName(g_name);
			
					recipe.setGood_division(good_division);
					
					recipeList.add(recipe);
				}
			} catch (SQLException e) {	e.printStackTrace();}
			
			return recipeList;
		}
	

	//레시피정보
	public static Recipe selectRecipe(int recipenum) {
		Connection con =null;
		PreparedStatement psmt =null;
		con=ConnectionUtil.getConnection();
		ResultSet rs =null;
		Recipe recipe = new Recipe();
		Good_division good_division = new Good_division();
		String sql="";
		
		try {
			sql="select R.RECIPE_NUM ,R.TITLE, R.CONTENT, R.IMG, R.MATERIAL, R.DIVISION, G.g_NAME " +
				    " from RECIPE R, GOOD_DIVISION G " +
				    " where R.DIVISION=G.DIVISION and R.RECIPE_NUM=?";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, recipenum);
			rs=psmt.executeQuery();
			while(rs.next()){
				recipe.setRecipeNum(rs.getInt(1));
				recipe.setTitle(rs.getString(2));
				recipe.setContent(rs.getString(3));
				recipe.setImg(rs.getString(4));
				recipe.setMaterial(rs.getString(5));
				good_division.setDivision(rs.getInt(6));
				good_division.setgName(rs.getString(7));
				
				recipe.setGood_division(good_division);
				
			}
			} catch (SQLException e) {	e.printStackTrace();}
			
		
		return recipe;
	}

	//레시피관련상품조회
	public static ArrayList<Recipe> selectRelationGood(int recipeNum) {
		Connection con =null;
		PreparedStatement psmt =null;
		con=ConnectionUtil.getConnection();
		ResultSet rs =null;
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		
		String sql="";
		
		try {
			sql=" select GOOD_NUM, RECIPE_NUM " +
				" from GOOD_RECIPE_RELATION" +
				" where RECIPE_NUM=? ";
			
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, recipeNum);
			
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				Recipe recipe = new Recipe();
				Good good = new Good();
				
				int good_num=rs.getInt(1);
				int recipe_num=rs.getInt(2);
				
				good.setGoodNum(good_num);
				
				recipe.setGood(good);
				recipe.setRecipeNum(recipe_num);
			
				recipeList.add(recipe);
			}
		} catch (SQLException e) {	e.printStackTrace();}

		return recipeList;
	}

	//레시피글삭제
	public static void deleteRecipe(int recipenum) {
		Connection con =null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="";
		
		try {
			sql=" delete from RECIPE where RECIPE_NUM=? ";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, recipenum);
			psmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		
	}

	//레시피수정
	public static void updateRecipe(Recipe recipe) {
		Connection con =null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="";
		
		try {
			sql="update RECIPE SET TITLE=?, CONTENT=?, IMG=?, MATERIAL=? " +
				" where RECIPE_NUM=? ";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, recipe.getTitle());
			psmt.setString(2, recipe.getContent());
			psmt.setString(3, recipe.getImg());
			psmt.setString(4, recipe.getMaterial());
			psmt.setInt(5, recipe.getRecipeNum());
			psmt.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();}
	}
	
	//상품관련 레시피조회
	public static ArrayList<Recipe>selectRecipeList(int goodNum){
		Connection con =null;
		PreparedStatement psmt=null;
		ResultSet rs= null;
		ArrayList<Recipe> goodToRecipeList = new ArrayList<Recipe>();
		String sql="select grr.good_num,grr.recipe_num,r.recipe_num,r.title,r.content,r.img,r.material,r.division,d.g_name"+
					" from good_recipe_relation grr,recipe r,good_division d"+
					" where grr.recipe_num=r.recipe_num and d.division=r.division and grr.good_num=?";
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, goodNum);
			rs=psmt.executeQuery();
			while(rs.next()){
				int good_num=rs.getInt(1);
				int recipe_num=rs.getInt(2);
				int recipeNum=rs.getInt(3);
				String title=rs.getString(4);				
				String content=rs.getString(5);	
				String img	=rs.getString(6);		
				String material=rs.getString(7);	
				int division=rs.getInt(8);
				String gName=rs.getString(9);
				
				Good good = new Good();
				Recipe recipe = new Recipe();
				Good_division good_division=new Good_division();
				good.setGoodNum(goodNum);
				good_division.setDivision(division);
				recipe.setRecipeNum(recipeNum);
				recipe.setTitle(title);
				recipe.setContent(content);
				recipe.setImg(img);
				recipe.setMaterial(material);
				good_division.setgName(gName);
				
				recipe.setGood(good);
				recipe.setGood_division(good_division);
				
				goodToRecipeList.add(recipe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodToRecipeList;
	}
}
