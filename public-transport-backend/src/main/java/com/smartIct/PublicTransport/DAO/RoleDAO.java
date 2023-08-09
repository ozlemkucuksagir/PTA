package com.smartIct.PublicTransport.DAO;

import com.smartIct.PublicTransport.Entity.Role;
import com.smartIct.PublicTransport.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends  JpaRepository<Role,Long> {
    public Role findByName(String name);
}
