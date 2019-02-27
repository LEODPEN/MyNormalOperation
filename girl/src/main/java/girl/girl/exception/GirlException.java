package girl.girl.exception;

//只有继承RuntimeException 才会事务回滚，不然直接继承Exception是没有回滚的
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
