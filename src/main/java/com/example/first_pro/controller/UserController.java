package com.example.first_pro.controller;

import com.example.first_pro.entity.UserEntity;
import com.example.first_pro.model.User;
import com.example.first_pro.repository.UserRepository;
import com.example.first_pro.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired private UserRepository userRepository;

  @GetMapping("/get-all")
  public List<User> getUsers() {
    List<UserEntity> userEntities = userRepository.findAll();
    return ModelMapperUtils.mapList(userEntities, User.class);
  }

  @GetMapping("/find-by-id")
  public List<User> findById(@RequestParam Integer id) {
    List<UserEntity> userEntities = userRepository.findByIdIn(Arrays.asList(id));
    return ModelMapperUtils.mapList(userEntities, User.class);
  }
}
