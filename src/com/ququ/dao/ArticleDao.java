package com.ququ.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.ququ.bean.ArticleBean;
import com.ququ.dbcon.DBConnection;

/**
 * 文章操作
 * 
 * @author bobobo
 *
 */
public class ArticleDao {

	public static void main(String[] args) {
//		String now_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//				.format(Calendar.getInstance().getTime());
//		System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));
		 oneMan_article("1");
	}

	/**
	 * 访问主页主人的文章列表查询(文章正文前50个字)
	 * 
	 * @param phoneNumber
	 */
	public static void oneMan_article(String phoneNumber) {
		StringBuffer sql = new StringBuffer(
				"select * from article where userId = (select userId from userinfo where phoneNumber= '"
						+ phoneNumber + "')");
		Connection con = DBConnection.getDBcon();
		ArrayList<ArticleBean> list = new ArrayList<ArticleBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				ArticleBean ab = new ArticleBean();
				ab.setArticleId(rs.getInt("articleId"));
				if (rs.getString("context").length() < 50) {
					ab.setContext(rs.getString("context"));
				} else {
					ab.setContext(rs.getString("context").substring(0, 50));
				}
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(rs.getTimestamp("createTime"));
				ab.setCreateTime(rs.getTimestamp("createTime"));
				ab.setStatus(rs.getInt("status"));
				ab.setTitle(rs.getString("title"));
				ab.setUserId(rs.getInt("userId"));
				ab.setVisitTimes(rs.getInt("visitTimes"));
				ab.setNickName(Id2NickName(rs.getInt("userId")));
				list.add(ab);
				System.out.println(ab.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConn(con);
		}
	}

	public static String Id2NickName(int userId) {
		StringBuffer sql = new StringBuffer(
				"select * from userinfo where userId = '" + userId + "'");
		Connection con = DBConnection.getDBcon();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			rs.next();
			return rs.getString("nickName");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConn(con);
		}
		return null;
	}

	public boolean articleQuery(String title, String context, int type) {
		StringBuffer sql = new StringBuffer(
				"select * from article where title = '" + title
						+ "' and context = '" + context + "' and type = '"
						+ type + "'");
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

	public int articleInsert(String title, String context, String type,
			int userId, int visitTimes) {
		StringBuffer sql = new StringBuffer(
				"insert into userInfo(title,context,type,userId,createTime,visitTimes) values('"
						+ title
						+ "','"
						+ context
						+ "','"
						+ type
						+ "','"
						+ userId
						+ "','"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
						+ "','"
						+ visitTimes + "')");
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
