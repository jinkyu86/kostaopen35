package kr.or.kosta.photo;

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
import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.util.ConnectionUtil;

public class PhotoDAO extends SqlSessionDaoSupport implements IPhotoDAO{

	//상품관련 이미지조회
	@Override
	public  List<Photo> selectGoodPhotoList(int goodNum){
		SqlSession session=null;
		List<Photo> photoList=null;
		
		session = getSqlSession();
		photoList=session.selectList("Photo.selectGoodPhotoList",goodNum);

		return photoList;
	}
	
	//레시피관련 이미지조회
	@Override
	public  List<Photo> selectRecipePhotoList(int recipeNum){
		SqlSession session=null;
		List<Photo> photoList=null;
		
		session = getSqlSession();
		photoList=session.selectList("Photo.selectRecipePhotoList",recipeNum);

		return photoList;
	}

	
	//이미지추가
	@Override
	public  void insertPhoto(Photo photo){
		SqlSession session=null;
		
		session = getSqlSession();
		session.insert("Photo.insertPhoto",photo);

	}
}
