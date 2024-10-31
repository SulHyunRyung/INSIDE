package model;

import java.util.Date;

public class Post {
	private String postId;
	private String pUserId;
	private String postTitle;
	private String contents;
	private Date createDate;
	
	public Post() {}

	public Post(String postId, String pUserId, String postTitle, String contents, Date createDate) {
		super();
		this.postId = postId;
		this.pUserId = pUserId;
		this.postTitle = postTitle;
		this.contents = contents;
		this.createDate = createDate;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getpUserId() {
		return pUserId;
	}

	public void setpUserId(String pUserId) {
		this.pUserId = pUserId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", pUserId=" + pUserId + ", postTitle=" + postTitle + ", contents=" + contents
				+ ", createDate=" + createDate + "]";
	}

}
