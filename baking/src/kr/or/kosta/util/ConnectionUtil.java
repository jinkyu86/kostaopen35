package kr.or.kosta.util;
/*
 * 메서드 :get Connection()
 * -static 메서드
 * -JDBC Driver로드
 * -DB 접속
 * -Connection 객체리턴
 * -JUnit Test Case*/
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	static public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC Driver연동 성공");
			Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.90:1521:XE",
					"scott","tiger");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Connection con=getConnection();
	}
}