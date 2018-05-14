package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	//MySQL Driver 6.0 "com.mysql.cj.jdbc.Driver";
	
	private static final String url = "jdbc:mysql://127.0.0.1:3306/jr01?useSSL=false";
	
	private static final String user = "study";
	
	private static final String pw = "study";
	
	@Test
	public void testConnectionTest()throws Exception{
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(url,user,pw)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
