package kr.com.yh.lotte.vo;


import java.sql.Date;

/**
 * Class Description
 * 영화 웹 사이트에 로그인한 회원의 정보를 다음 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-03-16
 */
public class MemberVO {
	private String mem_code;	// 회원코드
	private String mem_name;	// 회원이름
	private String mem_sex;		// 회원성별
	private Date   mem_birth;	// 회원생년월일
	private String mem_phone;	// 회원핸드폰번호
	private String mem_addr;	// 회원주소
	private String mem_email;	// 회원이메일
	private String mem_id;		// 회원아이디
	private String mem_pwd;		// 회원비밀번호
	
	public MemberVO() {
		
	}
	
	public MemberVO(Builder builder) {
		this.mem_code = builder.mem_code;
		this.mem_name = builder.mem_name;
		this.mem_sex = builder.mem_sex;
		this.mem_birth = builder.mem_birth;
		this.mem_phone = builder.mem_phone;
		this.mem_addr = builder.mem_addr;
		this.mem_email = builder.mem_email;
		this.mem_id = builder.mem_id;
		this.mem_pwd = builder.mem_pwd;
	}
	
	public static class Builder{
		private String mem_code;	// 회원코드
		private String mem_name;	// 회원이름
		private String mem_sex;		// 회원성별
		private Date   mem_birth;	// 회원생년월일
		private String mem_phone;	// 회원핸드폰번호
		private String mem_addr;	// 회원주소
		private String mem_email;	// 회원이메일
		private String mem_id;		// 회원아이디
		private String mem_pwd;		// 회원비밀번호
		
		public Builder(String mem_code) {
			this.mem_code = mem_code;
		}
		public Builder mem_name(String mem_name) {
			this.mem_name = mem_name;
			return this;
		}
		public Builder mem_sex(String mem_sex) {
			this.mem_sex = mem_sex;
			return this;
		}
		public Builder mem_birth(Date mem_birth) {
			this.mem_birth = mem_birth;
			return this;
		}
		public Builder mem_phone(String mem_phone) {
			this.mem_phone = mem_phone;
			return this;
		}
		public Builder mem_addr(String mem_addr) {
			this.mem_addr = mem_addr;
			return this;
		}
		public Builder mem_email(String mem_email) {
			this.mem_email = mem_email;
			return this;
		}
		public Builder mem_id(String mem_id) {
			this.mem_id = mem_id;
			return this;
		}
		public Builder mem_pwd(String mem_pwd) {
			this.mem_pwd = mem_pwd;
			return this;
		}
		public MemberVO build() {
			return new MemberVO(this);
		}
	}
	
	public String getMem_code() {
		return mem_code;
	}
	public String getMem_name() {
		return mem_name;
	}
	public String getMem_sex() {
		return mem_sex;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public String getMem_email() {
		return mem_email;
	}
	public String getMem_id() {
		return mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
}
