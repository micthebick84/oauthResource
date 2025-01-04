package com.example.oauth2resource.service;

import com.example.oauth2resource.entity.UserEntity;
import com.example.oauth2resource.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //  회원 정보 불러오기
    public UserEntity getUserInfo(String userName){
        return userRepository.findByUsername(userName);
    }

}
