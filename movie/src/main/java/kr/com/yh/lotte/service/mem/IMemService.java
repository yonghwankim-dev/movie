package kr.com.yh.lotte.service.mem;

import kr.com.yh.lotte.vo.MemberSearch;
import kr.com.yh.lotte.vo.MemberVO;

import java.util.List;

public interface IMemService {

    /**
     * 모든 회원 조회
     * @return 회원 리스트
     */
    List<MemberVO> findMemberAll(MemberSearch memberSearch);

    /**
     * 회원 코드에 해당하는 회원 삭제
     * @param mem_codes 회원코드 리스트
     * @return 삭제된 회원 수
     */
    int delete(List<String> mem_codes);

    /**
     * 회원 코드에 따른 회원 조회
     * @param mem_code 회원 코드
     * @return 회원
     */
    MemberVO findOne(String mem_code);

    /**
     * 회원 코드에 따른 회워정보 갱신
     * @param mem 회원
     * @return 갱신한 회원수
     */
    int modifyMemberByMemberCode(MemberVO mem);

    /**
     * 이름이 포함된 회원들 검색
     * @param name 이름
     * @return 회원 리스트
     */
    List<MemberVO> findMemberByName(String name);

    /**
     * id가 포함된 회원들 검색
     * @param id 아이디
     * @return 회원 리스트
     */
    List<MemberVO> findMemberById(String id);

    /**
     * 연락처에 따른 회원 검색
     * @param contact 연락처 
     * @return 회원 리스트
     */
    List<MemberVO> findMemberByContact(String contact);
}
