package girl.girl.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//运用令AOP---面向切面编程
@Aspect
@Component
public class HttpAspect {

    //日志记录
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * girl.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    //测试用：logger.info("before !!!");
    public void doBefore(JoinPoint joinpoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("id={}",request.getRemoteAddr());

        //类方法　传入对象joinpoint
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature().getName());

        //参数
        logger.info("args={}",joinpoint.getArgs());


    }

    @After("log()")
    public void doAfter(){
        logger.info("after !!!");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
        //logger.info("response={}",object);
    }



}
/*@Before("execution(public * girl.girl.controller.GirlController.*(..))")
    //两个点表示传入的任何参数都会被拦截
    //第二个*则令GirlController下所有的方法都被拦截
    public void log(){
        System.out.println("before !!!");
    }
    @After("execution(public * girl.girl.controller.GirlController.*(..))")
    public void exit(){
        System.out.println("after !!!");
    }*/