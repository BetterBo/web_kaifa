package com.ququ.bean;

import java.util.Date;

/**
 * 文章评论
 * @author bobobo
 *
 */
public class CommentBean {
	int commentId;
	String commentContent;
	int articleId;
	int userId;
	Date createTime;
	int goodTimes;
	int badTimes;
	int status;
	//外加字段
	String nickName;

	public CommentBean(int commentId, String commentContent, int articleId,
			int userId, Date createTime, int goodTimes, int badTimes,
			int status, String nickName) {
		super();
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.articleId = articleId;
		this.userId = userId;
		this.createTime = createTime;
		this.goodTimes = goodTimes;
		this.badTimes = badTimes;
		this.status = status;
		this.nickName = nickName;
	}
	public CommentBean() {
		super();
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getGoodTimes() {
		return goodTimes;
	}
	public void setGoodTimes(int goodTimes) {
		this.goodTimes = goodTimes;
	}
	public int getBadTimes() {
		return badTimes;
	}
	public void setBadTimes(int badTimes) {
		this.badTimes = badTimes;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "CommentBean [commentId=" + commentId + ", commentContent="
				+ commentContent + ", articleId=" + articleId + ", userId="
				+ userId + ", createTime=" + createTime + ", goodTimes="
				+ goodTimes + ", badTimes=" + badTimes + ", status=" + status
				+ ", nickName=" + nickName + "]";
	}
	
	

}
