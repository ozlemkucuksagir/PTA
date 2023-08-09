package com.smartIct.PublicTransport.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.smartIct.PublicTransport.DAO.UserRepository;

import com.smartIct.PublicTransport.DTO.UserDto;

import com.smartIct.PublicTransport.Entity.User;

import com.smartIct.PublicTransport.Entity.UserRole;
import com.smartIct.PublicTransport.Security.Config.WebSecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("inMemoryUserDetailsManager")
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WebSecurityConfig webSecurityConfig;
    @Autowired
    UserRoleService userRoleService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserService(UserRepository userRepository
    ) {

        this.userRepository = userRepository;


    }

    public User DTOtoEntityUser(UserDto userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        String permissionString;
        try {
            permissionString = objectMapper.writeValueAsString(userDTO.getPermission());
            permissionString = permissionString.substring(1, permissionString.length() - 1);
            //  Encode the password
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        user.setPermission(permissionString);

        return user;


    }


    public UserDto EntitytoDTOUser(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        var userRoleList=user.getUserRoleList();
        if (userRoleList != null) {
            userRoleList.forEach(userRole -> userRole.setUser(null));
/*            userRoleList.forEach(UserRole::get);
            userRoleList.forEach(userRole -> userRole.get);*/
        }
        userDTO.setUserRoleList(userRoleList);
        List<Integer> permissionList;
        String permissionJson = "[" + user.getPermission() + "]";
        try {
            permissionList = objectMapper.readValue(permissionJson, new TypeReference<List<Integer>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Error converting permission to List<Integer>: " + e.getMessage());
        }
        userDTO.setPermission(permissionList);

        return userDTO;


    }

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public List<UserDto> getAllUsersDto() {
        List<User> users = getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {

            // Diğer alanları buraya ekleyebilirsiniz

            userDtos.add( EntitytoDTOUser(user));
        }
        return userDtos;
    }



    public User getUserById(Long id) {
      /*   User user = userRepository.findById(id).get();//todo bu user için test silinecek bu
        System.out.println(user);
       System.out.println(user.getIntegerListesi());
        System.out.println(user.convertListToString(user.getIntegerListesi()));*/

        return userRepository.findById(id).get();
    }


    public User getUserByUsername(String username) {
      /*   User user = userRepository.findById(id).get();//todo bu user için test silinecek bu
        System.out.println(user);
       System.out.println(user.getIntegerListesi());
        System.out.println(user.convertListToString(user.getIntegerListesi()));*/

        return userRepository.findByUsername(username);
    }
   /* public User findByUsername(String username) {



        User user = userRepository.findByUsername(username);

        return user;
    }/*/

    public void createUser(User new_user) {

        if (new_user == null) {

            System.out.println("New user information is blank.");
            return;
        }

        String rawPassword = new_user.getPassword(); // Kullanıcının girdiği şifre (düz metin)
        String encodedPassword = webSecurityConfig.passwordEncoder().encode(rawPassword); // Sifreyi hashle (kodla)

        new_user.setPassword(encodedPassword); // Hashlenmiş şifreyi kullanıcı nesnesine set et

        userRepository.save(new_user);

    }


    public void createUserDto(UserDto new_userDto) {

        if (new_userDto == null) {

            System.out.println("New user information is blank.");
            return;
        }

        String rawPassword = new_userDto.getPassword(); // Kullanıcının girdiği şifre (düz metin)
        String encodedPassword = webSecurityConfig.passwordEncoder().encode(rawPassword); // Sifreyi hashle (kodla)

        new_userDto.setPassword(encodedPassword); // Hashlenmiş şifreyi kullanıcı nesnesine set et


        userRepository.save(DTOtoEntityUser(new_userDto));

    }
    public void createUserDTO(UserDto userDTO) {
        // UserDTO'dan User entity'sine dönüştürme
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        // ObjectMapper ile List<Integer>'ı String'e dönüşümü gerçekleştirme
        String permissionString;
        try {
            permissionString = objectMapper.writeValueAsString(userDTO.getPermission());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting permission list to String: " + e.getMessage());
        }

        user.setPermission(permissionString);
        // Diğer alanları da doldurun...

        userRepository.save(user);
    }

    public void updateUser(User update_user, Long id) {
        //getUserById
        User user;
        user = userRepository.findById(id).get();
        //update
        user.setId(update_user.getId());
        user.setUsername(update_user.getUsername());
        user.setPassword(update_user.getPassword());
        user.setPermission(update_user.getPermission());


        //saved
        userRepository.save(user);
    }

    public void updateUserDTO(UserDto update_userDto, Long id) {
        //getUserById
        User user;
        user = userRepository.findById(id).get();
        //update
        user.setId(update_userDto.getId());
        user.setUsername(update_userDto.getUsername());
        user.setPassword(update_userDto.getPassword());

        // EntitytoDTO(update_userDto);
        String permissionString;
        try {
            permissionString = objectMapper.writeValueAsString(update_userDto.getPermission());
            permissionString = permissionString.substring(1, permissionString.length() - 1);
            //  Encode the password
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        user.setPermission(permissionString);


        //saved
        userRepository.save(user);
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

   /* public List<UserRole> getUserRolesbyId(Long id) {
        System.out.println(userRoleService.getUserRolesByUserId(id));
        return userRoleService.getUserRolesByUserId(id);

    }*/

    /*
        public String getRole() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            User user = findByUsername(username);
            String role = user.getRoleName();
            return role;
        }*/
    @Transactional
    public List<UserRole> getUserRolesbyId(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found with ID: " + id);
        }

        List<UserRole> userRoles = user.getUserRoleList();//todo yorum satırlarını aç user altına userrole gelcek onun altındaki user null olcak recursive olmasın diye
     /*   Hibernate.initialize(userRoles);
        List<UserRoleDTO> userRoleDTOs = new ArrayList<>();

        for (UserRole userRole : userRoles) {
            UserRoleDTO userRoleDTO = new UserRoleDTO();
            userRoleDTO.setId(userRole.getId());
            userRoleDTO.setUser(user);
            userRoleDTO.setRole(userRole.getRole());
            // Diğer alanları buraya ekleyebilirsiniz

            userRoleDTOs.add(userRoleDTO);
        }
    System.out.println(userRoleDTOs.get(0).getRole().getPermission());*/

        return userRoles;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {

            return new org.springframework.security.core.userdetails.User(username,
                    user.getPassword(),
                    new ArrayList<>());
        } else {
            System.err.println("hata");
            throw new UsernameNotFoundException("User not found with username: " + username);

        }
    }


    public UserDto getUserByIdDTO(Long id) {
        User user = userRepository.findById(id).get();

        // ObjectMapper ile String'den List<Integer>'a dönüşümü gerçekleştirme
        List<Integer> permissionList;
        String permissionJson = "[" + user.getPermission() + "]";
        try {
            permissionList = objectMapper.readValue(permissionJson, new TypeReference<List<Integer>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Error converting permission to List<Integer>: " + e.getMessage());
        }

        // UserDTO'yu oluşturma ve çevrilmiş permission'ı set etme
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setPermission(permissionList);
        // Diğer alanları da doldurun...

        return userDTO;
    }


   /* public List<AuthorityEnum> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = findByUsername(username);

        RoleEnum role = user.getRoleEnum()

        return RoleAuthorityMapper.getAuthoritiesForRole(role);
    }*/
  /*  public List<String> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = getUserByUsername(username);

        Role role = user.getRoleEntity();
        String authority = role.getAuthority();

        // Virgülle ayrılmış yetki adlarını parçala ve liste haline getir
        List<String> authoritiesList = Arrays.asList(authority.split(","));

        return authoritiesList;
    }
*/
  /*  @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if (user.getUsername().equals(username)) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }*/
}
