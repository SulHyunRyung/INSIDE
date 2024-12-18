package util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LogoutEvent implements ActionListener {
    private static List<JFrame> activeFrames = new ArrayList<>(); 
    private JFrame currentFrame; // 현재 프레임
    private String userName;

    public LogoutEvent(JFrame currentFrame, String userName) {
        this.currentFrame = currentFrame;
        this.userName = userName;
        registerFrame(currentFrame); // 현재 프레임 등록
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int response = JOptionPane.showConfirmDialog(currentFrame, "로그아웃 하시겠습니까?", "로그아웃 확인", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "안녕히 가세요.\n" + userName + "님.", "로그아웃", JOptionPane.INFORMATION_MESSAGE);
            for (JFrame frame : activeFrames) { 
                frame.dispose(); // 모든 활성 프레임 종료
            }
            activeFrames.clear(); // 프레임 목록 초기화
        }
    }

    public static void registerFrame(JFrame frame) {
        activeFrames.add(frame); // 프레임 등록
    }

    public static void unregisterFrame(JFrame frame) {
        activeFrames.remove(frame); // 프레임 등록 해제
    }
}
