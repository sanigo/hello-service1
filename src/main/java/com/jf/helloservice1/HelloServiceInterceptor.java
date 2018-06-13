package com.jf.helloservice1;

import java.sql.Timestamp;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

public class HelloServiceInterceptor extends HandlerInterceptorAdapter {
    public HelloServiceInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler)
        throws Exception {
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(request.getRequestURL());
        System.out.println("--------------Headers--------------------");
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(String.format("%s=%s", name, request.getHeader(name)));
        }
        System.out.println("---------------Parameters-----------------");
        names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(String.format("%s=%s", name, request.getParameter(name)));
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override public void afterConcurrentHandlingStarted(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
