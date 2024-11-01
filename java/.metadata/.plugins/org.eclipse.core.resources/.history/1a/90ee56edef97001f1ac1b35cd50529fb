package dao;

import model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import util.DBconn;
import util.OracleQuery;

public class PostDAOImple implements PostDAO {
	
	@Override
	public boolean createPost(Post post) {
		String sqlInsert = "INSERT INTO " + OracleQuery.POST_TABLE + " (" +
	             OracleQuery.COL_POST_ID + ", " +
	             OracleQuery.COL_P_USER_ID + ", " +
	             OracleQuery.COL_POST_TITLE + ", " +
	             OracleQuery.COL_CONTENTS + ", " +
	             OracleQuery.COL_CREATE_DATE + ") " +
	             "VALUES (LPAD(POST_SEQ.NEXTVAL, 6, '0'), ?, ?, ?, SYSDATE)";

	    try (Connection conn = DBconn.connectDB()) {
	        conn.setAutoCommit(false);

	        try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
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
	            conn.rollback();
	            e.printStackTrace();
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

	    try (Connection conn = DBconn.connectDB()) {
	        conn.setAutoCommit(false);

	        try (PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
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
	            conn.rollback();
	            e.printStackTrace();
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

	    try (Connection conn = DBconn.connectDB()) {
	        conn.setAutoCommit(false);

	        try (PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
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
	            conn.rollback();
	            e.printStackTrace();
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public Post getPost(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPosts(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
