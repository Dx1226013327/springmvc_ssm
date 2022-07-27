package edu.cque.service.impl;

import edu.cque.mapper.UserMapper;
import edu.cque.pojo.User;
import edu.cque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> selectUserPage(String userName, String userSex, int startRow) {
        return userMapper.selectUserPage(userName,userSex,startRow);
    }

    public int getRowCount(String userName, String userSex) {
        return userMapper.getRowCount(userName,userSex);
    }

    public int deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    public int createUser(User user) {
        long time = System.currentTimeMillis();
        user.setUserId(time+"");
        return userMapper.createUser(user);
    }

    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public int deleteUserByIdList(String[] arr) {
        return userMapper.deleteUserByIdList(arr);
    }
}
