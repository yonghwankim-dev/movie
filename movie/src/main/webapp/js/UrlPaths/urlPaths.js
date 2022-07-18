
const CONTEXT_PATH      = "/movie";
const SIGNUP            = "/signUp";
const TICKET            = "/ticket";
const ADMIN             = "/admin";

const urlPaths = {
    "LOTTE"             : CONTEXT_PATH + "/lotte",
    "LOGIN"             : CONTEXT_PATH + "/login",
    "LOGOUT"            : CONTEXT_PATH + "/logout",
    "SIGNUP"            : CONTEXT_PATH + SIGNUP,
    "SUCCESS_SIGNUP"    : CONTEXT_PATH + SIGNUP + "/success",
    "CHECK_EMAIL"       : CONTEXT_PATH + SIGNUP + "/checkEmail",
    "CHECK_ID"          : CONTEXT_PATH + SIGNUP + "/checkId",
    "CHECK_PHONE"       : CONTEXT_PATH + SIGNUP + "/checkPhone",
    "PERSON_SEAT"       : CONTEXT_PATH + TICKET + "/personSeat",
    "ORDER_SETTLEMENT"  : CONTEXT_PATH + TICKET + "/orderSettlement",
    "BOOK"              : CONTEXT_PATH + TICKET + "/book",
    "PAYMENT_RESULT"    : CONTEXT_PATH + TICKET + "/paymentResult",
    "SCREEN_HOME"       : CONTEXT_PATH + ADMIN + "/screen/home",
    "SCREEN_ADD"        : CONTEXT_PATH + ADMIN + "/screen/add",
    "SCREEN_DELETE"     : CONTEXT_PATH + ADMIN + "/screen/delete",
    "SCREEN_SCH_HOME"   : CONTEXT_PATH + ADMIN + "/screenSch/home",
    "SCREEN_SCH_ADD"    : CONTEXT_PATH + ADMIN + "/screenSch/add",
    "SCREEN_SCH_DELETE" : CONTEXT_PATH + ADMIN + "/screenSch/delete"
};

export default urlPaths;

