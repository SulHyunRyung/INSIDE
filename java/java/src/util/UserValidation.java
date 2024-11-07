package util; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserValidation {

    // 유저 ID 존재 확인 메서드
    public boolean isUserExists(String userId) {
        String sqlCheck = "SELECT COUNT(*) FROM MEMBER_LIST WHERE USER_ID = ?"; 
        try (Connection conn = DBconn.connectDB(); 
             PreparedStatement pstmt = conn.prepareStatement(sqlCheck)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
}
