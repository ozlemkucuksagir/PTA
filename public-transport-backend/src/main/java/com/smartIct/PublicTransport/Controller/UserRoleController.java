package com.smartIct.PublicTransport.Controller;

import com.smartIct.PublicTransport.DTO.UserRoleDto;
import com.smartIct.PublicTransport.Entity.User;
import com.smartIct.PublicTransport.Entity.UserRole;
import com.smartIct.PublicTransport.Service.UserRoleService;
import com.smartIct.PublicTransport.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    UserRoleService userRoleService;

    public UserRoleController(  UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }


    @GetMapping("/read")
    public List<UserRole> getALlUserRole() {
        return userRoleService.getAllUserRoles();

    }

    @GetMapping("/readDto")
    public List<UserRoleDto> getALlUserRoleDto() {
        return userRoleService.getAllUserRolesDto();

    }


    @GetMapping("/readById/{id}")
    public UserRole getUserRoleById( @PathVariable Long id) {
        return userRoleService.getUserRolesById(id);

    }
    @GetMapping("/readByUserId/{user_id}")
    public List<UserRole> getUserRoleByUserId( @PathVariable Long user_id) {

        List<UserRole> sss= userRoleService.getUserRolesByUserId(user_id);
        return sss;

    }

    //(@PermissionT())
    @PostMapping("/createDto")
    public void createUserRole(@RequestBody UserRoleDto new_userRoleDto) {
        userRoleService.createUserRolesDTO(new_userRoleDto);
    }

    @PutMapping("/update/{id}")
    public void updateUserRole(@RequestBody UserRole new_userRole, @PathVariable Long id) {

        userRoleService.updateUserRoles(new_userRole, id);
    }
    @PutMapping("/updateDto/{id}")
    public void updateUserRolesDTO(@RequestBody UserRoleDto new_userRoleDto, @PathVariable Long id) {
         userRoleService.updateUserRolesDTO(new_userRoleDto,id);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRoles(id);
    }
}
