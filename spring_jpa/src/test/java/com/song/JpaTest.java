package com.song;

import com.song.domain.User;
import com.song.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaApplication.class )
public class JpaTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public  void findAll(){
        List<User> all = userRepository.findAll();
        System.out.println(all);

    }
}
