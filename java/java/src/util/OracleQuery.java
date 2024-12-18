package util;

public interface OracleQuery {
	// MEMBER_LIST QUERY
	public static final String MEMBER_TABLE = "MEMBER_LIST";
	public static final String COL_UID = "\"UID\"";
	public static final String COL_USER_NAME = "USER_NAME";
	public static final String COL_USER_ID = "USER_ID";
	public static final String COL_USER_PW = "USER_PW";
	public static final String COL_USER_EMAIL = "USER_EMAIL";
	public static final String COL_REG_DATE = "REG_DATE";
	public static final String COL_INFO_UPDATE_DATE = "INFO_UPDATE_DATE";

	// POST_LIST QUERY
	public static final String POST_TABLE = "POST_LIST";
	public static final String COL_POST_ID = "POST_ID";
	public static final String COL_P_USER_ID = "P_USER_ID";
	public static final String COL_POST_TITLE = "POST_TITLE";
	public static final String COL_CONTENTS = "CONTENTS";
	public static final String COL_CREATE_DATE = "CREATE_DATE";
	public static final String COL_UPDATE_DATE = "UPDATE_DATE";

	// COMMENT_LIST QUERY
	public static final String COMMENT_TABLE = "COMMENT_LIST";
	public static final String COL_COMMENT_ID = "COMMENT_ID";
	public static final String COL_C_POST_ID = "C_POST_ID";
	public static final String COL_C_USER_ID = "C_USER_ID";
	public static final String COL_COMMENT = "\"COMMENT\""; 
	public static final String COL_WRITE_DATE = "WRITE_DATE";

	// FRIEND_LIST QUERY
	public static final String FRIEND_TABLE = "FRIEND_LIST";
	public static final String COL_REQUEST_ID = "REQUEST_ID";
	public static final String COL_REQUESTER_ID = "REQUESTER_ID";
	public static final String COL_RECEIVER_ID = "RECEIVER_ID";
	public static final String COL_STATUS = "STATUS";
	public static final String COL_REQUEST_DATE = "REQUEST_DATE";
}
