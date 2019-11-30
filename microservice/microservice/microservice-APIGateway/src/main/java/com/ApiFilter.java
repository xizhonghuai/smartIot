package com;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ApiFilter
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-09-20 16:21
 * @Version 1.0
 */
@Component
public class ApiFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";// 前置过滤器

    }

    @Override
    public int filterOrder() {
        return 0;// 优先级为0，数字越大，优先级越低

    }

    /*
      返回true表示传递到下一个过滤器
     */
    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();

        if(!ctx.sendZuulResponse()){
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false); //表示请求不会被zuul转发到后端服务器
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }

        return null;
    }
}
