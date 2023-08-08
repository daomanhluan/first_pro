package com.example.first_pro;

import com.example.first_pro.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.first_pro.repository.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void test(){
        System.out.println("test");
        UserEntity userEntity = UserEntity.builder().username("luandm").build();
        userRepository.save(userEntity);
        System.out.println("ojk");
    }
}
