package dao;

import model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBconn;
import util.OracleQuery;

public class PostDAOImpl implements PostDAO {
	
	@Override
	public boolean createPost(Post post) {
	    String sqlInsert = "INSERT INTO " + OracleQuery.POST_TABLE + " (" +
	             OracleQuery.COL_POST_ID + ", " +
	             OracleQuery.COL_P_USER_ID + ", " +
	             OracleQuery.COL_POST_TITLE + ", " +
	             OracleQuery.COL_CONTENTS + ", " +
	             OracleQuery.COL_CREATE_DATE + ") " +
	             "VALUES (LPAD(POST_SEQ.NEXTVAL, 6, '0'), ?, ?, ?, SYSDATE)";

	    try (Connection conn = DBconn.connectDB(); 
	        PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
	        conn.setAutoCommit(false);
	        pstmt.setString(1, post.getpUserId());
	        pstmt.setString(2, post.getPostTitle());
	        pstmt.setString(3, post.getContents());

	        int pstmtResult = pstmt.executeUpdate();
	        if (pstmtResult > 0) {
	            conn.commit();
	            return true;
	        } else {
	            conn.rollback();
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@Override
	public boolean updatePost(Post post) {
	    String sqlUpdate = "UPDATE " + OracleQuery.POST_TABLE + " SET " +
	            OracleQuery.COL_POST_TITLE + " = ?, " +
	            OracleQuery.COL_CONTENTS + " = ?, " +
	            OracleQuery.COL_UPDATE_DATE + " = SYSDATE " +
	            "WHERE " + OracleQuery.COL_POST_ID + " = ?";

	    try (Connection conn = DBconn.connectDB(); 
	         PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
	        conn.setAutoCommit(false);
	        
	        pstmt.setString(1, post.getPostTitle());
	        pstmt.setString(2, post.getContents());
	        pstmt.setString(3, post.getPostId());

	        int pstmtResult = pstmt.executeUpdate();
	        if (pstmtResult > 0) {
	            conn.commit();
	            return true;
	        } else {
	            conn.rollback();
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean deletePost(String postId) {
	    String sqlDelete = "DELETE FROM " + OracleQuery.POST_TABLE + 
	            " WHERE " + OracleQuery.COL_POST_ID + " = ?";

	    try (Connection conn = DBconn.connectDB(); 
	         PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
	        conn.setAutoCommit(false);
	        pstmt.setString(1, postId);

	        int pstmtResult = pstmt.executeUpdate();
	        if (pstmtResult > 0) {
	            conn.commit();
	            return true;
	        } else {
	            conn.rollback();
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@Override
	public Post getPost(String postId) {
	    Post post = null;
	    String sqlSelect = "SELECT * FROM " + OracleQuery.POST_TABLE + 
	            " WHERE " + OracleQuery.COL_POST_ID + " = ?";

	    try (Connection conn = DBconn.connectDB(); 
	         PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
	        conn.setAutoCommit(false); // 자동 커밋 비활성화
	        pstmt.setString(1, postId);

	        try (ResultSet resultSet = pstmt.executeQuery()) {
	            if (resultSet.next()) {
	                post = new Post();
	                post.setPostId(resultSet.getString(OracleQuery.COL_POST_ID));
	                post.setPostTitle(resultSet.getString(OracleQuery.COL_POST_TITLE));
	                post.setContents(resultSet.getString(OracleQuery.COL_CONTENTS));
	                post.setpUserId(resultSet.getString(OracleQuery.COL_USER_ID));
	                post.setCreateDate(resultSet.getTimestamp(OracleQuery.COL_WRITE_DATE));
	            }
	        }
	        conn.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return post;
	}

	@Override
	public List<Post> getAllPosts(int pageNumber, int pageSize) {
	    List<Post> posts = new ArrayList<>();
	    String sqlSelect = "SELECT * FROM ( " +
	                       "SELECT ROWNUM AS rn, p.* FROM ( " +
	                       "SELECT * FROM " + OracleQuery.POST_TABLE + " ORDER BY " + OracleQuery.COL_CREATE_DATE + " DESC " +
	                       ") p " +
	                       ") WHERE rn BETWEEN ? AND ?";

	    int startRow = (pageNumber - 1) * pageSize + 1;
	    int endRow = pageNumber * pageSize;

	    try (Connection conn = DBconn.connectDB();
	         PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
	        conn.setAutoCommit(false);

	        pstmt.setInt(1, startRow);
	        pstmt.setInt(2, endRow);

	        ResultSet resultSet = pstmt.executeQuery();
	        while (resultSet.next()) {
	            Post post = new Post();
	            post.setPostId(resultSet.getString(OracleQuery.COL_POST_ID));
	            post.setPostTitle(resultSet.getString(OracleQuery.COL_POST_TITLE));
	            post.setContents(resultSet.getString(OracleQuery.COL_CONTENTS));
	            post.setpUserId(resultSet.getString(OracleQuery.COL_P_USER_ID));
	            post.setCreateDate(resultSet.getTimestamp(OracleQuery.COL_CREATE_DATE));
	            post.setUpdateDate(resultSet.getTimestamp(OracleQuery.COL_UPDATE_DATE));
	            posts.add(post);
	        }	
	        resultSet.close();
	        conn.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return posts;
	}
}


