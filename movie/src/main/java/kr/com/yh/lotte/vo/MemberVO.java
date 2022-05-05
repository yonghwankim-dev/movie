package kr.com.yh.lotte.vo;


import java.sql.Date;

/**
 * Class Description
 * 영화 웹 사이트에 로그인한 회원의 정보를 다음 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
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
	
	public MemberVO() {
		
	}

	public MemberVO(String mem_code, String name, Date birthday, String contact, String addr, String email, String id,
			String pwd, String gender) {
		this.mem_code = mem_code;
		this.name = name;
		this.birthday = birthday;
		this.contact = contact;
		this.addr = addr;
		this.email = email;
		this.id = id;
		this.pwd = pwd;
		this.gender = gender;
	}

	public String getMem_code() {
		return mem_code;
	}

	public String getName() {
		return name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getContact() {
		return contact;
	}

	public String getAddr() {
		return addr;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "MemberVO [mem_code=" + mem_code + ", name=" + name + ", birthday=" + birthday + ", contact=" + contact
				+ ", addr=" + addr + ", email=" + email + ", id=" + id + ", pwd=" + pwd + ", gender=" + gender + "]";
	}
	
	
	
}
