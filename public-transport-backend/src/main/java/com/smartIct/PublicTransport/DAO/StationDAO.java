
package com.smartIct.PublicTransport.DAO;
import com.smartIct.PublicTransport.Entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationDAO extends JpaRepository<Station,Long> {
}
