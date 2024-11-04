package util;

import org.mindrot.jbcrypt.BCrypt;

public class PwChk {

    // 비밀번호와 해시된 비밀번호 비교
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}