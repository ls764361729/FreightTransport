package com.ls.FreightTransport.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private static String LOGIN_SIGN = "Authorization";
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        if (isLoginAttempt(request, response)) {
            return executeLogin(request, response);
        }
        return false;
    }
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(LOGIN_SIGN);
        return authorization != null;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.sendRedirect("/login/verificationFailed");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response)  {
        HttpServletRequest req = (HttpServletRequest) request;
        String header = req.getHeader(LOGIN_SIGN);
        JWTToken token = new JWTToken(header);
        try {
            getSubject(request, response).login(token);
        }catch (AuthenticationException e){
            return false;
        }
        return true;
    }


}
