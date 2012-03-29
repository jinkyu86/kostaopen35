package kr.or.kosta.auction.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=
					DriverManager.getConnection("jdbc:oracle:thin:@172.20.10.3:1521:XE",
							"scott","tiger");
			System.out.println("연동성공");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
