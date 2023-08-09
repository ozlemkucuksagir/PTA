package com.smartIct.PublicTransport.DAO;

import com.smartIct.PublicTransport.Entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDAO extends JpaRepository<Route,Long> {
}
