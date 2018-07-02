package com.bestcode.mr.account.repository;

import com.bestcode.mr.account.model.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xch
 * @create 2018-07-02 21:27
 **/
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    /**
     * 根据openid查询
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
