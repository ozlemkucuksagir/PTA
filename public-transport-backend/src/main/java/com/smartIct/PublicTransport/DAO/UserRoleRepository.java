package com.smartIct.PublicTransport.DAO;



import com.smartIct.PublicTransport.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserRoleRepository  extends JpaRepository<UserRole,Long> {

   List <UserRole> findAllByUser_id(Long user_id);
}
