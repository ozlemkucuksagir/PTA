package com.smartIct.PublicTransport.Controller;

import com.smartIct.PublicTransport.DAO.UserRepository;
import com.smartIct.PublicTransport.Entity.User;
import com.smartIct.PublicTransport.Entity.Vehicle;
import com.smartIct.PublicTransport.Service.VehicleService;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    VehicleService vehicleService;
    private UserRepository userRepository;

    VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;

    }

    @GetMapping("/read")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }


    @GetMapping("/read/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {

        return vehicleService.getVehiclesById(id);
    }

    @PostMapping("/create")
    public void creatVehicle(@RequestBody Vehicle new_vehicle) {

            vehicleService.createVehicle(new_vehicle);

    }

    @PutMapping("/update/{id}")
    public void updateVehicle(@RequestBody Vehicle new_vehicle, @PathVariable Long id) {
        vehicleService.updateVehicle(new_vehicle, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);

    }
}
