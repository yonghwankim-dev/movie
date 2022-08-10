package kr.com.yh.lotte.vo;

import lombok.Getter;

@Getter
public class CinemaSearch {
    private String content; // 검색내용
    private CinemaSearchCategory cinemaSearchCategory;  // [이름, 지역]

    private CinemaSearch(String content, String category){
        this.content = content;
        this.cinemaSearchCategory = cinemaSearchCategory.valueOf(category);
    }

    public static CinemaSearch createCinemaSearch(){
        return createCinemaSearch(null, null, null);
    }

    public static CinemaSearch createCinemaSearch(String content, String category, String loc){
        if(isBlank(category)){
            category = "NAME";
        }
        if(isLocation(category)){
            content = loc;
        }
        category = category.toUpperCase();

        return new CinemaSearch(content, category);
    }

    private static boolean isBlank(String text){
        return text == null || text.equals("") ? true : false;
    }

    private static boolean isLocation(String text){
        return text.equals("loc");
    }

}
