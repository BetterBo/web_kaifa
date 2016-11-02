package com.ququ.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * ���ݿ����ӹ�����
 */
public class DBConnection {

	public static final String URL="jdbc:mysql://localhost:3306/project_web?useUnicode=true&characterEncoding=utf-8";
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String USER="root";
	public static final String PASSWORD="xiaobo52011";
	
	static {
		try {
			//ע����������
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ȡ���ݿ����Ӷ���
	 */
	public static Connection getDBcon(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * �ͷ����ݿ����Ӷ���
	 */
	public static void closeConn(Connection con){
		try {
			con.close();
		} catch (Exception e) {
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
