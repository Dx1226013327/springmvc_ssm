package edu.cque.controller;

import edu.cque.pojo.User;
import edu.cque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@CrossOrigin //在服务器上设置支持跨域访问
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    // /user/selectUserPage?userName=z&userSex=男&page=null
    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName,String userSex,Integer page){
        //根据页码计算起始行
        int startrow = 0;
        if(page != null){
            startrow = (page-1)*5;
        }
        return userService.selectUserPage(userName,userSex,startrow);
    }

    // /user/getRowCount?userName=z&userSex=男
    @RequestMapping("/getRowCount")
    public int getRowCount(String userName,String userSex){
        return userService.getRowCount(userName,userSex);
    }

    ///user/ deleteUserById?userId= 15968162087363060
    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId){
        return userService.deleteUserById(userId);
    }
    // /user/createUser(参数见下面)
    @RequestMapping("/createUser")
    public int createUser(User user){
        return userService.createUser(user);
    }

    ///user/updateUserById(参数见以下)
    @RequestMapping("/updateUserById")
    public int updateUserById(User user){
        return userService.updateUserById(user);
    }

    //deleteUserByIdList 批量删除
    @RequestMapping("deleteUserByIdList")
    public int deleteUserByIdList(String[] userIdList){
        Arrays.toString(userIdList);
        return userService.deleteUserByIdList(userIdList);
    }

}
