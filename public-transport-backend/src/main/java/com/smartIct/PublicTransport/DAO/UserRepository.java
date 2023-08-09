package com.smartIct.PublicTransport.DAO;

import com.smartIct.PublicTransport.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<User,Long> {
   User findByUsername(String username);
}
