package com.iheima;

import org.junit.jupiter.api.*;
import com.itheima.UserService;
import org.junit.jupiter.api.Assertions;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = new UserService();
    }
    
    @Test
    public void testGetAge(){
        Integer age = userService.getAge("100000200010011011");
        System.out.println(age);
    }

    @Test
    public void testGetGender(){
        String gender = userService.getGender("100000200010011011");
        Assertions.assertEquals("男", gender, "性别获取错误");
    }

    @Test
    public void testGenderWithAssert(){
       Assertions.assertThrows(IllegalArgumentException.class, () -> {
        userService.getGender(null);
       });
    }
}
