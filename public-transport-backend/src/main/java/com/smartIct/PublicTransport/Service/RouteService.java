package com.smartIct.PublicTransport.Service;

import com.smartIct.PublicTransport.DAO.RouteDAO;
import com.smartIct.PublicTransport.DTO.RouteDto;
import com.smartIct.PublicTransport.Entity.Route;
import com.smartIct.PublicTransport.Entity.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    RouteDAO routeDAO;

    RouteService(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }


    public List<Route> getAllRoutes() {

        return routeDAO.findAll();
    }

    public Route getRouteByID(Long id) {
        return routeDAO.findById(id).get();

    }

    public void creatRoute( Route new_route) {
        routeDAO.save(new_route);

    }

    public void creatRouteDTO( RouteDto new_routeDto) {
        Route route= new Route();
        route.setStation(new_routeDto.getStation());
        route.setId(new_routeDto.getId());
        route.setTime(new_routeDto.getTime());
        routeDAO.save(route);

    }

    public void updateRoute(Route update_route, Long id) {
        Route route;
        //getRouteByID
        route = routeDAO.findById(id).get();

        //update
        route.setId(route.getId());
        route.setTime(route.getTime());
        route.setStation(update_route.getStation());
        //save
        routeDAO.save(route);

    }

    public void updateRouteDTO(RouteDto update_routeDto, Long id) {
        Route route;
        //getRouteByID
        route = routeDAO.findById(id).get();

        //update
        route.setId(update_routeDto.getId());
        route.setTime(update_routeDto.getTime());
        route.setStation(update_routeDto.getStation());
        //save
        routeDAO.save(route);

    }

    public void deleteRoute(Long id) {
        routeDAO.deleteById(id);

    }
}
