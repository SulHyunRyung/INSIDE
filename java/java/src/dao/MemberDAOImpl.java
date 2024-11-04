package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Member;
import util.DBconn;
import util.OracleQuery;
import util.PwHash;

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
                pstmt.setString(3, PwHash.hashPassword(member.getUserPw()));
                pstmt.setString(4, member.getUserEmail());
                int pstmtResult = pstmt.executeUpdate();
                conn.commit();
                return pstmtResult > 0;
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("SQL 오류: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            System.err.println("DB 연결 오류: " + e.getMessage());
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

                // 비밀번호 해시화
                String hashedPassword = PwHash.hashPassword(member.getUserPw());
                pstmt.setString(2, hashedPassword); // 해시된 비밀번호 설정

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
    
    
    @Override
    public boolean isUserIdExists(String userId) {
        String sql = "SELECT COUNT(*) FROM MEMBER_LIST WHERE USER_ID = ?";
        try (Connection conn = DBconn.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    } // End isUserIdExists

    @Override
    public boolean isUserEmailExists(String userEmail) {
        String sql = "SELECT COUNT(*) FROM MEMBER_LIST WHERE USER_EMAIL = ?";
        try (Connection conn = DBconn.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, userEmail);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    } // End isUserEmailExists
}

