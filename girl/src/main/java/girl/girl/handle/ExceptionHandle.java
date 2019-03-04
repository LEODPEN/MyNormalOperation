package girl.girl.handle;


import girl.girl.domain.Result;
import girl.girl.exception.GirlException;
import girl.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger =LoggerFactory.getLogger(ExceptionHandle.class);

    //抛出的异常在这里被接受和处理
    @ExceptionHandler(value = Exception.class)
    @ResponseBody //json 格式？
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }
        else{
            logger.error("[系统异常]",e);
            return ResultUtil.error(-1,"unknown error!");
        }
    }
}
