package com.smartIct.PublicTransport.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartIct.PublicTransport.DAO.RoleDAO;
import com.smartIct.PublicTransport.DTO.RoleDto;
import com.smartIct.PublicTransport.Entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    RoleDAO roleDAO;

    RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }


    public List<Role> getAllRole()

    {
        return roleDAO.findAll();
    }

    public Role getRoleById(Long role_id){

        return roleDAO.findById(role_id).get();
    }
    public Role getRoleByName(String name){

        return roleDAO.findByName(name);
    }

    public void creatRole(Role new_role){
        roleDAO.save(new_role);

    }
    public void creatRoleDTO(RoleDto new_roleDto){
        Role role=new Role();
        role.setId(new_roleDto.getId());
        role.setName(new_roleDto.getName());
        role.setDescription(new_roleDto.getDescription());
        String permissionString;
        try {
            permissionString = objectMapper.writeValueAsString(new_roleDto.getPermission());
            permissionString = permissionString.substring(1, permissionString.length() - 1);
            //  Encode the password
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        role.setPermission(permissionString);
        roleDAO.save(role);

    }
    public void deleteRole(Long role_id){
        roleDAO.deleteById(role_id);

    }

    public void updateRole(Role update_role, Long role_id){
        Role role;

        role=roleDAO.findById(role_id).get();

        role.setPermission(update_role.getPermission());
        role.setName(update_role.getName());
        role.setDescription(update_role.getName());

        roleDAO.save(role);


    }
}
