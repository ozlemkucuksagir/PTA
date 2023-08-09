package com.smartIct.PublicTransport.Const;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartIct.PublicTransport.Const.Enums.EnumDefaultRoles;
import com.smartIct.PublicTransport.DAO.*;
import com.smartIct.PublicTransport.DTO.*;
import com.smartIct.PublicTransport.Entity.*;
import com.smartIct.PublicTransport.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SystemDefaultInit implements ApplicationRunner {
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    RoleDAO roleDAO;
    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleRepository userRoleDAO;
    @Autowired
    UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    EnumDefaultRoles enumDefaultRoles;

    @Value("${default.user.id}")
    Long userId;
    @Value("${default.user.username}")
    String username="admin";

    @Value("${default.user.password}")
    String password="admin123";

    @Value("${default.userrole.id}")
    Long userroleId;
    @Override
    public void run(ApplicationArguments onApplicationEvent) throws Exception {
        // Her açılışta çalışacak olan metot
        createDefaultRoles();
        createDefaultUser();
        createDefaultUserRole();

        // createUserRoleTable();

    }//onAPplicationEvent

    private void createDefaultUser() {
        // Eğer default kullanıcı zaten varsa işlemi tekrarlama
        Optional<User> existingVehicle = userRepository.findById(userId);
        if (existingVehicle.isPresent()) {
            return;
        }

        // Default user creat and save
        UserDto userDTO = new UserDto();
        userDTO.setId(userId);
        userDTO.setUsername(username);
        userDTO.setPassword(passwordEncoder.encode(password)); //  Encode the password
        userService.createUserDto(userDTO);

        //user roleleri setle

        userDTO.setPermission(EnumDefaultRoles.valueOf("ADMIN").getPermissions());//todo tüm bu rolelerin proportieslerini enumlardan çek


        userService.updateUserDTO(userDTO, userId);

    }

   /* public void createStudentsTable(String... args) throws Exception {
        String sql = "INSERT INTO students (name, email) VALUES ("
                + "'Özlem Küçüksağır', 'ozlem@smart.ict')";

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
    }*/
   /* public void createUserRoleTable(String... args) throws Exception {
        String sql = "INSERT INTO user_role (user_id,name) VALUES ("
                + "'1','kozi')";

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
    }
*/

    private void createDefaultRoles() {

        // Eğer default role zaten varsa işlemi tekrarlama
        if (roleService.getRoleByName(EnumDefaultRoles.valueOf("ADMIN").getName()) != null) {//todo name i enumlardan çek
            return;
        }

        // Default user creat and save
        RoleDto roleDTO = new RoleDto();
        String permissionString;
        roleDTO.setName(EnumDefaultRoles.valueOf("ADMIN").getName());
        roleDTO.setDescription(EnumDefaultRoles.valueOf("ADMIN").getDescription());
        roleDTO.setId(Long.valueOf(EnumDefaultRoles.valueOf("ADMIN").getAuthority()));
/*
        try {
            permissionString = objectMapper.writeValueAsString(EnumDefaultRoles.valueOf("ADMIN").getPermissions());
            permissionString = permissionString.substring(1, permissionString.length() - 1);


            /*permissionString = objectMapper.writeValueAsString(EnumDefaultRoles.valueOf("ADMIN").getPermissions().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(",")));//  Encode the password
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        */
        roleDTO.setPermission(EnumDefaultRoles.valueOf("ADMIN").getPermissions());//todo tüm bu rolelerin proportieslerini enumlardan çek

        roleService.creatRoleDTO(roleDTO);


    }

    private void createDefaultUserRole() {

        Optional<UserRole> existingVehicle = userRoleDAO.findById(userroleId);
        if (existingVehicle.isPresent()) {
            return;
        }


        // Default route creat and save
        UserRoleDto userRoleDTO = new UserRoleDto();
        userRoleDTO.setId(userroleId);


        User defaultUser = userRepository.findById(userId).orElse(null);
        userRoleDTO.setUser_id(defaultUser.getId());
     //   userRoleService.updateUserRolesDTO(userRoleDTO,userroleId);

        Role defaultRole = roleDAO.findById(EnumDefaultRoles.valueOf("ADMIN").getAuthority()).orElse(null);
        userRoleDTO.setRole(defaultRole);
       // userRoleService.updateUserRolesDTO(userRoleDTO,userroleId);
        userRoleService.createUserRolesDTO(userRoleDTO);

    }


}

@Component
class SystemDefaultInitTest implements ApplicationRunner {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    VehicleDAO vehicleDAO;
    @Autowired
    VehicleService vehicleService;
    @Value("${default.vehicle.id}")
    Long vehicleId;
    @Value("${default.vehicle.name}")
    String vehicleName;
    @Value("${default.vehicle.plate}")
    String vehiclePlate;
    @Value("${default.vehicle.color}")
    String vehicleColor;
    @Value("${default.vehicle.brand}")
    String vehicleBrand;

    @Autowired
    RouteDAO routeDAO;
    @Autowired
    RouteService routeService;
    @Value("${default.route.id}")
    Long routeId;
    @Value("${default.route.time}")
    Long routeTime;

    @Autowired
    StationDAO stationDAO;
    @Autowired
    StationService stationService;
    @Value("${default.station.id}")
    Long stationId;
    @Value("${default.station.name}")
    String stationName;


    @Override

    public void run(ApplicationArguments onApplicationEvent) throws Exception {
        createDefaultVehicle();
        createDefaultStation();
        createDefaultRoute();

    }


    private void createDefaultVehicle() {
        // Eğer default kullanıcı zaten varsa işlemi tekrarlama
        Optional<Vehicle> existingVehicle = vehicleDAO.findById(vehicleId);
        if (existingVehicle.isPresent()) {
            return;
        }

        // Default vehicle creat and save
        VehicleDto vehicleDTO = new VehicleDto();
        vehicleDTO.setId(vehicleId);
        vehicleDTO.setColor(vehicleColor);
        vehicleDTO.setBrand(vehicleBrand);
        vehicleDTO.setPlate(vehiclePlate);
        vehicleService.createVehicleDTO(vehicleDTO);


    }

    private void createDefaultRoute() {
        // Eğer default kullanıcı zaten varsa işlemi tekrarlama
        Optional<Route> existingRoute = routeDAO.findById(routeId);
        if (existingRoute.isPresent()) {
            return;
        }

        // Default route creat and save
        RouteDto routeDTO = new RouteDto();
        routeDTO.setId(routeId);
        routeDTO.setTime(routeTime);
        routeService.creatRouteDTO(routeDTO);

        Station defaultStation = stationDAO.findById(stationId).orElse(null);
        routeDTO.setStation(defaultStation);
        routeService.updateRouteDTO(routeDTO,routeId);


    }


    private void createDefaultStation() {
        // Eğer default kullanıcı zaten varsa işlemi tekrarlama
        Optional<Station> existingStation = stationDAO.findById(stationId);
        if (existingStation.isPresent()) {
            return;
        }

        // Default station creat and save
        StationDto stationDTO = new StationDto();
        stationDTO.setId(stationId);
        stationDTO.setName(stationName);
        stationService.createStationDTO(stationDTO);

        Vehicle defaultVehicle = vehicleDAO.findById(vehicleId).orElse(null);
        stationDTO.setVehicle(defaultVehicle);
        stationService.updateStationDTO(stationDTO,stationId);

    }

}
