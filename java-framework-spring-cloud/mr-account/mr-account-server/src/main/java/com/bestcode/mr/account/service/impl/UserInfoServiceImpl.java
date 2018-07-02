package com.bestcode.mr.account.service.impl;

import com.bestcode.mr.account.model.entity.UserInfo;
import com.bestcode.mr.account.repository.UserInfoRepository;
import com.bestcode.mr.account.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xch
 * @create 2018-07-02 21:31
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 通过openid查询用户信息
     *
     * @param openid
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
