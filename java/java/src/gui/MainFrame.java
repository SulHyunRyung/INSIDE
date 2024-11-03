package gui;

import model.Member; // Member 클래스 임포트 추가
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public MainFrame(Member member) { // Member 객체를 매개변수로 받음
        setTitle("Main Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // 메인 패널 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10)); 
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 상단 패널 (로고 및 사용자 이름)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        // 로고 이미지 추가 (상대 경로 사용)
        ImageIcon logoIcon = new ImageIcon("../../img/logo.png"); 
        Image img = logoIcon.getImage();
        Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(newImg));
        
        topPanel.add(logoLabel, BorderLayout.WEST);

        // 사용자 이름과 로그아웃 버튼을 오른쪽에 배치
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel greetingLabel = new JLabel(member.getUserName() + "님 안녕하세요."); // USER_NAME 사용
        JButton logoutButton = new JButton("로그아웃");

        // 로그아웃 버튼 클릭 시 동작
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 로그아웃 메시지 출력
                JOptionPane.showMessageDialog(null, "안녕히 가세요.\n" + member.getUserName() + "님.", "로그아웃", JOptionPane.INFORMATION_MESSAGE);
                
                // 창 닫기
                dispose();
                // 필요 시 로그인 화면 다시 열기
                // new LoginFrame();
            }
        });
        
        userPanel.add(greetingLabel);
        userPanel.add(logoutButton);
        
        topPanel.add(userPanel, BorderLayout.CENTER);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // 게시판과 버튼을 나란히 배치할 패널
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // 게시판 패널
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(0, 1));
        // 기존의 테두리 설정을 제거하고 빈 테두리로 설정
        boardPanel.setBorder(BorderFactory.createEmptyBorder()); 

        // 최근 5개 게시물 추가 (예시)
        for (int i = 1; i <= 5; i++) {
            boardPanel.add(new JLabel("게시물 " + i));
        }

        // 스크롤 기능 추가
        JScrollPane scrollPane = new JScrollPane(boardPanel);
        scrollPane.setPreferredSize(new Dimension(400, 200)); 

        // 게시판과 버튼 배치
        gbc.gridx = 0; // 첫 번째 열
        gbc.gridy = 0; // 첫 번째 행
        centerPanel.add(scrollPane, gbc);

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        // 버튼 생성
        JButton editInfoButton = new JButton("회원 정보 수정");
        JButton friendListButton = new JButton("친구 목록");
        JButton boardMoveButton = new JButton("게시판으로 이동");
        
        // 버튼 크기 설정
        Dimension buttonSize = new Dimension(180, 40);
        editInfoButton.setPreferredSize(buttonSize);
        friendListButton.setPreferredSize(buttonSize);
        boardMoveButton.setPreferredSize(buttonSize);

        // 버튼 사이에 공백 추가 및 배치
        GridBagConstraints btnGbc = new GridBagConstraints();
        btnGbc.gridx = 0;
        btnGbc.gridy = 0;
        btnGbc.insets = new Insets(10, 15, 25, 0);
        buttonPanel.add(editInfoButton, btnGbc); // 회원 정보 수정 버튼 
        
        btnGbc.gridy = 1;
        buttonPanel.add(friendListButton, btnGbc); // 친구 목록 버튼 
        
        btnGbc.gridy = 2;
        buttonPanel.add(boardMoveButton, btnGbc); // 게시판으로 이동 버튼

        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(buttonPanel, gbc); // 버튼 패널 추가

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // 메인 패널을 JFrame에 추가
        add(mainPanel);
        pack(); 
        setVisible(true);
    }

}
