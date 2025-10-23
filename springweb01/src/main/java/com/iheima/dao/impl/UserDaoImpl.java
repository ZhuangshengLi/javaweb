package com.iheima.dao.impl;

import com.iheima.dao.UserDao; 
import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{
    
    @Override
    public List<String> findAll() {
        InputStream in = this.getClass().getResourceAsStream("/user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
