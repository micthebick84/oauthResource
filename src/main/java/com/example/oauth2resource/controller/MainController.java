package com.example.oauth2resource.controller;


import com.example.oauth2resource.dto.ResDTO;
import com.example.oauth2resource.dto.RestWrapper;
import com.example.oauth2resource.entity.UserEntity;
import com.example.oauth2resource.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public RestWrapper me(){
        ResDTO resDTO = new ResDTO();
        UserEntity userEntity = userService.getUserInfo(SecurityContextHolder.getContext().getAuthentication().getName());
        resDTO.setUsername(userEntity.getUsername());
        resDTO.setName(userEntity.getName());
        resDTO.setEmail(userEntity.getEmail());
        RestWrapper resWrapper = new RestWrapper();
        resWrapper.setResponse(resDTO);

        return resWrapper;
    }
}
