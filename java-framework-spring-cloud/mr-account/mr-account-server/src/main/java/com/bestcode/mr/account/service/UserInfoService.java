package com.bestcode.mr.account.service;

import com.bestcode.mr.account.model.entity.UserInfo;

/**
 * @author xch
 * @create 2018-07-02 21:28
 **/
public interface UserInfoService {

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
