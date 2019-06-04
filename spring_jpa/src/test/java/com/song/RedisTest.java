package com.song;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.song.domain.User;
import com.song.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String>  redisTemplate;
    private UserRepository userRepository;
     @Test    //没有装redis -_-
    public void test() throws JsonProcessingException {
        //1.从redis中获得数据 数据的形式json字符串
         String userListJson = redisTemplate.boundValueOps("user.findAll").get();
         //2.判断是否存在数据
         if (null==userListJson){
             //3.不存在数据 从数据库查询

             List<User> all = userRepository.findAll();
         //4.将存储的数据存储到redis缓存中
             //将list集合转换为json格式 使用jason
             ObjectMapper objectMapper = new ObjectMapper();
             userListJson = objectMapper.writeValueAsString(all);
             System.out.println(userListJson);
             redisTemplate.boundValueOps("user.findAll").set(userListJson);
             System.out.println("==============数据库中获得user data");

         }else{
             System.out.println("从redis中获得");
         }
        //4.打印
         System.out.println(userListJson);


     }
}





