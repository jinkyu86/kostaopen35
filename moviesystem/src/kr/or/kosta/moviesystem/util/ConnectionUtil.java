package kr.or.kosta.moviesystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	
	public static Connection getConnection(){
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
					("jdbc.:oracle:thin:@127.0.0.1:1521:XE","scott","tiger");
			System.out.println("데이터베이스 연결");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
		return con;
	}

	public static void main(String[] args) {
		
		ConnectionUtil cu = new ConnectionUtil();
		
	

	}

}
