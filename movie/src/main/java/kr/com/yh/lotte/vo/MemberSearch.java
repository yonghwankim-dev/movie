package kr.com.yh.lotte.vo;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class MemberSearch {
    private String content; // 검색내용
    private MemberSearchCategory memberSearchCategory;  // [이름, 아이디, 연락처]
}
