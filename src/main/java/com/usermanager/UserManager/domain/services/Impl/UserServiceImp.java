package com.usermanager.UserManager.domain.services.Impl;

import com.usermanager.UserManager.domain.dto.CreateUserDto;
import com.usermanager.UserManager.domain.dto.UpdateUserDto;
import com.usermanager.UserManager.domain.dto.UserViewDto;
import com.usermanager.UserManager.domain.exeptions.AllException;
import com.usermanager.UserManager.domain.models.User;
import com.usermanager.UserManager.domain.services.UserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {

    public static ArrayList<User> listUser = new ArrayList<>();
    @Override
    public User createUser(CreateUserDto user) {

        for (User userConsult : listUser) {

            if(user.getUserName().equals(userConsult.getUserName())){
                throw new AllException("Já existe um usuário com esse nome de usuário");
            }
            if(user.getEmail().equals(userConsult.getEmail())){
                throw new AllException("Email já existe.");
            }
        }

        User newUser = new User();
        newUser.setId(listUser.size()+1);
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());


        listUser.add(newUser);
        return newUser;
    }

    @Override
    public UpdateUserDto updateUser(UpdateUserDto userUpdate, Integer id) {

        if(getById(id).getUserName() == null){
            throw new AllException("Usuário não existe.");
        }else{
            listUser.get(id-1).setUserName(userUpdate.getUserName());
            listUser.get(id-1).setEmail(userUpdate.getEmail());
            listUser.get(id-1).setPassword(userUpdate.getPassword());
            listUser.get(id-1).setName(userUpdate.getName());
            return  userUpdate;
        }

    }

    @Override
    public void deleteUser(Integer id) {
        if(getById(id).getUserName() == null){
            throw new AllException("Usuário não existe.");
        }else{
            listUser.remove(id - 1);
        }
    }

    @Override
    public ArrayList<UserViewDto> listUsers() {
        ArrayList listViewActivity = new ArrayList();

        for (User user : listUser) {
            UserViewDto userViewDto = new UserViewDto();
            userViewDto.setUserName(user.getUserName());
            userViewDto.setEmail(user.getEmail());
            userViewDto.setName(user.getName());
            listViewActivity.add(userViewDto);
        }
        return listViewActivity;
    }

    @Override
    public UserViewDto getById(Integer id) {
        UserViewDto userViewDto = new UserViewDto();
        for (User user : listUser) {
            if(user.getId() == id){
                userViewDto.setUserName(user.getUserName());
                userViewDto.setEmail(user.getEmail());
                userViewDto.setName(user.getName());
            }

        }
        if(userViewDto.getUserName() != null){
            return userViewDto;
        }else{
             throw new AllException("Usuário não existe.");
        }

    }

}
