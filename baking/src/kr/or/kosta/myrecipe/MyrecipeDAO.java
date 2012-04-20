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
			sqlReader=Resources.getResourceAsReader(resource);//sqlmap-config.xml�� �о����.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private static SqlSessionFactory sqlMapper=
	new SqlSessionFactoryBuilder().build(sqlReader); //sql������ �о map(key:insertDepartment,value:insert into.... �� ��)�� ����(SqlSessionFactory)

	/**
	 * �����Ǳۻ���
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
	 * �Խñ۸���Ʈ����
	 */
	public static List<Myrecipe> selectMyrecipeList(int length,int page) {
		SqlSession session = null;
		List<Myrecipe> myrecipeList = null;
		try{
			session=sqlMapper.openSession();
			//��ȸ�� ���ڵ��� ���� �ε���,���ڵ�� ���� ��ü
			RowBounds rowBounds = new RowBounds((page-1)*length,length);
			myrecipeList=session.selectList("Myrecipe.selectMyrecipeList",null,rowBounds);
		}finally{
			session.close();
		}
		return myrecipeList;
	}

	/**
	 * �Խñۻ󼼺��� 
	 */
	public static Myrecipe selectMyrecipe(int boardnum) {
		return null;
	}

	/**
	 * �Խñ� ����
	 */
	public static void deleteMyrecipe(int boardnum) {
		
	}

	/**
	 * �Խñ� ����
	 */
	public static void updateMyrecipe(Myrecipe myrecipe) {

	}
	
	/**
	 * ��ü ������ �� ��ȸ
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
