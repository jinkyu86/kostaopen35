package kr.or.kosta.util;
/*
 * �޼��� :get Connection()
 * -static �޼���
 * -JDBC Driver�ε�
 * -DB ����
 * -Connection ��ü����
 * -JUnit Test Case*/
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	static public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC Driver���� ����");
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