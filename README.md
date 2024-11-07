# INSIDE 
* [SRS](https://github.com/SulHyunRyung/INSIDE/blob/main/referance/SRS.txt)


## [ LoginFrame ]

![LoginFrame_1](https://github.com/user-attachments/assets/f2845fca-2d1b-484c-914e-46c21bf067ca)

* 프로그램 실행 시 로그인을 통해 접속 및 이후 진행이 가능하다.
  
![LoginFrameError](https://github.com/user-attachments/assets/06bc96dd-a04a-412f-b3c3-68856a1e255c)

* MEMBER_LIST 테이블의 USER_ID, USER_PW와 일치하지 않을 시 해당 경고 문구 출력.
  
![LoginFrameTryQuit](https://github.com/user-attachments/assets/8b854629-3002-4284-af97-7806cee4338b)

* ID, PW 입력 중 ESC 키를 누르면 종료를 실행, 종료 안내 메세지를 출력.

  

## [ RegFrame ]

![RegFrame](https://github.com/user-attachments/assets/4cddf075-e132-4965-8c0e-8e4b30b6bae3)

* 회원 가입 버튼 클릭시 표시되는 창.
  
![RegFrameIdNullChk](https://github.com/user-attachments/assets/70137168-0115-4471-8bce-64568012d122)

* 이름 -> 아이디 -> 비밀번호 -> 이메일 순서로 빈 필드가 있을 경우 경고 문구를 띄운다.

![RegFrameExistsIdDB](https://github.com/user-attachments/assets/53f65b0d-46cd-4fb3-a2db-fd4fbdc29e07)
![RegFrameExistsId](https://github.com/user-attachments/assets/98919bbb-7529-4f24-a1ae-b90051266f3c)

* 이미지처럼 기존에 있는 ID, Email로 생성 시도 시 경고 문구 출력 및 계정 생성 제한이 걸린다.
* Ex ) 기존에 테스트용 계정으로 생성해둔 ID : hs12 아이디는 유효성 검사를 통해 중복이 확인 될 경우 이미지처럼 경고 문구 출력.

![RegFrameSucsess](https://github.com/user-attachments/assets/8327ef5d-c68f-480d-8d18-bb7b2f7762de)
![RegFrameSucsessDB](https://github.com/user-attachments/assets/91748acd-5d1f-4089-af90-710903cbadb1)

* 정상적으로 회원 가입이 완료 될 경우 입력한 정보로 DB ->
* MEMBER_LIST 테이블에 정보가 들어가고 있는 것을 확인 및 비밀번호 암호화까지 확인.

## [ MainFrame ] - 게시판 화면의 경우 추후 추가 후 수정 예정.

![MainFrame](https://github.com/user-attachments/assets/6fe4fe08-e1f9-4781-8fcb-c3f2d21a695f)
* 로그인 시 처음으로 출력되는 MainFrame 창.
* (USER_NAME)[TesterGit_1]님 안녕하세요. 문구에서 확인할 수 있듯이,
* 로그인 시 해당 유저의 UID, USER_NAME, USER_ID, USER_PW, USER_EMAIL, REG_DATE 정보를 MainFrame에 전달.
* 해당 정보를 통해 추후 MainFrame에서 파생되는 모든 창에서 USER 정보 이용 가능.

![MainFrameLogOut](https://github.com/user-attachments/assets/ec221628-cc09-4031-b12c-82bfb83482ec)
* 로그아웃 버튼을 누를 시 해당 확인 문구 출력 후, 확인 선택 시 프로그램이 종료된다.
* 해당 MainFrame뿐만 아니라 다른 모든 프레임이 종료됨.

![MainFrameUserInfoUpdate](https://github.com/user-attachments/assets/bef0d579-fc1a-4732-ad7f-dc75bb5115a6)
* 회원 정보 수정 버튼을 누를 경우, 정보 수정 창으로 이동 전 사용자의 ID와 PW를 확인하는 창 출력.

![MainFrameUserInfoUpdateChkFail](https://github.com/user-attachments/assets/2bad021c-1b7c-4b20-ac56-d4c5433f4ac3)
* 해당 창에서도 ID, PW의 인증에 실패하면 경고 문구가 출력되도록 설정.

![MainFrameUserInfoUpdateChkSucsess](https://github.com/user-attachments/assets/d209d790-a33d-4f19-8839-dfa9d477d780)
* ID, PW 인증 성공 시 성공 알림 출력 후 회원 정보 수정 창으로 이동함.

## [ UserInfoUpdate ]

![UserInfoUpdateFrame](https://github.com/user-attachments/assets/bc5b7c14-e479-4a55-9def-6295b1a5c6d3)
* 회원 정보 수정 기본 화면
* USER_NAME, USER_ID는 고유값으로 setEditable(false) 설정

![UserInfoUpdateFramePwExists](https://github.com/user-attachments/assets/61fbc203-8cb5-4117-a6d4-4134d1f95753)
* 변경할 새 비밀번호와 새 비밀번호 확인란의 다른 문자가 입력되면 경고 문구 출력.

![UserInfoUpdateFramePwNull](https://github.com/user-attachments/assets/ef180442-716b-4662-886a-922ae309ba17)
* 새 비밀번호 칸을 공란으로 설정 시 변경되지 않고, 기존 비밀번호 유지 가능.

![AlreadyExistsEmailList](https://github.com/user-attachments/assets/024f2225-8b4b-4b53-9a88-8dcfd1f95696)
![AlreadyExistsEmail](https://github.com/user-attachments/assets/1052350b-fbe8-4d39-bbd5-05a9696123a7)
* 이메일의 경우 가입할 당시 고유값 (중복 금지)로 받았기 때문에, 해당 수정 창에서도 중복 체크를 실행.
* 해당 테스트 환경에선 이미지처럼 hs12 값으로 시도하였으나, 중복 유효성 검사에서 걸러짐.

![UserInfoUpdateFramePwUpdate](https://github.com/user-attachments/assets/022437ac-4f2f-4817-80aa-b3c50e25c89d)
![RegFrameSucsessDB](https://github.com/user-attachments/assets/91748acd-5d1f-4089-af90-710903cbadb1) - 회원가입
![UserInfoUpdateFramePwUpdateDB](https://github.com/user-attachments/assets/5b08c212-c928-437a-95a5-2320c1e4fba3) - 회원정보수정

* 해당 예외 사항들을 준수하여 작성하면 PW, Email 수정이 가능함.
* 가입 당시의 Hash화 된 비밀번호와 비교하여 새로운 비밀번호로 변경됨이 확인 가능함.
* 해당 테스트 환경에선 원활한 테스트를 위해 t123으로 다시 설정.
  





=======================================

# 24.10.29

웹 구조가 아닌 이상 Session 방식 사용에 난항이 있다고 판단 및 개선 필요성 확인.
* 파일기반 or 메모리기반 세션 저장 방식으로 해결 예정.

## Issue 1. UID 생성 중 Sequence 일정 자릿수 및 문자열 포함 생성 관련 에러 발생.
* 해결과정 ) [Issue#1](https://github.com/SulHyunRyung/INSIDE/issues/1)

## Issue 2. POST_LIST - POST_ID Forign Key 참조 관련 이슈 발생.
* 해결과정 ) [Issue#2](https://github.com/SulHyunRyung/INSIDE/issues/2)

## Daily Report
* 프로젝트 Git Setting
* Logo 제작
* SRS 구성 및 세부사항 조정
* 각 기능 테이블 구성

# 24.10.30

## Daily Report
* 전체 구조 형성 및 UI 스케치
* 모델 패키지 생성 및 세부사항 조정
* 필요 소스 및 쿼리 확보, 레퍼런스 서치

![Sketch](https://github.com/user-attachments/assets/d0ea8ddf-5b9d-4740-bb20-af45e9c5d05b)

/referance/img/sketch.png
 
![Structure_Model](https://github.com/user-attachments/assets/fb0cd06d-b049-4256-8061-aa428a7d7dcb)

/referance/img/Structure_Model.png

# 24. 10. 31

## Daily Report
* 기능 구현을 위한 DAO 및 DAOImpl 의 메서드 작성
* 사용되는 테이블의 유효성 체크 후 구조 변경

## Issue 3. 기능 메서드의 트랜잭션 처리 해결과정 
[Issue#3](https://github.com/SulHyunRyung/INSIDE/issues/3)

# 24. 11. 01

## Daily Report
* Login & Register Frame 제작 및 기능 구현(연동)

# 24. 11. 02

## Daily Report
* UserInfoUpdate(회원 정보 수정) 창 GUI 구현 및 기능 구현

# 24. 11. 04

## Daily Report
* BoardFrame(게시판) GUI 구현
* 회원 가입, 회원 정보 수정 본인 인증, 회원 정보 수정 란에서 비밀번호 생성 및 수정에서 비밀번호 Hash화 하여 암호화 진행.
* 회원 가입, 회원 정보 수정 관련 예외 사항 처리

## Issue 4. 비밀번호 보안 / Hashing
[Issue#4](https://github.com/SulHyunRyung/INSIDE/issues/4)

## Issue 5. Password Hashing 중 데이터 삽입 오류
[Issue#5](https://github.com/SulHyunRyung/INSIDE/issues/5)

## Issue 6. BoardFrame 구성 중 한글 폰트 깨짐 현상
[Issue#5](https://github.com/SulHyunRyung/INSIDE/issues/6)
