package kr.com.yh.lotte.service.mem;

import kr.com.yh.lotte.dao.mem.IMemberDao;
import kr.com.yh.lotte.dao.mem.MemberDaoImpl;
import kr.com.yh.lotte.vo.MemberVO;

import java.util.List;

public class MemServiceImpl implements IMemService{
    private static IMemService memberService;

    private IMemberDao memberDao;

    private MemServiceImpl(){
        memberDao = MemberDaoImpl.getInstance();
    }

    public static IMemService getInstance(){
        if(memberService == null){
            memberService = new MemServiceImpl();
        }
        return memberService;
    }

    @Override
    public List<MemberVO> findMemberAll() {
        return memberDao.findMemberAll();
    }

    @Override
    public int deleteMemberByMemberCode(List<String> mem_codes) {
        return memberDao.deleteMemberByMemberCode(mem_codes);
    }

    @Override
    public MemberVO findMemberByMemberCode(String mem_code) {
        return memberDao.findMemberByMemberCode(mem_code);
    }


    @Override
    public List<MemberVO> findMemberByName(String name) {
        return memberDao.findMemberByName(name);
    }

    @Override
    public List<MemberVO> findMemberById(String id) {
        return memberDao.findMemberById(id);
    }

    @Override
    public List<MemberVO> findMemberByContact(String contact) {
        return memberDao.findMemberByContact(contact);
    }

    @Override
    public int modifyMemberByMemberCode(MemberVO mem) {
        return memberDao.modifyMemberByMemberCode(mem);
    }

}
