package kr.com.yh.lotte.dao.mem;

import kr.com.yh.lotte.vo.MemberSearch;
import kr.com.yh.lotte.vo.MemberVO;

import java.util.List;

public interface IMemberDao {

    /**
     * 회원전체검색
     */
    List<MemberVO> findAll(MemberSearch memberSearch);

    /**
     * 회원전체검색_이름
     */
    List<MemberVO> findAllByName(String name);

    /**
     * 회원전체검색_아이디
     */
    List<MemberVO> findAllById(String id);

    /**
     * 회원전체검색_연락처
     */
    List<MemberVO> findAllByContact(String contact);

    /**
     * 회원단일검색
     */
    MemberVO findOne(String mem_code);

    /**
     * 회원단일검색_아이디
     */
    MemberVO findOneById(String id);

    /**
     * 회원단일검색_연락처
     */
    MemberVO findOneByContact(String contact);

    /**
     * 회원단일수정
     */
    int modifyOne(MemberVO mem);

    /**
     * 회원전체삭제
     */
    int deleteAll(List<String> mem_codes);
}
