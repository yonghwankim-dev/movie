package kr.com.yh.lotte.vo;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 영화 웹 사이트에 로그인한 회원의 정보를 다음 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {
	private String mem_code;	// 회원코드
	private String name;		// 회원이름
	private Date   birthday;	// 회원생년월일
	private String contact;		// 회원핸드폰번호
	private String addr;		// 회원주소
	private String email;		// 회원이메일
	private String id;			// 회원아이디
	private String pwd;			// 회원비밀번호
	private String gender;		// 회원성별	
}
