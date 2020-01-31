package com.example.springdemo.controller;


import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.UserViewDTO;
import com.example.springdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public UserViewDTO findById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @GetMapping(value = "/findAll")
    public List<UserViewDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/findAllCaregivers")
    public List<UserViewDTO> findAllCaregivers(){
        return userService.findAllCaregivers();
    }

    @PostMapping(value = "/insertCaregiver")
    public Integer insertUserDTO(@RequestBody UserDTO userDTO){
        return userService.insert(userDTO);
    }

    @PutMapping(value = "/updateCaregiver")
    public Integer updateUser(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping(value = "/deleteCaregiver/{username}")
    public void delete(@PathVariable("username") String username){
        userService.delete(username);
    }
}
