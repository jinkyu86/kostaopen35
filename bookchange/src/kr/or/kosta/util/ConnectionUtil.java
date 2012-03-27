package kr.or.kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {	
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC Driver 연동 성공");
			
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE","scott","tiger");
			System.out.println("데이터베이스 연결 성공");
			//return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return null;
		return con;
		
	}
	public static void main(String[] args) {
		//getConnection();
	}

}
