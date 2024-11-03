package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        // 프레임 기본 설정
        setTitle("로그인 창");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // 화면 가운데에 창을 배치

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));  // 그리드 레이아웃으로 배치

        // 레이블과 텍스트 필드 추가
        JLabel userLabel = new JLabel("아이디:");
        JTextField userText = new JTextField(20);
        JLabel passwordLabel = new JLabel("비밀번호:");
        JPasswordField passwordText = new JPasswordField(20);

        // 로그인, 회원가입 버튼 추가
        JButton loginButton = new JButton("로그인");
        JButton signupButton = new JButton("회원가입");

        // 로그인 버튼 클릭 시 실행될 액션
        Action loginAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if ("admin".equals(username) && "1234".equals(password)) {
                    JOptionPane.showMessageDialog(null, "로그인 성공!");
                } else {
                    JOptionPane.showMessageDialog(null, "로그인 실패. 다시 시도하세요.");
                }
            }
        };

        // 엔터 키로 로그인 버튼 클릭 기능 추가
        userText.addActionListener(loginAction);
        passwordText.addActionListener(loginAction);
        loginButton.addActionListener(loginAction);  // 버튼 클릭 시 같은 액션 실행

        // 회원가입 버튼 클릭 시 회원가입 창 열기
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegFrame(); // 회원가입 창 열기
            }
        });

        // 패널에 컴포넌트 추가
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(signupButton);

        // 프레임에 패널 추가
        add(panel);
        setVisible(true);  // 창 표시
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
