package com.usermanager.UserManager.controllers;

import com.usermanager.UserManager.domain.dto.CreateUserDto;
import com.usermanager.UserManager.domain.dto.UpdateUserDto;
import com.usermanager.UserManager.domain.dto.UserViewDto;
import com.usermanager.UserManager.domain.models.User;
import com.usermanager.UserManager.domain.services.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/userManager")
@Validated
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public User createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return this.userService.createUser(createUserDto);
    }

    @PutMapping("{id}")
    public UpdateUserDto updateUser(@Valid @PathVariable Integer id, @RequestBody UpdateUserDto updateUser) {
        return this.userService.updateUser(updateUser,id);
    }


    @GetMapping()
    public ArrayList<UserViewDto> getAllUsers(){
        return this.userService.listUsers();
    }

    @GetMapping("{id}")
    public UserViewDto getById(@PathVariable Integer id){
        return this.userService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
          this.userService.getById(id);
    }
}
