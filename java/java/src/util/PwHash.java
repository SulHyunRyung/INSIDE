package util;

import org.mindrot.jbcrypt.BCrypt; 

public class PwHash {
    // 비밀번호 해시화
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // 비밀번호 검증
    public static boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
