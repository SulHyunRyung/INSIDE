package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegFrame extends JFrame {
    public RegFrame() {
        // 프레임 기본 설정
        setTitle("회원가입 창");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 회원가입 창 닫기 설정
        setLocationRelativeTo(null);  // 화면 가운데에 창을 배치

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));  // 그리드 레이아웃으로 배치

        // 레이블과 텍스트 필드 추가
        JLabel newUserLabel = new JLabel("새 아이디:");
        JTextField newUserText = new JTextField(20);
        JLabel newPasswordLabel = new JLabel("새 비밀번호:");
        JPasswordField newPasswordText = new JPasswordField(20);
        JButton registerButton = new JButton("가입하기");

        // 가입하기 버튼 이벤트
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUserText.getText();
                String newPassword = new String(newPasswordText.getPassword());

                if (!newUsername.isEmpty() && !newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다!");
                    dispose(); // 회원가입 창 닫기
                } else {
                    JOptionPane.showMessageDialog(null, "모든 필드를 입력해 주세요.");
                }
            }
        });

        // 패널에 컴포넌트 추가
        panel.add(newUserLabel);
        panel.add(newUserText);
        panel.add(newPasswordLabel);
        panel.add(newPasswordText);
        panel.add(new JLabel()); // 빈 공간
        panel.add(registerButton);

        // 프레임에 패널 추가
        add(panel);
        setVisible(true);  // 창 표시
    }
}
