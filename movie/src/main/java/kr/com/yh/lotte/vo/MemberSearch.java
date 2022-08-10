package kr.com.yh.lotte.vo;

import lombok.*;

@Getter
public class MemberSearch {
    private String content; // 검색내용
    private MemberSearchCategory memberSearchCategory;  // [이름, 아이디, 연락처]

    private MemberSearch(String content, String category){
        this.content = content;
        this.memberSearchCategory = MemberSearchCategory.valueOf(category);
    }

    public static MemberSearch createMemberSearch(){
        return createMemberSearch(null, null);
    }

    public static MemberSearch createMemberSearch(String content, String category){
        if(isBlank(category)){
            category = "NAME";
        }
        category = category.toUpperCase();

        return new MemberSearch(content, category);
    }

    private static boolean isBlank(String text){
        return text == null || text.equals("") ? true : false;
    }



}
