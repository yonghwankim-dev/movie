package kr.com.yh.lotte.dao;

import kr.com.yh.lotte.vo.MemberVO;

import java.util.Map;



public interface IJoinDao {

	// 회원가입
	int insertMember(MemberVO vo);
	
	// 중복ID 조회
	boolean checkMember(String id);

	// 중복 연락처 조회
	boolean checkPhone(String phone);
	
	// 중복 Email 조회
	boolean checkEmail(String email);
	
	// 중복 닉네임 조회
	boolean checkNickName(String nickName);
	
	// 아이디 비밀번호 확인
	boolean checkLogin(Map<String, Object> map);
		
	// 회원탈퇴
	int deleteMember(String pw);
	
	// 로그인된 아이디 검색
	String searchLoginId(Map<String, Object> map);

	// 회원정보 가져오기
	MemberVO getMemberInfo(Map<String, Object> map);

	

	
}
