package kr.or.kosta.bookchange.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.util.ConnectionUtil;

public class CategoryDAO {
	public static ArrayList<Category> selectCategory(){
		Connection con=null;
		PreparedStatement ps=null;
		con=ConnectionUtil.getConnection();
		String sql=null;
		ResultSet rs=null;
		ArrayList<Category> categoryList=new ArrayList<Category>();
		
		try{
		sql="select category_no, category_name from tb_category";
		ps=con.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
		String categoryNo=rs.getString(1);
		String categoryName=rs.getString(2);
		
		Category category=new Category();
		category.setCategoryNo(Integer.parseInt(categoryNo));
		category.setCategoryName(categoryName);
		
		categoryList.add(category);		
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return categoryList;		
	}

}
