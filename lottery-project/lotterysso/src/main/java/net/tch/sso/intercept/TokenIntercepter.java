package net.tch.sso.intercept;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.tch.sso.controller.Anoymous;
import net.tch.sso.controller.BaseController;
import net.tch.sso.utils.CookieUtil;
import net.tch.user.constants.ResponseCodeEnum;
import net.tch.user.dto.CheckAuthRequest;
import net.tch.user.dto.CheckAuthResponse;
import net.tch.user.service.IUserCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

/**
 * @description:验签拦截器
 * @auth tongchenghao
 * @date 2020/2/28
 */
public class TokenIntercepter extends HandlerInterceptorAdapter {

    public static final String ACCESS_TOKEN = "access_token";

    @Autowired
    IUserCoreService userCoreService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handle = (HandlerMethod) handler;
        Object bean = handle.getBean();
        if(!(bean instanceof BaseController)){
            throw  new RuntimeException("must extend BaseController");
        }
        if(isAnoymous(handle)){
            // 无需验签，直接调用对应方法
            return true;
        }else{
            String token = CookieUtil.getCookieValue(request, ACCESS_TOKEN);
            if(StringUtils.isEmpty(token)){
                if(CookieUtil.isAjax(request)){
                    response.getWriter().write("{'code':'-1','message':'error'}");
                    return false;
                }

                response.sendRedirect("/pages/login.html");
                return false;
            }

            CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
            checkAuthRequest.setToken(token);
            CheckAuthResponse checkAuthResponse = userCoreService.validToken(checkAuthRequest);
            //验签成功
            if(ResponseCodeEnum.SUCCESS.equals(checkAuthResponse.getCode())){
                String uid = checkAuthResponse.getUid();
                BaseController baseController = (BaseController) bean;
                baseController.setUid(uid);
                return true;
            }

            ObjectMapper objectMapper = new ObjectMapper();
            response.getWriter().write(objectMapper.writeValueAsString(checkAuthResponse));
            return false;
        }
    }

    /**
     * 判断请求的方法是否有Anoymous注解，
     *      如果为true则无需验签，否则需要验签
     * @param handle
     * @return
     */
    private boolean isAnoymous(HandlerMethod handle){
        Object bean = handle.getBean();
        Class<?> clazz = bean.getClass();
        if(clazz.getAnnotation(Anoymous.class)!=null){
            return true;
        }
        Method method = handle.getMethod();
        if(method.getAnnotation(Anoymous.class)!=null){
            return true;
        }
        return false;
    }
}
