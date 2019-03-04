package girl.girl.exception;

import girl.girl.enums.ResultEnum;

//只有继承RuntimeException 才会事务回滚，不然直接继承Exception是没有回滚的
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
