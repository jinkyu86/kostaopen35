package kr.or.kosta.moviesystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	
	public static Connection getConnection(){
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection
					("jdbc.:oracle:thin:@192.168.43.210:1521:XE","scott","tiger");
			
			/*
			con = DriverManager.getConnection
					("jdbc.:oracle:thin:@192.168.0.28:1521:XE","scott","tiger");
			*/
			System.out.println("�����ͺ��̽� ����");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("���α׷� ����");
		return con;
	}

	public static void main(String[] args) {
		
		ConnectionUtil cu = new ConnectionUtil();
		
	

	}

}
