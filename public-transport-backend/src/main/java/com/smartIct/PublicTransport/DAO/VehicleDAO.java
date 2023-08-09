package com.smartIct.PublicTransport.DAO;

import com.smartIct.PublicTransport.Entity.User;
import com.smartIct.PublicTransport.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface VehicleDAO extends JpaRepository<Vehicle,Long> {

}
