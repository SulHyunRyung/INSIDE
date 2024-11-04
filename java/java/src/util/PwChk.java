package util;

import org.mindrot.jbcrypt.BCrypt;

public class PwChk {

    // PW:PW(Hash) 비교
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}