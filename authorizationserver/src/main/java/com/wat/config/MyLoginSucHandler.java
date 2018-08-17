package com.wat.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *  SavedRequestAwareAuthenticationSuccessHandler 是AuthenticationSuccessHandler 的默认实现方法，
 *  继承此方法重写 onAuthenticationSuccess 方法可以添加自定义信息,例如日志。
 *
 * @Author: chuangwang8
 * @Date: 2018-08-16 19:27
 * @Description:
 */
public class MyLoginSucHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public MyLoginSucHandler(boolean alwaysUseDefaultTargetUrl,String defaultTargetUrl) {
        this.setAlwaysUseDefaultTargetUrl(alwaysUseDefaultTargetUrl);
        this.setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        System.err.println("登录成功," + httpServletRequest.getRequestURI());
        super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);
    }
}
