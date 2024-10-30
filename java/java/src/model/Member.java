package model;

import java.util.Date;

public class Member {
	private String uid;
	private String userName;
	private String userId;
	private String userPw;
	private String userEmail;
	private Date regDate;

	public Member() {
	}

	public Member(String uid, String userName, String userId, String userPw, String userEmail, Date regDate) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.regDate = regDate;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [uid=" + uid + ", userName=" + userName + ", userId=" + userId + ", userPw=" + userPw
				+ ", userEmail=" + userEmail + ", regDate=" + regDate + "]";
	}

}
