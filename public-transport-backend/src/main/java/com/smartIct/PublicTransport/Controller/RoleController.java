package com.smartIct.PublicTransport.Controller;

import com.smartIct.PublicTransport.Entity.Role;
import com.smartIct.PublicTransport.Service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    RoleService roleService;

    RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/read")
    public List<Role> getAllRoles() {
        return roleService.getAllRole();
    }

    @GetMapping("/read/{role_id}")
    public Role getRoleById(@PathVariable Long role_id) {
        return roleService.getRoleById(role_id);
    }

    @PostMapping("/create")
    public void createRole(@RequestBody Role new_role) {
        roleService.creatRole(new_role);
    }

    @DeleteMapping("/delete/{role_id}")
    public void deleteRole(@PathVariable Long role_id) {
        roleService.deleteRole(role_id);

    }

    @PutMapping("/update/{id}")
    public void updateRole(@RequestBody Role update_role, @PathVariable Long role_id) {
        roleService.updateRole(update_role, role_id);
    }


}


