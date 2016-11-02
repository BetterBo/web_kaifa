package com.ququ.bean;

import java.util.Date;

/**
 * 文章信息
 * @author bobobo
 *
 */
public class ArticleBean {
	int articleId;
	String title;
	int userId;
	String context;
	int visitTimes;
	Date createTime;
	int status;
	//外加字段
	String nickName;

	public ArticleBean(int articleId, String title, int userId, String context,
			int visitTimes, Date createTime, int status, String nickName) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.userId = userId;
		this.context = context;
		this.visitTimes = visitTimes;
		this.createTime = createTime;
		this.status = status;
		this.nickName = nickName;
	}
	public ArticleBean() {
		super();
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(int visitTimes) {
		this.visitTimes = visitTimes;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		return "ArticleBean [articleId=" + articleId + ", title=" + title
				+ ", userId=" + userId + ", context=" + context
				+ ", visitTimes=" + visitTimes + ", createTime=" + createTime
				+ ", status=" + status + ", nickName=" + nickName + "]";
	}
	
	

	
}
