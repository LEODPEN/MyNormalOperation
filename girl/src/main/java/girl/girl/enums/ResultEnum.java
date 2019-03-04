package girl.girl.enums;

public enum ResultEnum {
    UNKNOWN_ERROR(-1,"unknown error"),
    SUCCESS(0,"操作成功"),
    PRIAMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中?"),
    OLD_DOG(102,"老狗");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
