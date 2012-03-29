package kr.or.kosta.good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.util.ConnectionUtil;

public class GoodDAO {

	/**
	 * 상품추가 
	 */
	public static void insertGood(Good good) {
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="insert into good values(good_seq.nextval,?,?,?,?,?,?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, good.getGood_division().getDivision());
			psmt.setInt(2, good.getGoodPrice());
			psmt.setInt(3, good.getQty());
			psmt.setString(4, good.getName());
			psmt.setString(5, good.getExplantion());
			psmt.setString(6, good.getImg());
			psmt.setString(7, good.getOption());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 상품리스트 보기
	 */
	public static ArrayList<Good> selectGoodList() {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select good_num,g.division,good_price,qty,name,explantion,img,g_option,g_name"+
					 " from good g, good_division gd"+
					 " where g.division=gd.division";
		ArrayList<Good> goodList = new ArrayList<Good>();
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				int goodNum=rs.getInt(1);
				int division =rs.getInt(2);
				int goodPrice=rs.getInt(3);
				int qty=rs.getInt(4);
				String name=rs.getString(5);
				String explantion=rs.getString(6);
				String img=rs.getString(7);
				String option=rs.getString(8);
				String gName=rs.getString(9);
				
				Good_division good_division=new Good_division();
				good_division.setDivision(division);
				good_division.setgName(gName);
				
				Good good= new Good();
				good.setGoodNum(goodNum);
				good.setGood_division(good_division);
				good.setGoodPrice(goodPrice);
				good.setQty(qty);
				good.setName(name);
				good.setExplantion(explantion);
				good.setImg(img);
				good.setOption(option);
				
				goodList.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodList;
	}
	
	public static ArrayList<Good> selectGoodList(int length, int page) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select good_num,g.division,good_price,qty,name,explantion,img,g_option,g_name"+
					 " from good g, good_division gd"+
					 " where g.division=gd.division";
		ArrayList<Good> goodList = new ArrayList<Good>();
		try {
			con=ConnectionUtil.getConnection();
			
			  //rs.absolute()가 가능하도록 설정
			psmt=con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=psmt.executeQuery();
			
			if(page>1){
				rs.absolute((page-1)*length);
			}
			
			//가져온 레코드 개수
			int getRecordCount=0;
			while(rs.next()&&getRecordCount<length){
				getRecordCount++;
				int goodNum=rs.getInt(1);
				int division =rs.getInt(2);
				int goodPrice=rs.getInt(3);
				int qty=rs.getInt(4);
				String name=rs.getString(5);
				String explantion=rs.getString(6);
				String img=rs.getString(7);
				String option=rs.getString(8);
				String gName=rs.getString(9);
				
				Good_division good_division=new Good_division();
				good_division.setDivision(division);
				good_division.setgName(gName);
				
				Good good= new Good();
				good.setGoodNum(goodNum);
				good.setGood_division(good_division);
				good.setGoodPrice(goodPrice);
				good.setQty(qty);
				good.setName(name);
				good.setExplantion(explantion);
				good.setImg(img);
				good.setOption(option);
				
				goodList.add(good);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodList;
	}

	/**
	 * 상품상세보기
	 */
	public static Good selectGood(int goodnum) {
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Good good= new Good();
		String sql="select g.division,good_price,qty,name,explantion,img,g_option,g_name"+
					 " from good g, good_division gd"+
					 " where g.division=gd.division and good_num=?";
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, goodnum);
			rs=psmt.executeQuery();
			if(rs.next()){
				int division =rs.getInt(1);
				int goodPrice=rs.getInt(2);
				int qty=rs.getInt(3);
				String name=rs.getString(4);
				String explantion=rs.getString(5);
				String img=rs.getString(6);
				String option=rs.getString(7);
				String gName=rs.getString(8);
				
				Good_division good_division=new Good_division();
				good_division.setDivision(division);
				good_division.setgName(gName);
				
				good.setGoodNum(goodnum);
				good.setGood_division(good_division);
				good.setGoodPrice(goodPrice);
				good.setQty(qty);
				good.setName(name);
				good.setExplantion(explantion);
				good.setImg(img);
				good.setOption(option);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return good;
	}

	/**
	 * 상품삭제
	 */
	public static void deleteGood(int goodnum) {
		Connection con =null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		String sql="delete good where good_num=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, goodnum);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 상품수정
	 */
	public static void updateGood(Good good) {
		Connection con=null;
		PreparedStatement psmt=null;
		String sql="update good"+
					" set division=?,good_price=?,qty=?,name=?,explantion=?,img=?,g_option=?"+
					" where good_num=?";
		con=ConnectionUtil.getConnection();
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, good.getGood_division().getDivision());
			psmt.setInt(2, good.getGoodPrice());
			psmt.setInt(3, good.getQty());
			psmt.setString(4, good.getName());
			psmt.setString(5, good.getExplantion());
			psmt.setString(6, good.getImg());
			psmt.setString(7, good.getOption());
			psmt.setInt(8, good.getGoodNum());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//레시피관련 상품조회
	public static ArrayList<Good>selectRecipeList(int recipeNum){
		Connection con =null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
		ResultSet rs= null;
		ArrayList<Good> arrayList = new ArrayList<Good>();
		String sql="";
		
		try {
			sql=" select r.good_num, r.recipe_num, " +
				 " g.name, g.division, g.good_price, g.qty, g.explantion, g.img, g.g_option " +
				 " from good_recipe_relation r, good g " +
				 " where r.good_num=g.good_num and r.recipe_num=? ";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, recipeNum);
			rs=psmt.executeQuery();
			
			
			while(rs.next()){
				Good good = new Good();
				Recipe recipe = new Recipe();
				Good_division good_division= new Good_division();
				int good_num =rs.getInt(1);
				int recipe_num =rs.getInt(2);
				String name =rs.getString(3);
				int division =rs.getInt(4);
				int price =rs.getInt(5);
				int qty =rs.getInt(6);
				String explantion =rs.getString(7);
				String img =rs.getString(8);
				String gOption =rs.getString(9);
				
				good.setGoodNum(good_num);
				recipe.setRecipeNum(recipe_num);
				good.setName(name);
				good_division.setDivision(division);
				good.setGoodPrice(price);
				good.setQty(qty);
				good.setExplantion(explantion);
				good.setImg(img);
				good.setOption(gOption);
				
				good.setGood_division(good_division);
				good.setRecipe(recipe);

				arrayList.add(good);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return arrayList;
	}
}
