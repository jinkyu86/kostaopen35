package kr.or.kosta.photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.good.Good;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.util.ConnectionUtil;

public class PhotoDAO {

	//상품관련 이미지조회
	public static ArrayList<Photo> selectGoodPhotoList(int goodNum){
		Connection con =null;
		PreparedStatement psmt =null;
		con=ConnectionUtil.getConnection();
		ResultSet rs =null;
		ArrayList<Photo> photoList = new ArrayList<Photo>();
		String sql="";
		
		try {
				sql=" select p.p_num, p.recipe_num, p.image " +
					" from good g, photo p " +
					" where g.good_num = p.good_num " +
					" and g.good_num=? ";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, goodNum);
				
				rs=psmt.executeQuery();
				
				while (rs.next()) {
					Photo photo = new Photo();
					
					photo.setP_num(rs.getInt(1));
					photo.setRecipe_num(rs.getInt(2));
					photo.setImage(rs.getString(3));

					photoList.add(photo);
				}
				
		} catch (SQLException e) {	e.printStackTrace();}
		
		
		return photoList;
	}
	
	//레시피관련 이미지조회
	public static ArrayList<Photo> selectRecipePhotoList(int recipeNum){
		Connection con =null;
		PreparedStatement psmt =null;
		con=ConnectionUtil.getConnection();
		ResultSet rs =null;
		ArrayList<Photo> photoList = new ArrayList<Photo>();
		String sql="";
		
		try {
			sql=" select p.p_num, p.recipe_num, p.image " +
				" from recipe r, photo p " +
				" where r.recipe_num = p.recipe_num " +
				" and p.recipe_num=? ";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, recipeNum);
			
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				Photo photo = new Photo();
				
				photo.setP_num(rs.getInt(1));
				photo.setRecipe_num(rs.getInt(2));
				photo.setImage(rs.getString(3));

				photoList.add(photo);
			}
			
		} catch (SQLException e) {	e.printStackTrace();}
		
		return photoList;
	}
	
	//이미지추가
	public static void insertPhoto(Photo photo, int recipe_num){
		Connection con=null;
		PreparedStatement psmt=null;
		con=ConnectionUtil.getConnection();
//		sql="insert into photo(시퀀스, RecipeNum, img이름, 구분)";
		try {
			psmt=con.prepareStatement(
					"insert into photo" +
					" (p_num,  Recipe_num, image, division)" +
					" values(?, ?, ?, ?)");
			psmt.setInt(1,photo.getP_num());
			psmt.setInt(2,photo.getRecipe_num());
			psmt.setString(3,photo.getImage());
			psmt.setInt(4,photo.getDivision());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
