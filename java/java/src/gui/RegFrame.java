package gui;

import javax.swing.*;
import model.Member;
import dao.MemberDAOImpl;
import util.UserExists;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField userNameField;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JTextField emailField;

    public RegFrame() {
        setTitle("회원가입");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        userNameField = new JTextField();
        userIdField = new JTextField();
        passwordField = new JPasswordField();
        emailField = new JTextField();

        JButton registerButton = new JButton("회원가입");

        add(new JLabel("이름:"));
        add(userNameField);
        add(new JLabel("아이디:"));
        add(userIdField);
        add(new JLabel("비밀번호:"));
        add(passwordField);
        add(new JLabel("이메일:"));
        add(emailField);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerMember();
            }
        });

        setVisible(true);
    }

    private void registerMember() {
        String userName = userNameField.getText().trim();
        String userId = userIdField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String email = emailField.getText().trim();

        // 빈 필드 체크
        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
            return;
        } else if (userId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
            return;
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
            return;
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
            return;
        }

        // 중복 체크
        UserExists userExists = new UserExists();
        if (userExists.isUserIdExists(userId)) {
            JOptionPane.showMessageDialog(this, "이미 존재하는 아이디입니다.");
            return;
        }

        if (userExists.isUserEmailExists(email)) {
            JOptionPane.showMessageDialog(this, "이미 존재하는 이메일입니다.");
            return;
        }

        Member newMember = new Member();
        newMember.setUserName(userName);
        newMember.setUserId(userId);
        newMember.setUserPw(password);
        newMember.setUserEmail(email);

        MemberDAOImpl memberDAO = new MemberDAOImpl();
        if (memberDAO.insertMember(newMember)) {
            JOptionPane.showMessageDialog(this, "회원가입에 성공했습니다. 다시 로그인해주세요.");
            dispose();
            JOptionPane.showMessageDialog(this, "회원가입 실패. 다시 시도하세요.");
        }
    }
}