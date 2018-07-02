package com.bestcode.mr.account.controller;

import java.util.concurrent.TimeUnit;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestcode.mr.account.constant.CookieConstant;
import com.bestcode.mr.account.constant.RedisConstant;
import com.bestcode.mr.account.enums.ResultEnum;
import com.bestcode.mr.account.enums.RoleEnum;
import com.bestcode.mr.account.model.ResultVO;
import com.bestcode.mr.account.model.entity.UserInfo;
import com.bestcode.mr.account.service.UserInfoService;
import com.bestcode.mr.account.utils.CookieUtil;
import com.bestcode.mr.account.utils.KeyUtil;
import com.bestcode.mr.account.utils.ResultVOUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2018-07-02 21:32
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 买家登录
     *
     * @param openid
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {
        UserInfo userInfo = userInfoService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        // 设置cookie
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);
        return ResultVOUtil.success();
    }

    /**
     * 卖家登录
     *
     * @param openid
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletRequest request, HttpServletResponse
            response) {
        // 判断是否已经登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null && !StringUtils.isEmpty((String) redisTemplate.opsForValue().get(String.format(RedisConstant
                .TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success();
        }
        UserInfo userInfo = userInfoService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        String token = KeyUtil.uuid();
        Integer expire = CookieConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token), openid, expire, TimeUnit
                .SECONDS);
        // 设置cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
        return ResultVOUtil.success();
    }
}
