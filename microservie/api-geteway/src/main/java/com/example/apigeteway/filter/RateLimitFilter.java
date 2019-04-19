package com.example.apigeteway.filter;


import com.example.apigeteway.exception.RateLimitException;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

//限流
@Component
public class RateLimitFilter extends ZuulFilter {

    //每秒钟向令牌桶中放多少令牌
    private final static RateLimiter RATE_LIMITER= RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //比最低优先级还要小
        return SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext =  RequestContext.getCurrentContext();
        //tryAcquire()不写参数代表取一个令牌
        if (!RATE_LIMITER.tryAcquire()){
            //一种写法
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            //another
            throw new RateLimitException();
        }
        return null;
    }
}
