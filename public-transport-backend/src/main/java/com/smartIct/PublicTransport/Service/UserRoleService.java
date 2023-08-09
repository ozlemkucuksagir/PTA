package com.smartIct.PublicTransport.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartIct.PublicTransport.DAO.RoleDAO;
import com.smartIct.PublicTransport.DAO.UserRepository;
import com.smartIct.PublicTransport.DAO.UserRoleRepository;
import com.smartIct.PublicTransport.DTO.UserRoleDto;
import com.smartIct.PublicTransport.Entity.Role;
import com.smartIct.PublicTransport.Entity.User;
import com.smartIct.PublicTransport.Entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleService roleService;
    @Autowired
    RoleDAO roleRepository;
    @Autowired
    UserRepository userRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;

    }

    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    public UserRole getUserRolesById(Long id) {


        return userRoleRepository.findById(id).get();
    }


    public List<UserRole> getUserRolesByUserId(Long id) {

        return userRoleRepository.findAllByUser_id(id);
    }


    /*

      public List<UserRole> getUserRolesByUserId(Long id) {


           return userRoleRepository.findUserRolesByUser_id(id);//find all yapılacak ama useridye göre
       }*/
    public void createUserRoles(UserRole new_userRole) {


        userRoleRepository.save(new_userRole);

    }


    public void createUserRolesDTO(UserRoleDto new_userRoleDto) {
        UserRole userRole = new UserRole();
        userRole.setId(new_userRoleDto.getId());
        userRole.setRole(new_userRoleDto.getRole());
        userRole.setUser(userRepository.findById(new_userRoleDto.getUser_id()).get());


        userRoleRepository.save(userRole);

    }


    public void updateUserRoles(UserRole update_userRole, Long id) {
        UserRole userRole;
        //getByIdVehicles
        userRole = userRoleRepository.findById(id).get();
        //post
        userRole.setId(update_userRole.getId());
        userRole.setUser(update_userRole.getUser());
        userRole.setRole(update_userRole.getRole());


        //save
        userRoleRepository.save(userRole);
    }

    public void updateUserRolesDTO(UserRoleDto update_userRoleDto, Long id) {
        UserRole userRole;

        userRole = userRoleRepository.findById(id).get();
        //post
        userRole.setId(update_userRoleDto.getId());
        userRole.setUser(userRepository.findById(update_userRoleDto.getUser_id()).get());

        Optional<Role> existingRole = roleRepository.findById(update_userRoleDto.getRole().getId());
        if (existingRole.isPresent()) {
            userRole.setRole(update_userRoleDto.getRole());
        } else {
            roleService.creatRole(update_userRoleDto.getRole());
        }


        //save
        userRoleRepository.save(userRole);
    }

    public void deleteUserRoles(Long id) {
        userRoleRepository.deleteById(id);

    }


    public UserRoleDto EntitytoDTOUserRole(UserRole userRole) {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setId(userRole.getId());
        userRoleDto.setUser_id(userRole.getUser().getId());
        userRoleDto.setRole(userRole.getRole());
        var user = userRole.getUser();
        user.setUserRoleList(null);
        userRoleDto.setUser_id(userRole.getUser().getId());
        return userRoleDto;

    }

    public List<UserRoleDto> getAllUserRolesDto() {
        List<UserRole> userRoles = getAllUserRoles();
        List<UserRoleDto> userDtos = new ArrayList<>();

        for (UserRole userRole : userRoles) {

            // Diğer alanları buraya ekleyebilirsiniz

            userDtos.add(EntitytoDTOUserRole(userRole));
        }
        return userDtos;

    }
}
