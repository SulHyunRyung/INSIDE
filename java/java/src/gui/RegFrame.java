package gui;

import javax.swing.*;
import model.Member;
import dao.MemberDAOImpl; // MemberDAO의 구현체 임포트
import util.UserExists; // UserExists 임포트
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
        String userName = userNameField.getText();
        String userId = userIdField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        // 중복 체크
        UserExists userExists = new UserExists(); // UserExists 인스턴스 생성
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
            JOptionPane.showMessageDialog(this, "회원가입 성공!");
            dispose(); // 회원가입 성공 시 창 닫기
        } else {
            JOptionPane.showMessageDialog(this, "회원가입 실패. 다시 시도하세요.");
        }
    }
}
