package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Member;
import util.DBconn;
import util.OracleQuery;

public class MemberDAOImpl implements MemberDAO {
	
	// .setAutoCommit(false) 자동 커밋 실행 중지
	// .rollback 실행한 기능을 전으로 되돌림 // 커밋 이전 실행 가능
	// 해당 메서드를 활용하여 기능 처리에 순서를 두어 트랜잭션 처리 가능
	
	@Override
	public boolean insertMember(Member member) {
	    String sqlInsert = "INSERT INTO " + 
	            OracleQuery.MEMBER_TABLE + " (" + 
	            OracleQuery.COL_UID + ", " +
	            OracleQuery.COL_USER_NAME + ", " +
	            OracleQuery.COL_USER_ID + ", " +
	            OracleQuery.COL_USER_PW + ", " +
	            OracleQuery.COL_USER_EMAIL + ", " + 
	            OracleQuery.COL_REG_DATE + 
	            ") VALUES (CONCAT('U', LPAD(MEMBER_SEQ.NEXTVAL, 6, '0')), ?, ?, ?, ?, SYSDATE)";

		try (Connection conn = DBconn.connectDB()) {
            conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
				pstmt.setString(1, member.getUserName());
				pstmt.setString(2, member.getUserId());
				pstmt.setString(3, member.getUserPw());
				pstmt.setString(4, member.getUserEmail());
				int pstmtResult = pstmt.executeUpdate();
                conn.commit();
				return pstmtResult > 0;
			} catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} // End insertMember

    @Override
    public boolean updateMember(Member member) { 
        String sqlUpdate = "UPDATE " +
                OracleQuery.MEMBER_TABLE + " SET " +
                OracleQuery.COL_USER_NAME + " = ?, " +
                OracleQuery.COL_USER_PW + " = ?, " +
                OracleQuery.COL_USER_EMAIL + " = ?, " +
                OracleQuery.COL_INFO_UPDATE_DATE + " = SYSDATE WHERE " +
                OracleQuery.COL_UID + " = ?";
       
        try (Connection conn = DBconn.connectDB()) {
            conn.setAutoCommit(false);
            try (PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
                pstmt.setString(1, member.getUserName());
                pstmt.setString(2, member.getUserPw());
                pstmt.setString(3, member.getUserEmail());
                pstmt.setString(4, member.getUid());
                int pstmtResult = pstmt.executeUpdate();
                conn.commit();
                return pstmtResult > 0; 
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } // End updateMember
    
    @Override
    public boolean deleteMember(String uid) {
        String sqlDelete = "DELETE FROM " + 
        		OracleQuery.MEMBER_TABLE + " WHERE " + 
        		OracleQuery.COL_UID + " = ?";

        try (Connection conn = DBconn.connectDB()) {
            conn.setAutoCommit(false);
            try (PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
                pstmt.setString(1, uid);
                int pstmtResult = pstmt.executeUpdate();
                conn.commit();
                return pstmtResult > 0; 
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } // End deleteMember
}
