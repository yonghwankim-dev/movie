package kr.com.yh.lotte.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.SqlMapClientFactory;

public class JoinDaoImpl implements IJoinDao {
	
	private SqlMapClient smc;
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

		int cnt = 0;

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
		
		int cnt = 0;
		
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
		
		int cnt = 0;

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

		int cnt = 0;

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

		int cnt = 0;
		
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
	public String getName(Map<String, Object> map) {
		String name = null;

		try {
			name = (String) smc.queryForObject("join.getName", map);

		} catch (SQLException e) {
			throw new RuntimeException("이름 가져오는중 예외 발생");
		}
		return name;
	}

	@Override
	public int deleteMember(String pw) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("join.deleteMember", pw);
		} catch (SQLException e) {
			throw new RuntimeException("회원탈퇴중 예외 발생");
		}
		return 0;
	}

	@Override
	public String searchLoginId(Map<String, Object> map) {
		String loginId = null;
		
		try {
			loginId = (String) smc.queryForObject("join.searchLoginId", map);
		} catch (SQLException e) {
			throw new RuntimeException("아이디 찿기중 예외 발생");
//			e.printStackTrace();
		}
		
		return loginId;
	}

	@Override
	public String getMemCd(String id) {
		String memCode = null;
		
		try {
			memCode = (String) smc.queryForObject("join.getMemCode", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memCode;
	}
}