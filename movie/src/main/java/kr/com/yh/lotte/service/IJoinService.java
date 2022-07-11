package kr.com.yh.lotte.service;

import kr.com.yh.lotte.vo.MemberVO;

import java.util.Map;



public interface IJoinService {
	
	// 회원가입
	int insertMember(MemberVO vo);
	
	// 중복ID 조회
	boolean checkMember(String id);

	// 중복 연락처 조회
	boolean checkPhone(String phone);

	// 중복Email 조회
	boolean checkEmail(String email);
	
	// 중복 닉네임 조회
	boolean checkNickName(String nickName);
	
	// 아이디 비밀번호 확인
	boolean checkLogin(Map<String, Object> map);

	// 회원 정보 가져오기
	MemberVO getMemberInfo(Map<String, Object> map);
	
	// 회원 삭제
	int deleteMember(String pw);

	// 로그인 아이디 탐색
	String searchLoginId(Map<String, Object> map);


}
