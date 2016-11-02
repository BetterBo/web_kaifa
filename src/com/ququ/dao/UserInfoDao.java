package com.ququ.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.ququ.dbcon.DBConnection;

/**
 * �û�����
 * 
 * @author bobobo
 *
 */
public class UserInfoDao {
	/**
	 * �û���¼��ѯ
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 */
	public boolean query(String phoneNumber, String password) {
		StringBuffer sql = new StringBuffer(
				"select * from userInfo where phoneNumber = '" + phoneNumber
						+ "' and password = '" + password + "'");
		Connection con = DBConnection.getDBcon();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConn(con);
		}
		return false;
	}

	/**
	 * �û�ע�����
	 * 
	 * @param nickname
	 * @param password
	 * @param phoneNumber
	 * @return
	 */
	public int insert(String nickname, String password, String phoneNumber) {
		StringBuffer sql = new StringBuffer(
				"insert into userInfo(phoneNumber,password,nickName,score,creatTime,lastModifyTime) values('"
						+ phoneNumber
						+ "','"
						+ password
						+ "','"
						+ nickname
						+ "','"
						+ 0
						+ "','"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.format(Calendar.getInstance().getTime())
						+ "','"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.format(Calendar.getInstance().getTime())
						+ "')");
		Connection con = DBConnection.getDBcon();
		try {
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(sql.toString());
			// System.out.println(rs);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeConn(con);
		}
		return 0;
	}

}
