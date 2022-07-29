package kr.com.yh.lotte;

public class UrlPaths {
    public static final String LOTTE             = "/lotte";

    public static final String LOGIN             = "/login";

    public static final String LOGOUT            = "/logout";

    public static final String SIGNUP            = "/signUp";

    public static final String SIGNUP_SUCCESS    = SIGNUP + "/success";

    public static final String CHECK_EMAIL       = SIGNUP + "/checkEmail";

    public static final String CHECK_ID          = SIGNUP + "/checkId";

    public static final String CHECK_PHONE       = SIGNUP + "/checkPhone";

    public static final String TICKET            = "/ticketing";

    public static final String PERSON_SEAT       = TICKET + "/personSeat";

    public static final String ORDER_SETTLEMENT  = TICKET + "/orderSettlement";

    public static final String BOOK              = TICKET + "/book";

    public static final String PAYMENT_RESULT    = TICKET + "/paymentResult";

    public static final String ADMIN             = "/admin";

    public static final String MEM_HOME          = ADMIN + "/mem/home";

    public static final String MEM_DELETE        = ADMIN + "/mem/delete";

    public static final String MEM_DETAIL        = ADMIN + "/mem/detail";

    public static final String MEM_MODIFY        = ADMIN + "/mem/modify";

    public static final String MEM_FIND          = ADMIN + "/mem/find";
    public static final String SCREEN_HOME       = ADMIN + "/screen/home";
    public static final String SCREEN_ADD        = ADMIN + "/screen/add";
    public static final String SCREEN_DELETE     = ADMIN + "/screen/delete";
    public static final String SCREEN_SCH_HOME   = ADMIN + "/screenSch/home";
    public static final String SCREEN_SCH_ADD    = ADMIN + "/screenSch/add";
    public static final String SCREEN_SCH_DELETE = ADMIN + "/screenSch/delete";
}
