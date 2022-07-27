package test;


import edu.cque.pojo.User;
import edu.cque.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class MyTest {
    @Autowired
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> list = userService.selectUserPage("张","男",0);
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testDeleteUserById(){
        int num = userService.deleteUserById("1226013327");
        System.out.println(num);
    }

    @Test
    public void testCreateUser(){
        User user = new User("1226013327","dd","dd","dd","dd","dd","dd");
        int num = userService.createUser(user);
        System.out.println(num);
    }

    @Test
    public void testGetRowCount(){
        int rowCount = userService.getRowCount(null, null);
        System.out.println(rowCount);
    }

    @Test
    public void testUpdateUserById(){
        User user = new User();
        user.setUserId("15968162087363060");
        user.setUserName("邓大大");
        int i = userService.updateUserById(user);
        System.out.println(i);
    }

    @Test
    public void testDeleteUserByIdList(){
        String[] array = new String[3];
        array[0] = "1658671227565";
        array[1] = "1658671234911";
        array[2] = "1658671237012";
        int num = userService.deleteUserByIdList(array);
        System.out.println(num);
    }

    public static void main(String[] args) {
        System.out.println("测试Git");
        System.out.println("git版本2");
        System.out.println("hello 4");
        System.out.println("master test");
        System.out.println("hot-fix test");
        System.out.println("push test");
        System.out.println("testtwo");
    }
}
