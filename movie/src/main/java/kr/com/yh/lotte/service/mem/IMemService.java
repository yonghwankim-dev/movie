package kr.com.yh.lotte.service.mem;

import kr.com.yh.lotte.vo.MemberVO;

import java.util.List;

public interface IMemService {

    /**
     * 모든 회원 조회
     * @return 회원 리스트
     */
    List<MemberVO> findMemberAll();

    /**
     * 회원 코드에 해당하는 회원 삭제
     * @param mem_codes 회원코드 리스트
     * @return 삭제된 회원 수
     */
    int deleteMemberByMemberCode(List<String> mem_codes);

    /**
     * 회원 코드에 따른 회원 조회
     * @param mem_code 회원 코드
     * @return 회원
     */
    MemberVO findMemberByMemberCode(String mem_code);
}
