package com.ququ.bean;

import java.util.Date;
/**
 * 个人信息
 * @author bobobo
 *
 */
public class UserInfoBean {
	private int userId;
	private String phoneNumber;
	private String password;
	private String headImage;
	private String nickName;
	private int score;
	private Date createTime;
	private Date lastModifyTime;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public UserInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserInfoBean(int userId, String phoneNumber, String password,
			String headImage, String nickName, int score, Date createTime,
			Date lastModifyTime) {
		super();
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.headImage = headImage;
		this.nickName = nickName;
		this.score = score;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}
	@Override
	public String toString() {
		return "UserInfoBean [userId=" + userId + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", headImage="
				+ headImage + ", nickName=" + nickName + ", score=" + score
				+ ", createTime=" + createTime + ", lastModifyTime="
				+ lastModifyTime + "]";
	}
	
	
	

}
