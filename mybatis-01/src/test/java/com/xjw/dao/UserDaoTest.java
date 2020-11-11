package com.xjw.dao;

import com.xjw.pojo.User;
import com.xjw.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    private SqlSession sqlSession;

    @Before
    public void beforeMethod(){
        System.out.println("before");
        sqlSession = MybatisUtils.getSqlsession();
    }

    @Test
    public void queryList(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.listUsers();
        for (User u : users){
            System.out.println(u.toString());
        }
    }

    @Test
    public void add(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int userId = mapper.selectMaxUserId();
        User u = new User();
        u.setUserId(userId+1);
        u.setUserName("test");
        u.setPasswd("12344343");
        mapper.addUser(u);
        sqlSession.commit();
        System.out.println("插入完成:"+u.toString());
    }

    @Test
    public void update(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setUserId(5);
        u.setUserName("王五-改");
        u.setPasswd("qqqqqqq---");
        mapper.updateUser(u);
        sqlSession.commit();
        System.out.println("更新完成:"+u.toString());
    }

    @Test
    public void deleteUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int userId = 7;
        mapper.delUser(userId);
        sqlSession.commit();
        System.out.println("删除成功:"+userId);
    }

    @After
    public void afterMethod(){
        System.out.println("After");
        sqlSession.close();
    }
}
