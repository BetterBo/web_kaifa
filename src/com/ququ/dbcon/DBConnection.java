package com.ququ.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 数据库连接管理类
 */
public class DBConnection {

	public static final String URL="jdbc:sqlserver://127.0.0.1:1433;databasename=web_project";
	public static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String USER="sa";
	public static final String PASSWORD="121258";
	
	static {
		try {
			//注册驱动程序
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取数据库连接对象
	 */
	public static Connection getDBcon(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 释放数据库连接对象
	 */
	public static void closeConn(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			if(con!=null){
				con = null;
			}
		}
	}
	
//	public static void main(String[] args) {
//		Connection con = DBConnection.getDBcon();
//		System.out.println(con);
//		DBConnection.closeConn(con);
//	}
}
