package kr.or.kosta.myrecipe;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyrecipeDAO {
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
	 * 레시피글삽입
	 */
	public static void insertMyrecipe(Myrecipe myrecipe) {
		SqlSession session=null;
		try{
			session = sqlMapper.openSession();
			session.insert("Myrecipe.insertMyrecipe",myrecipe);
		}finally{
			session.close();
		}
	}

	/**
	 * 게시글리스트보기
	 */
	public static List<Myrecipe> selectMyrecipeList(int length,int page) {
		SqlSession session = null;
		List<Myrecipe> myrecipeList = null;
		try{
			session=sqlMapper.openSession();
			//조회할 레코드의 시작 인덱스,레코드수 설정 객체
			RowBounds rowBounds = new RowBounds((page-1)*length,length);
			myrecipeList=session.selectList("Myrecipe.selectMyrecipeList",null,rowBounds);
		}finally{
			session.close();
		}
		return myrecipeList;
	}

	/**
	 * 게시글상세보기 
	 */
	public static Myrecipe selectMyrecipe(int boardnum) {
		return null;
	}

	/**
	 * 게시글 삭제
	 */
	public static void deleteMyrecipe(int boardnum) {
		
	}

	/**
	 * 게시글 수정
	 */
	public static void updateMyrecipe(Myrecipe myrecipe) {

	}
	
	/**
	 * 전체 레시피 수 조회
	 */
	public static int selectMyrecipeCount(){
		SqlSession session=null;
		Integer count =0;
		try{
			session = sqlMapper.openSession();
			count=session.selectOne("Myrecipe.selectMyrecipeCount");
		}finally{
			session.close();
		}
		return count;
	}
}
