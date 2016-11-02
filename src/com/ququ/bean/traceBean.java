package com.ququ.bean;

import java.util.Date;
/**
 * 最近浏览足迹
 * @author bobobo
 *
 */
public class traceBean {
	int traceId;
	int hostUserId;
	int guestUserId;
	Date createTime;
	//外加字段
	String guestUser_nickName;
	String guestUser_headImage;
	public traceBean(int traceId, int hostUserId, int guestUserId,
			Date createTime, String guestUser_nickName,
			String guestUser_headImage) {
		super();
		this.traceId = traceId;
		this.hostUserId = hostUserId;
		this.guestUserId = guestUserId;
		this.createTime = createTime;
		this.guestUser_nickName = guestUser_nickName;
		this.guestUser_headImage = guestUser_headImage;
	}
	public traceBean() {
		super();
	}
	public int getTraceId() {
		return traceId;
	}
	public void setTraceId(int traceId) {
		this.traceId = traceId;
	}
	public int getHostUserId() {
		return hostUserId;
	}
	public void setHostUserId(int hostUserId) {
		this.hostUserId = hostUserId;
	}
	public int getGuestUserId() {
		return guestUserId;
	}
	public void setGuestUserId(int guestUserId) {
		this.guestUserId = guestUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getGuestUser_nickName() {
		return guestUser_nickName;
	}
	public void setGuestUser_nickName(String guestUser_nickName) {
		this.guestUser_nickName = guestUser_nickName;
	}
	public String getGuestUser_headImage() {
		return guestUser_headImage;
	}
	public void setGuestUser_headImage(String guestUser_headImage) {
		this.guestUser_headImage = guestUser_headImage;
	}
	@Override
	public String toString() {
		return "traceBean [traceId=" + traceId + ", hostUserId=" + hostUserId
				+ ", guestUserId=" + guestUserId + ", createTime=" + createTime
				+ ", guestUser_nickName=" + guestUser_nickName
				+ ", guestUser_headImage=" + guestUser_headImage + "]";
	}
	
}
