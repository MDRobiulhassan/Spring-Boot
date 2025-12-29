package com.example.SpringSecurity;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.service.jwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    private jwtService jwtService;

    @Test
	void contextLoads() {
        User user = User.builder()
                .id(4L)
                .email("robiul@gmail.com")
                .password("12345")
                .build();


        String token = jwtService.generateToken(user);
        System.out.println(token);

        Long userId = jwtService.getUserIdByToken(token);
        System.out.println(userId);
    }

}
