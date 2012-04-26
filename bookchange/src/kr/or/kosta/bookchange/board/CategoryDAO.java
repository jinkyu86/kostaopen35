package kr.or.kosta.bookchange.board;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.or.kosta.util.ConnectionUtil;

public class CategoryDAO extends SqlSessionDaoSupport implements ICategoryDAO {
	
	@Override
	public List<Category> selectCategory(){
		SqlSession session=null;
		List<Category> categoryList=null;
		
			session=getSqlSession();
			categoryList=session.selectList("Category.selectCategoryList");
		
		return categoryList;
		
		/*Connection con=null;
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
	}*/

}
}