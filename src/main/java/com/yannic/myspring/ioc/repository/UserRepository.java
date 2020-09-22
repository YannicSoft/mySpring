package com.yannic.myspring.ioc.repository;

import com.yannic.myspring.ioc.model.User;

import java.util.Collection;

/**
 * 用户仓库
 * @author yannic
 */
public class UserRepository {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

}
