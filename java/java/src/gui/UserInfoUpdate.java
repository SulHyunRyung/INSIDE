package gui;

import model.Member;
import dao.MemberDAOImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoUpdate extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField idField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JTextField emailField;

    public UserInfoUpdate(JFrame parent, Member member) {
        super(parent, "회원 정보 수정", true);
        setSize(350, 300);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(parent);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // 이름
        JLabel nameLabel = new JLabel("이름:");
        nameField = new JTextField(member.getUserName(), 15);
        nameField.setEditable(false);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        // ID (수정 불가)
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(member.getUserId(), 15);
        idField.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(idLabel, gbc);

        gbc.gridx = 1;
        add(idField, gbc);

        // 새 비밀번호
        JLabel newPasswordLabel = new JLabel("새 비밀번호:");
        newPasswordField = new JPasswordField(15);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(newPasswordLabel, gbc);

        gbc.gridx = 1;
        add(newPasswordField, gbc);

        // 새 비밀번호 확인
        JLabel confirmPasswordLabel = new JLabel("새 비밀번호 확인:");
        confirmPasswordField = new JPasswordField(15);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(confirmPasswordLabel, gbc);

        gbc.gridx = 1;
        add(confirmPasswordField, gbc);

        // EMAIL
        JLabel emailLabel = new JLabel("EMAIL:");
        emailField = new JTextField(member.getUserEmail(), 15);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(emailLabel, gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        JButton updateButton = new JButton("회원 정보 수정");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // 변경되는 비밀번호 유효성 체크
                if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(UserInfoUpdate.this, "비밀번호가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                member.setUserName(nameField.getText());
                member.setUserPw(newPassword); 
                member.setUserEmail(emailField.getText());

                MemberDAOImpl memberDAO = new MemberDAOImpl();
                boolean isUpdated = memberDAO.updateMember(member);

                if (isUpdated) {
                    JOptionPane.showMessageDialog(UserInfoUpdate.this, "회원 정보가 성공적으로 수정되었습니다.", "확인", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(UserInfoUpdate.this, "회원 정보 수정에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(updateButton, gbc);
    }
}
