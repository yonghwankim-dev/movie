package kr.com.yh.lotte.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.SqlMapClientFactory;

import java.sql.SQLException;
import java.util.Map;

public class JoinDaoImpl implements IJoinDao {
	
	private final SqlMapClient smc;
	private static IJoinDao joinDao;

	public static IJoinDao getInstance() {
		if (joinDao == null) {
			joinDao = new JoinDaoImpl();
		}
		return joinDao;
	}

	private JoinDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	@Override
	public int insertMember(MemberVO vo) {
		int cnt = 0;

		try {
			cnt = smc.update("join.insertMember", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public boolean checkMember(String id) {
		boolean chk = false;

		int cnt;

		try {
			cnt = (int) smc.queryForObject("join.checkMember", id);

			if (cnt > 0) {
				chk = true;
			}

		} catch (SQLException e) {
			throw new RuntimeException("ID 중복체크중 예외 발생");
		}
		return chk;
	}
	
	
	
	@Override
	public boolean checkPhone(String phone) {
		boolean chk = false;
		
		int cnt;
		
		try {
			cnt = (int) smc.queryForObject("join.checkPhone", phone);
			
			if(cnt > 0) {
				chk = true;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Phone 중복체크중 예외 발생");
		}
		return chk;
	}

	@Override
	public boolean checkEmail(String email) {
		boolean chk = false;
		
		int cnt;

		try {
			cnt = (int) smc.queryForObject("join.checkEmail", email);
			
			if(cnt > 0){
				chk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public boolean checkNickName(String nickName) {
		boolean chk = false;

		int cnt;

		try {
			cnt = (int) smc.queryForObject("join.checkNick", nickName);

			if (cnt > 0) {
				chk = true;
			}
		} catch (SQLException e) {
			throw new RuntimeException("닉네임 중복체크중 예외 발생");
		}
		return chk;
	}

	@Override
	public boolean checkLogin(Map<String, Object> map) {
		boolean chk = false;

		int cnt;
		
		try {
			cnt = (int) smc.queryForObject("join.checkLogin", map);

			if (cnt > 0) {
				chk = true;
			}
		} catch (SQLException e) {
			throw new RuntimeException("로그인 체크중 예외 발생");
		}
		return chk;
	}

	@Override
	public int deleteMember(String pw) {
		int cnt;
		
		try {
			cnt = smc.delete("join.deleteMember", pw);
		} catch (SQLException e) {
			throw new RuntimeException("회원탈퇴중 예외 발생");
		}
		return cnt;
	}

	@Override
	public String searchLoginId(Map<String, Object> map) {
		String loginId;
		
		try {
			loginId = (String) smc.queryForObject("join.searchLoginId", map);
		} catch (SQLException e) {
			throw new RuntimeException("아이디 찿기중 예외 발생");
		}
		
		return loginId;
	}

	@Override
	public MemberVO getMemberInfo(Map<String, Object> map) {
		MemberVO mem = null;
		
		try {
			mem = (MemberVO) smc.queryForObject("join.getMemberInfo", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mem;
	}

	
}