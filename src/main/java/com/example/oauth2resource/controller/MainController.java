package com.example.oauth2resource.controller;


import com.example.oauth2resource.dto.ResDTO;
import com.example.oauth2resource.dto.RestWrapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/me")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public RestWrapper me(){
        ResDTO resDTO = new ResDTO();
        resDTO.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        RestWrapper resWrapper = new RestWrapper();
        resWrapper.setResponse(resDTO);

        return resWrapper;
    }
}
