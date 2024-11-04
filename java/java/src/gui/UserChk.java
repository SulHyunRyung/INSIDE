package gui;

import model.Member;
import util.PwChk; // 해시 관련 유틸리티를 사용하기 위해 import 추가
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserChk extends JDialog {
    private static final long serialVersionUID = 1L;

    public UserChk(JFrame parent, Member member) {
        super(parent, "본인 확인", true);
        setSize(300, 200);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(parent);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel messageLabel = new JLabel("회원 정보 확인을 위해 ID와 PW를 입력해주세요.");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(idLabel, gbc);

        gbc.gridx = 1;
        add(idField, gbc);

        JLabel pwLabel = new JLabel("PW:");
        JPasswordField pwField = new JPasswordField(15);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(pwLabel, gbc);

        gbc.gridx = 1;
        add(pwField, gbc);

        JButton confirmButton = new JButton("확인");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredId = idField.getText();
                String enteredPw = new String(pwField.getPassword());

                // 입력된 ID가 회원 정보와 일치하는지 확인
                if (enteredId.equals(member.getUserId())) {
                    // 비밀번호 해시 체크
                    if (PwChk.checkPassword(enteredPw, member.getUserPw())) {
                        JOptionPane.showMessageDialog(UserChk.this, "확인되었습니다.", "본인 확인", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new UserInfoUpdate(parent, member).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(UserChk.this, "ID 또는 PW가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(UserChk.this, "ID 또는 PW가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(confirmButton, gbc);
    }
}
