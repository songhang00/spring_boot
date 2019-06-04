package com.song;

import com.song.domain.User;
import com.song.mapper.UserMapper;
import org.hibernate.validator.constraints.URL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Target;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatApplication.class)
public class MyJuintTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void  test(){
        List<User> users=userMapper.queryUserList();
        System.out.println(users);

    }
}
