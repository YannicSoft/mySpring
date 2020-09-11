package com.yannic.myspring.ioc.repository;

import com.yannic.myspring.ioc.model.User;

import java.util.Collection;

/**
 * 用户仓库
 */
public class UserRepository {
    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
