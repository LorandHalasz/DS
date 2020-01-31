package com.example.springdemo.controller;

import com.example.springdemo.dto.LoginUserDTO;
import com.example.springdemo.dto.UserViewDTO;
import com.example.springdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping()
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity loginUser(@RequestBody LoginUserDTO loginUserDTO){
        UserViewDTO userViewDTO = userService.loginUser(loginUserDTO.getUsername(), loginUserDTO.getPassword());

        return new ResponseEntity<>(userViewDTO, null, HttpStatus.OK);
    }

}
