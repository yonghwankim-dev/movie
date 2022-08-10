package kr.com.yh.lotte.vo;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MovieSearch {
    private String content;                          // 검색내용
    private MovieSearchCategory movieSearchCategory; // [이름, 관람등급]

    private MovieSearch(String content, String category){
        this.content = content;
        this.movieSearchCategory = MovieSearchCategory.valueOf(category);
    }

    public static MovieSearch createMovieSearch(String content, String category){
        if(isBlank(category)){
            category = "NAME";
        }
        category = category.toUpperCase();

        return new MovieSearch(content, category);
    }

    private static boolean isBlank(String text){
        return text == null || text.equals("") ? true : false;
    }
}
