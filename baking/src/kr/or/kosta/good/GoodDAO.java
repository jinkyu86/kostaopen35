package kr.or.kosta.good;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.util.ConnectionUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GoodDAO {
	private static String resource="sqlmap-config.xml";
	private static Reader sqlReader;
	static{
		try {
			sqlReader=Resources.getResourceAsReader(resource);//sqlmap-config.xml을 읽어들임.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private static SqlSessionFactory sqlMapper=
	new SqlSessionFactoryBuilder().build(sqlReader); //sql쿼리를 읽어서 map(key:insertDepartment,value:insert into.... 가 들어감)에 저장(SqlSessionFactory)

	/**
	 * 상품추가 
	 * @return 
	 */
	public static int insertGood(Good good){
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true); //sql맵에 있는 쿼리 실행.
			session.insert("Good.insertGood",good);
		}finally{
			session.close();
		}
		return good.getGoodNum();
	}
	/*public static void insertGood(Good good) {
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
*/
	/**
	 * 상품리스트 보기
	 */
	public static List<Good> selectGoodList() {
		SqlSession session = null;
		List<Good> goodList =null;
		try{
			session = sqlMapper.openSession(true); //sql맵에 있는 쿼리 실행.
			goodList = session.selectList("Good.selectGoodList");
		}finally{
			session.close();
		}
		return goodList;
	}
	/*public static ArrayList<Good> selectGoodList() {
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
*/
	/**
	 * 상품상세보기
	 */
	public static Good selectGood(int goodNum) {
		SqlSession session = null;
		Good good=null;
		try{
		     session = sqlMapper.openSession(true); //sql맵에 있는 쿼리 실행.
		     good = session.selectOne("Good.selectGood",goodNum);
		}finally{
			session.close();
		}
		return good;
	}
	/*public static Good selectGood(int goodnum) {
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
	}*/

	/**
	 * 상품삭제
	 */
	public static void deleteGood(int goodnum) {
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true); //sql맵에 있는 쿼리 실행.
			session.delete("Good.deleteGood",goodnum);
		}finally{
			session.close();
		}
	}
	/*public static void deleteGood(int goodnum) {
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
	}*/

	/**
	 * 상품수정
	 */
	public static void updateGood(Good good) {
		SqlSession session=null;
		try{
			session = sqlMapper.openSession(true); //sql맵에 있는 쿼리 실행.
			session.update("Good.updateGood",good);
		}finally{
			session.close();
		}
	}
	/*public static void updateGood(Good good) {
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
	}*/
	
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
				 " g.name, g.division, g.good_price, g.qty, g.explantion, g.img, g.g_option, " +
				 " d.g_name "+
				 " from good_recipe_relation r, good g, good_division d " +
				 " where r.good_num=g.good_num " +
				 " and g.division=d.division " +
				 " and r.recipe_num=? " +
				 " order by r.good_num ";
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
				String gName=rs.getString(10);
				
				good.setGoodNum(good_num);
				recipe.setRecipeNum(recipe_num);
				good.setName(name);
				good_division.setDivision(division);
				good.setGoodPrice(price);
				good.setQty(qty);
				good.setExplantion(explantion);
				good.setImg(img);
				good.setOption(gOption);
				good_division.setgName(gName);
				
				good.setGood_division(good_division);
				good.setRecipe(recipe);

				arrayList.add(good);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return arrayList;
	}
	
	public static List<Good> viewDivisionGoodList(int division){
		SqlSession session = null;
		List<Good> divisionGoodList = null;
		try{
			session = sqlMapper.openSession();
			divisionGoodList = session.selectList("Good.viewDivisionGoodList",division);
		}finally{
			session.close();
		}
		return divisionGoodList;
	}
	/*public static ArrayList<Good> viewDivisionGoodList(int division){
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select good_num,g.division,good_price,qty,name,explantion,img,g_option,g_name"+
					 " from good g, good_division gd"+
					 " where g.division=gd.division and gd.division=?";
		ArrayList<Good> goodList = new ArrayList<Good>();
		try {
			con=ConnectionUtil.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, division);
			rs=psmt.executeQuery();
			while(rs.next()){
				int goodNum=rs.getInt(1);
				division =rs.getInt(2);
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
	}*/
}
