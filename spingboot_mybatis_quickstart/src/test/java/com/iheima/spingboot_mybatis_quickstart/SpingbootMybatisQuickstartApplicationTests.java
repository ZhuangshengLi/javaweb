package com.iheima.spingboot_mybatis_quickstart;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.iheima.mapper.UserMapper;
import com.iheima.pojo.User;

import java.util.List;

@SpringBootTest
class SpingbootMybatisQuickstartApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testFindAll() {
		List<User> users = userMapper.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testDeleteById() {
		Integer rows = userMapper.deleteById(5);
		System.out.println(rows);
	}

	@Test
	public void testSelect() {
		User user = userMapper.findUserByUsernameAndPassword("xiaoqiao", "123456");
		System.out.println(user);
	}

}
