package kr.com.yh.lotte.vo;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class MovieSearch {
    private String content;                          // 검색내용
    private MovieSearchCategory movieSearchCategory; // [이름, 관람등급]
}
