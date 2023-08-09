package com.smartIct.PublicTransport.DTO;

import com.smartIct.PublicTransport.Entity.Role;
import com.smartIct.PublicTransport.Entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDto {

    private Long id;

    private Long user_id;

    private Role role;



}
