package com.ququ.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ququ.dbcon.DBConnection;

public class UserInfoDao {
	public boolean query(String username,String password){
		StringBuffer sql=new StringBuffer("select * from userInfo where phoneNumber = '"+username+"' and password = '"+password+"'");
		Connection con = DBConnection.getDBcon();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnection.closeConn(con);
		return false;
	}
	public int insert(String nickname,String password,String ensure_password,String username){
		StringBuffer sql = new StringBuffer("insert into userInfo(nickname,password,ensure_password,username) values('"+nickname+"','"+password+"','"+ensure_password+"','"+username+"')");
		Connection con = DBConnection.getDBcon();
		try {
			Statement stmt=con.createStatement();
			int rs = stmt.executeUpdate(sql.toString());
			System.out.println(rs);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConn(con);
		return 0;
	}

}
