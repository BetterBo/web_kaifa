package com.ququ.bean;

import java.util.Date;
/**
 * ¡Ù—‘∞Â
 * @author bobobo
 *
 */
public class messageBean {
	int messageId;
	String messageContent;
	int commenterId;
	int commenteredId;
	Date createTime;
	//Õ‚º”◊÷∂Œ
	String commenter_nickName;
	String commenter_headImage;
	public messageBean(int messageId, String messageContent, int commenterId,
			int commenteredId, Date createTime, String commenter_nickName,
			String commenter_headImage) {
		super();
		this.messageId = messageId;
		this.messageContent = messageContent;
		this.commenterId = commenterId;
		this.commenteredId = commenteredId;
		this.createTime = createTime;
		this.commenter_nickName = commenter_nickName;
		this.commenter_headImage = commenter_headImage;
	}
	public messageBean() {
		super();
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public int getCommenterId() {
		return commenterId;
	}
	public void setCommenterId(int commenterId) {
		this.commenterId = commenterId;
	}
	public int getCommenteredId() {
		return commenteredId;
	}
	public void setCommenteredId(int commenteredId) {
		this.commenteredId = commenteredId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCommenter_nickName() {
		return commenter_nickName;
	}
	public void setCommenter_nickName(String commenter_nickName) {
		this.commenter_nickName = commenter_nickName;
	}
	public String getCommenter_headImage() {
		return commenter_headImage;
	}
	public void setCommenter_headImage(String commenter_headImage) {
		this.commenter_headImage = commenter_headImage;
	}
	@Override
	public String toString() {
		return "messageBean [messageId=" + messageId + ", messageContent="
				+ messageContent + ", commenterId=" + commenterId
				+ ", commenteredId=" + commenteredId + ", createTime="
				+ createTime + ", commenter_nickName=" + commenter_nickName
				+ ", commenter_headImage=" + commenter_headImage + "]";
	}
	
	
}
