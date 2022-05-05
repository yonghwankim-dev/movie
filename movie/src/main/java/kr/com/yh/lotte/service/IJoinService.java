package kr.com.yh.lotte.service;

import java.util.Map;

import kr.com.yh.lotte.vo.MemberVO;



public interface IJoinService {
	
	// 회원가입
	public int insertMember(MemberVO vo);
	
	// 중복ID 조회
	public boolean checkMember(String id);

	// 중복Email 조회
	public boolean checkEmail(String email);
	
	// 중복 닉네임 조회
	public boolean checkNickName(String nickName);
	
	// 아이디 비밀번호 확인
	public boolean checkLogin(Map<String, Object> map);
	
	// 이름 가져오기
	public String getName(Map<String, Object> map);
	
	// 회원코드 조회
	public String getMemCd(String id);
	
	// 회원 삭제
	public int deleteMember(String pw);

	// 로그인 아이디 탐색
	public String searchLoginId(Map<String, Object> map);
}
