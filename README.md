InSide

- 메신저형 SNS

[1]. 회원 관리

- Field 
* UID (PK)
* ID (NOT NULL, UNIQUE)
* PW (NOT NULL)
* EMAIL (NOT NULL, UNIQUE?)

▶ ID 중복 확인을 위한 유효성 검사 필요.
▶ PW 암호화를 위한 토큰 발급 필요

[1]-2. Log IN/OUT

▶ USER ID / USER PW로 세션 생성 및 종료 방식으로 로그인 구현

[1]-3. 회원 정보 조회 / 수정

▶ 이름, 이메일 비밀번호 수정 기능 구현

[2]. 게시글 관리

- Field
* Post ID (PK)
* User ID (FK)
* Contents [내용] (NOT NULL)
* CreateDate (Time Stamp)
(?) UpdateDate

▶ 게시글 내용 최대 한도제한 +@ [이미지 업로드]

[2]-2. 게시글 조회

▶ 일정 갯수 이상 게시글 페이징 처리로 관리
▶ [ 친구 상태의 사용자의 게시글만 조회 가능 ]
▶ [ 이미지 업로드가 구현 될 경우 Lazy-load 고려 ]

[2]-3. 게시글 수정 및 삭제

▶ 작성자 본인이 게시글 삭제 및 수정이 가능 (UID)
(?) UpadateDate

[3] 댓글 관리

- Field
* CommentID (PK)
* PostID (FK)
* [USER]ID (FK)
* Comment [내용] (NOT NULL)
* WriteDate(Time Stamp)

▶ 댓글 내용 최대 한도 제한

[3]-2. 댓글 조회

▶ 게시글에 업로드된 순서로 조회 가능
▶ n개 이상 페이징?

[3]-3. 댓글 삭제

- 작성자 본인이 댓글 삭제 가능 (수정X)

[4] 친구 관리
 
- Field
* RequestID (PK)
* RequesterID (FK) - 요청자
* ReceiverID (FK) - 수신자
* Status (Default wait)
* RequestDate

▶ Status [accept, rejection, wait]

[4]-2. 친구 요청 수락/거절

▶ 요청 수신자는 수락/거절이 가능
▶ 수락 시 친구 목록 추가 / 거절 시 요청 삭제

[4]-3. 친구 목록 조회

▶ 친구 요청 수락한 인원들을 기준(수락일자 or 가나다순)으로 조회 가능


======================================

비기능 요구사항

1. PW 암호와 토큰 발급 확인
2. 로그인 시 세션 관리 및 타임아웃 설정

기본적인 기능 구현을 우선시하고 시간 및 환경 여건에 따라 가능하다면 [] 항목 구현 예정.

=======================================

24.10.29

웹 구조가 아닌 이상 Session 방식 사용에 난항이 있다고 판단 및 개선 필요성 확인.
ㄴ파일기반 or 메모리기반 세션 저장 방식으로 해결 예정.

Issue 1. UID 생성 중 Sequence 일정 자릿수 및 문자열 포함 생성 관련 에러 발생.
* 해결과정 ) [Issue#1](https://github.com/SulHyunRyung/INSIDE/issues/1)
