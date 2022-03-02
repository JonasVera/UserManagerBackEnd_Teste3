package com.usermanager.UserManager.domain.services;

import com.usermanager.UserManager.domain.dto.CreateUserDto;
import com.usermanager.UserManager.domain.dto.UpdateUserDto;
import com.usermanager.UserManager.domain.dto.UserViewDto;
import com.usermanager.UserManager.domain.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {

    User createUser(CreateUserDto user);

    UpdateUserDto updateUser(UpdateUserDto userUpdate, Integer id);

    void deleteUser (Integer id);
    ArrayList<UserViewDto> listUsers();

    UserViewDto getById(Integer id);

}
