package dao;

import model.Member;


public interface MemberDAO {
	// 회원 가입
	boolean insertMember(Member member);
	
	// 회원 정보 수정
	boolean updateMember(Member member);
	
	// 회원 탈퇴
	boolean deleteMember(String userId);

	//중복 ID & Email 체크
	boolean isUserIdExists(String userId);

	boolean isUserEmailExists(String userEmail);
}
