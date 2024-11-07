package gui;

import model.Member;

import javax.swing.*;
import java.awt.*;

public class FriendFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private Member member;  // Member 객체를 저장할 변수

    public FriendFrame(Member member) {
        this.member = member;  // MainFrame에서 전달받은 Member 객체 저장
        
        setTitle("친구 목록");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // 메인 패널 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 친구 목록을 보여줄 테이블
        String[] columnNames = {"친구 이름", "친구 아이디"};
        Object[][] data = {
            {"홍길동", "hong123"},
            {"김철수", "kim123"},
            {"이영희", "lee123"}
        }; // 예시 데이터, 실제로는 DB에서 데이터를 받아와야 함
        
        JTable friendTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(friendTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // 친구 추가 버튼
        JButton addFriendButton = new JButton("친구 추가");
        buttonPanel.add(addFriendButton);

        // 친구 삭제 버튼
        JButton removeFriendButton = new JButton("친구 삭제");
        buttonPanel.add(removeFriendButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 패널을 프레임에 추가
        add(mainPanel);
        setVisible(true);

        // 여기서 member를 사용하여 필요한 정보를 출력하거나 처리할 수 있음
        System.out.println("현재 로그인한 사용자: " + member.getUserName());
    }
}
