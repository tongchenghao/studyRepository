package net.tch.user.service;

import net.tch.user.dto.CheckAuthRequest;
import net.tch.user.dto.CheckAuthResponse;
import net.tch.user.dto.UserLoginRequest;
import net.tch.user.dto.UserLoginResponse;

/**
 * @description:用户服务
 * @auth tongchenghao
 * @date 2020/2/25
 */
public interface IUserCoreService {

    /**
     * 用户登录
     * @param request
     * @return
     */
    UserLoginResponse login(UserLoginRequest request);

    /**
     * 验证是否登录
     * @param request
     * @return
     */
    CheckAuthResponse validToken(CheckAuthRequest request);
}
