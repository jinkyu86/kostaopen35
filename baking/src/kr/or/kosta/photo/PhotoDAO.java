package kr.or.kosta.photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.good.Good;
import kr.or.kosta.gooddivision.Good_division;
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
				sql=" select p.p_num, p.recipe_num, p.image" +
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
			sql=" select p.p_num, p.recipe_num, p.image, d.division, d.g_name" +
				" from recipe r, photo p, good_division d " +
				" where r.recipe_num = p.recipe_num " +
				" and p.division=d.division " +
				" and p.recipe_num=? " +
				" order by image ";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, recipeNum);
			
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				Photo photo = new Photo();
				Good_division good_division = new Good_division();
				
				photo.setP_num(rs.getInt(1));
				photo.setRecipe_num(rs.getInt(2));
				photo.setImage(rs.getString(3));
				good_division.setDivision(rs.getInt(4));
				good_division.setgName(rs.getString(5));
				
				photo.setGood_division(good_division);
				
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


//		insert into photo(p_num, recipe_num, image,division)
//		values(10001,30,'test.jpg',1);

		try {
			psmt=con.prepareStatement(
					" insert into photo(P_NUM, RECIPE_NUM, IMAGE, DIVISION) " +
					" values(photo_seq.nextval, ?, ?, ?) ");
//					" values(777, ?, ?, ?) ");
			psmt.setInt(1,recipe_num);
			psmt.setString(2,photo.getImage());
			psmt.setInt(3,photo.getGood_division().getDivision());
			psmt.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();}
	}
}
