package edu.cque.mapper;

import edu.cque.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * userName:表单中用户名称
     * userSex:表单中用户性别
     * page:提交的页码(第一次访问为null)
     *
     * /user/selectUserPage?userName=z&userSex=男&page=null
     */
    List<User> selectUserPage(@Param("userName") String userName,@Param("userSex") String userSex, @Param("startRow") int startRow);


    /**
     * /user/getRowCount?userName=z&userSex=男
     * userName:表单中用户名称
     * userSex:表单中用户性别
     */
    int getRowCount(@Param("userName")String userName,@Param("userSex")String userSex);

    /**
     * /user/ deleteUserById?userId= 15968162087363060
     * userId:删除用户的id
     */
    int deleteUserById(String userId);
    /**
     * /user/createUser(参数见下面)
     * cardType: this.ruleForm.cardType,//证件类型
     * cardNo: this.ruleForm.cardNo,//证件号码
     * userName: this.ruleForm.userName,//用户姓名
     * userSex: this.ruleForm.userSex,//用户性别
     * userAge: this.ruleForm.userAge,//用户年龄
     * userRole: this.ruleForm.userRole,//用户角色
     */
    int createUser(User user);

    /**
     * /user/updateUserById(参数见以下)
     * userId: this.ruleForm.userId,//用户 Id
     * cardType: this.ruleForm.cardType,//证件类型
     * cardNo: this.ruleForm.cardNo,//证件号码
     * userName: this.ruleForm.userName,//用户姓名
     * userSex: this.ruleForm.userSex,//用户性别
     * userAge: this.ruleForm.userAge,//用户年龄
     * userRole: this.ruleForm.userRole,//用户角色
     */
    int updateUserById(User user);


    /**
     * 批量删除
     *
     * deleteUserByIdList
     */
    int deleteUserByIdList(String[] arr);
}
