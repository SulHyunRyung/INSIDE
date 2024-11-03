package gui;

import model.Member;
import util.DBconn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public LoginFrame() {
        setTitle("로그인 창");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); 

        JLabel userLabel = new JLabel("아이디:");
        JTextField userText = new JTextField(20);
        JLabel passwordLabel = new JLabel("비밀번호:");
        JPasswordField passwordText = new JPasswordField(20);

        JButton loginButton = new JButton("로그인");
        JButton signupButton = new JButton("회원가입");

        Action loginAction = new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                Member member = getMember(username, password);

                if (member != null) {
                    new MainFrame(member); // 회원 정보를 MainFrame에 전달
                    dispose(); // 로그인 창 닫기
                } else {
                    JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 확인해주세요.");
                }
            }
        };

        userText.addActionListener(loginAction);
        passwordText.addActionListener(loginAction);
        loginButton.addActionListener(loginAction);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegFrame();
            }
        });

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(signupButton);

        add(panel);
        setVisible(true); 
    }

    private Member getMember(String username, String password) {
        String sql = "SELECT * FROM MEMBER_LIST WHERE USER_ID = ? AND USER_PW = ?";
        
        try (Connection conn = DBconn.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // 회원 정보를 Member 객체로 생성
                    return new Member(
                        rs.getString("UID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_ID"),
                        rs.getString("USER_PW"),
                        rs.getString("USER_EMAIL"),
                        rs.getDate("REG_DATE")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // 로그인 실패 시 null 반환
    }
}
