package edu.cque.service;

import edu.cque.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<User> selectUserPage(String userName,String userSex,int startRow);


    int getRowCount(String userName,String userSex);

    int deleteUserById(String userId);

    int createUser(User user);

    int updateUserById(User user);

    int deleteUserByIdList(String[] arr);

}
