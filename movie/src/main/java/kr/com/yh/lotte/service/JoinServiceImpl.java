package kr.com.yh.lotte.service;

import java.util.Map;

import kr.com.yh.lotte.dao.IJoinDao;
import kr.com.yh.lotte.dao.JoinDaoImpl;
import kr.com.yh.lotte.vo.MemberVO;


public class JoinServiceImpl implements IJoinService {
	private static IJoinService joinService;
	
	private IJoinDao joinDao;
	
	private JoinServiceImpl() {
		joinDao = JoinDaoImpl.getInstance();
	}
	
	public static IJoinService getInstance() {
		if(joinService == null) {
			joinService = new JoinServiceImpl();
		}
		return joinService;
	}
	
	@Override
	public int insertMember(MemberVO vo) {
		int cnt = joinDao.insertMember(vo);
		
		return cnt;
	}

	@Override
	public boolean checkMember(String id) {
		
		return joinDao.checkMember(id);
	}
	
	@Override
	public boolean checkPhone(String phone) {
		return joinDao.checkPhone(phone);
	}

	@Override
	public boolean checkEmail(String email) {
		return joinDao.checkEmail(email);
	}

	@Override
	public boolean checkNickName(String nickName) {

		return joinDao.checkNickName(nickName);
	}

	@Override
	public boolean checkLogin(Map<String, Object> map) {
		return joinDao.checkLogin(map);
	}
	public String getName(Map<String, Object> map) {
		
		return joinDao.getName(map);
	}

	@Override
	public int deleteMember(String pw) {

		return joinDao.deleteMember(pw);
	}

	@Override
	public String searchLoginId(Map<String, Object> map) {

		return joinDao.searchLoginId(map);
	}

	@Override
	public String getMemCd(String id) {
		return joinDao.getMemCd(id);
	}
}
