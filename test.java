import org.junit.jupiter.api.Test;
package com.iheima;
import com.iheima.UserService;

public class test {
    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("100000200010011011");
        System.out.println(age);
    }
}
