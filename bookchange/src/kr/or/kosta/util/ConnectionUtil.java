package kr.or.kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {	
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC Driver ���� ����");
			
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.1.52:1521:XE","first","tiger");
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
	}

}
