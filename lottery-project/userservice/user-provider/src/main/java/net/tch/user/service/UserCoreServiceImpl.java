package net.tch.user.service;

import com.alibaba.dubbo.common.utils.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import net.tch.user.constants.ResponseCodeEnum;
import net.tch.user.dal.entity.User;
import net.tch.user.dal.persistence.UserMapper;
import net.tch.user.dto.CheckAuthRequest;
import net.tch.user.dto.CheckAuthResponse;
import net.tch.user.dto.UserLoginRequest;
import net.tch.user.dto.UserLoginResponse;
import net.tch.user.exception.ExceptionUtil;
import net.tch.user.exception.ServiceException;
import net.tch.user.exception.ValidateException;
import net.tch.utils.JwtTokenUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:用户服务实现类
 * @auth tongchenghao
 * @date 2020/2/25
 */
@Service("userCoreService")
public class UserCoreServiceImpl implements IUserCoreService {

    Logger  Log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        Log.info("login request ->"+request);
        UserLoginResponse response = new UserLoginResponse();// 构建返回对象
        try {
            beforeValidate(request); // 验证请求对象

            User user = userMapper.getUser(request.getUsername(),request.getPassword());
            if(user==null){
                response.setCode(ResponseCodeEnum.USERORPASSWORD_ERRROR.getCode());
                response.setMessage(ResponseCodeEnum.USERORPASSWORD_ERRROR.getMsg());
            }else{
                response.setCode(ResponseCodeEnum.SUCCESS.getCode());
                response.setMessage(ResponseCodeEnum.SUCCESS.getMsg());
                response.setAvatar(user.getAvatar());
                response.setMobile(user.getMobile());
                response.setUid(user.getId());
                // 生成并设置token
                Map<String ,Object> map = new HashMap<>();
                map.put("uid",user.getId());
                map.put("exp", DateTime.now().plusSeconds(40).toDate().getTime()/1000);
                response.setToken(JwtTokenUtils.generatorToken(map));
            }

        }catch (Exception e){
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setMessage(serviceException.getMessage());
        }finally {
            Log.info("login response ->"+response);
        }
        return response;
    }

    @Override
    public CheckAuthResponse validToken(CheckAuthRequest request) {
        CheckAuthResponse response = new CheckAuthResponse();// 构建返回对象
        try {
            // 验证参数
            beforeValidateAuth(request);

            Claims claims = JwtTokenUtils.phaseToken(request.getToken());
            Object uid = claims.get("uid");
            response.setUid(uid.toString());
            response.setCode(ResponseCodeEnum.SUCCESS.getCode());
            response.setMessage(ResponseCodeEnum.SUCCESS.getMsg());

        }catch (ExpiredJwtException e1){
            // 签名超时
            Log.error("Expire:"+e1);
            response.setCode(ResponseCodeEnum.TOKEN_EXPIRE.getCode());
            response.setMessage(ResponseCodeEnum.TOKEN_EXPIRE.getMsg());
        }catch (SignatureException e2){
            // 签名非法
            Log.error("Expire:"+e2);
            response.setCode(ResponseCodeEnum.SIGNATURE_ERROR.getCode());
            response.setMessage(ResponseCodeEnum.SIGNATURE_ERROR.getMsg());
        }
        catch (Exception e){
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setMessage(serviceException.getMessage());
        }finally {
            Log.info("respose -> " + response);
        }

        return response;
    }

    /**
     * 对请求参数进行校验
     * @param request
     */
    private void beforeValidateAuth(CheckAuthRequest request){
        if(request==null){
            throw new ValidateException("请求对象为空");
        }

        if(StringUtils.isEmpty(request.getToken())){
            throw new ValidateException("token信息为空");
        }
    }

    /**
     * 对请求参数进行校验
     * @param request
     */
    private void beforeValidate(UserLoginRequest request){
        if(request==null){
            throw new ValidateException("请求对象为空");
        }

        if(StringUtils.isEmpty(request.getUsername())){
            throw new ValidateException("用户名为空");
        }
        if(StringUtils.isEmpty(request.getPassword())){
            throw new ValidateException("密码为空");
        }
    }
}
