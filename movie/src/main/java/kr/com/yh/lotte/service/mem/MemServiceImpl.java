package kr.com.yh.lotte.service.mem;

import kr.com.yh.lotte.dao.mem.IMemberDao;
import kr.com.yh.lotte.dao.mem.MemberDaoImpl;
import kr.com.yh.lotte.vo.MemberSearch;
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
    public List<MemberVO> findAll(MemberSearch memberSearch) {
        return memberDao.findAll(memberSearch);
    }

    @Override
    public List<MemberVO> findAllByName(String name) {
        return memberDao.findAllByName(name);
    }

    @Override
    public List<MemberVO> findAllById(String id) {
        return memberDao.findAllById(id);
    }

    @Override
    public List<MemberVO> findAllByContact(String contact) {
        return memberDao.findAllByContact(contact);
    }

    @Override
    public MemberVO findOne(String mem_code) {
        return memberDao.findOne(mem_code);
    }

    @Override
    public MemberVO findOneById(String id) { return memberDao.findOneById(id);}

    @Override
    public MemberVO findOneByContact(String contact) {return memberDao.findOneByContact(contact);}

    @Override
    public int modifyOne(MemberVO mem) {
        return memberDao.modifyOne(mem);
    }

    @Override
    public int deleteAll(List<String> mem_codes) {
        return memberDao.deleteAll(mem_codes);
    }

}
