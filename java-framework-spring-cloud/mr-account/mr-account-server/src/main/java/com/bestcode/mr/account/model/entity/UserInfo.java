package com.bestcode.mr.account.model.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author xch
 * @create 2018-07-02 21:25
 **/
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;
    private String password;
    private String openid;
    private Integer role;
    private Date createTime;
    private Date updateTime;
}
