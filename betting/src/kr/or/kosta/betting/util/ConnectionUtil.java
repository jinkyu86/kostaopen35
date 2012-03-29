package kr.or.kosta.betting.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	 public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.18:1521:XE",
					"scott","tiger");
			System.out.println("데이터베이스에 접속!!");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		getConnection();
		

	}

}

