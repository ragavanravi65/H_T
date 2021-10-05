package com.ht.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ht.dtos.UserDto;
import com.ht.services.UserService;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> findUsers(){
        return userService.findUsers();
    }

    @GetMapping("{id}")
    public UserDto findUserById(@PathVariable int id){
        return userService.findById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteUserById(@PathVariable int id){
        return userService.deleteById(id);
    }

    @PostMapping
    public boolean addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }
    
    @GetMapping("/city/{cityName}")
    public List<UserDto> findUsersByCity(@PathVariable String cityName){
        return userService.findUsersByCity(cityName);
    }
}
