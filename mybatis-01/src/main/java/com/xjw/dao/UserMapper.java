package com.xjw.dao;

import com.xjw.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> listUsers();

    int selectMaxUserId();

    int addUser(User user);

    int updateUser(User u);

    int delUser(Integer userId);
}
