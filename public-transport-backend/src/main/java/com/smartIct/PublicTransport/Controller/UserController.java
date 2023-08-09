package com.smartIct.PublicTransport.Controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartIct.PublicTransport.DTO.UserDto;
import com.smartIct.PublicTransport.DTO.UserRoleDto;
import com.smartIct.PublicTransport.Entity.User;

import com.smartIct.PublicTransport.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/read")
    public List<User> getALlUser() {
        return userService.getAllUsers();

    }  @GetMapping("/readDto")
    public List<UserDto> getALlUserDto() {
        List<UserDto>ss=userService.getAllUsersDto();
        return ss;
    }

    @GetMapping("/readById/{id}")
    public User getUserById( @PathVariable  Long id) {
        return userService.getUserById(id);

    }
    @GetMapping("/readUserRolesbyId/{id}")
    public List<UserRoleDto> getUserRoleDTObyId(@PathVariable  Long id) {
        List<UserRoleDto> ss =    new ObjectMapper().convertValue(userService.getUserRolesbyId(id), new TypeReference<List<UserRoleDto>>(){});

        return ss;
    }



   @GetMapping("/readByUsername/{username}")
    public User getUserByUsername( @PathVariable  String username) {
        return userService.getUserByUsername(username);

    }
//(@PermissionT())
    @PostMapping("/create")
    public void createUser(@RequestBody User new_user) {
        userService.createUser(new_user);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@RequestBody User new_user, @PathVariable Long id) {

        userService.updateUser(new_user, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    //DTO******************************


    @GetMapping("/readByIdDTO/{id}")
    public UserDto getUserByIdDTO(@PathVariable  Long id) {
        return userService.getUserByIdDTO(id);

    }

    @PostMapping("/createDTO")
    public void createUserDTO(@RequestBody UserDto new_userDto) {
        userService.createUserDto(new_userDto);
    }



}
