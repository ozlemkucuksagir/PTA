package com.smartIct.PublicTransport.Controller;

import com.smartIct.PublicTransport.DAO.UserRepository;
import com.smartIct.PublicTransport.Entity.Route;
import com.smartIct.PublicTransport.Service.RouteService;
import com.smartIct.PublicTransport.Service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {
    RouteService serviceRoute;
    UserService userService;

    UserRepository userRepository;

    public RouteController(RouteService serviceRoute, UserService userService) {
        this.serviceRoute = serviceRoute;
        this.userService = userService;
    }

    @GetMapping("/read")
    @PreAuthorize("hasAuthority('ADMIN_READ')") // Sadece "ADMIN_READ" yetkisine sahip kullanıcılar erişebilir
    public List<Route> getAllRoutes() {


        return serviceRoute.getAllRoutes();
    }

   /* @GetMapping("/route")
    @PreAuthorize("hasAuthority('ADMIN_READ')")
    public List<Route> getAllRoutes() {


        // Rol isimlerine "ROLE_" ön ekini ekleyin
        if (!RoleEnum.valueOf(userService.getRole()).hasPermission("read")) {
            System.err.println("You are not authorized to perform this operation.");
            throw new AccessDeniedException("You are not authorized to perform this operation.");
        }
        /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var role = authentication.getAuthorities();
        System.out.println(role);

       if (!Role.valueOf(role).hasPermission("read")) {
            throw new AccessDeniedException("You are not authorized to perform this operation.");
        }
        return serviceRoute.getAllRoutes();

    }*/


    @GetMapping("/read/{id}")
    public Route getRouteById(@PathVariable Long id) {
        return serviceRoute.getRouteByID(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN_CREAT')")
    public void createRoute(@RequestBody Route new_route) {
        serviceRoute.creatRoute(new_route);
    }

    @PutMapping("/update/{id}")
    public void updateRoute(@RequestBody Route new_route, @PathVariable Long id) {
        serviceRoute.updateRoute(new_route, id);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoute(@PathVariable Long id) {
        serviceRoute.deleteRoute(id);

    }
}
