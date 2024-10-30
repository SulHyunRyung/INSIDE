package model;

import java.util.Date;

public class Post {
	private int postId;
	private String pUserId;
	private int postTitle;
	private int contents;
	private Date createDate;
	
	public Post() {}

	public Post(int postId, String pUserId, int postTitle, int contents, Date createDate) {
		super();
		this.postId = postId;
		this.pUserId = pUserId;
		this.postTitle = postTitle;
		this.contents = contents;
		this.createDate = createDate;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getpUserId() {
		return pUserId;
	}

	public void setpUserId(String pUserId) {
		this.pUserId = pUserId;
	}

	public int getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(int postTitle) {
		this.postTitle = postTitle;
	}

	public int getContents() {
		return contents;
	}

	public void setContents(int contents) {
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
