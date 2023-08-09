package com.smartIct.PublicTransport.Service;


import com.smartIct.PublicTransport.DAO.VehicleDAO;
import com.smartIct.PublicTransport.DTO.VehicleDto;
import com.smartIct.PublicTransport.Entity.Vehicle;
import com.smartIct.PublicTransport.Exception.NullPlateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleService {
    @Autowired
    private VehicleDAO daoVehicle;

    public VehicleService(VehicleDAO daoVehicle) {
        this.daoVehicle = daoVehicle;
    }


    public List<Vehicle> getAllVehicles() {
        return daoVehicle.findAll();
    }

    public Vehicle getVehiclesById(Long id) {


        return daoVehicle.findById(id).get();
    }

    public void createVehicle(Vehicle new_vehicle) {
        if (new_vehicle == null) {

            System.out.println("New vehicle information is blank.");
            return;
        }

        try {
            if (new_vehicle.getPlate() == null || new_vehicle.getPlate().isEmpty())
                throw new NullPlateException();
        } catch (NullPlateException ex) {
            System.err.println("ERROR:" + ex.getMessage());
            return;

        }


        daoVehicle.save(new_vehicle);

    }

    public void createVehicleDTO(VehicleDto new_vehicleDTO) {
        if (new_vehicleDTO == null) {

            System.out.println("New vehicle information is blank.");
            return;
        }

        try {
            if (new_vehicleDTO.getPlate() == null || new_vehicleDTO.getPlate().isEmpty())
                throw new NullPlateException();
        } catch (NullPlateException ex) {
            System.err.println("ERROR:" + ex.getMessage());
            return;

        }
        Vehicle vehicle  = new Vehicle();
        vehicle.setPlate(new_vehicleDTO.getPlate());
        vehicle.setId(new_vehicleDTO.getId());
        vehicle.setColor(new_vehicleDTO.getColor());
        vehicle.setBrand(new_vehicleDTO.getBrand());

        daoVehicle.save(vehicle);

    }

    public void updateVehicle(Vehicle update_vehicle, Long id) {
        Vehicle vehicle;
        //getByIdVehicles
        vehicle = daoVehicle.findById(id).get();
        //post
        vehicle.setId(update_vehicle.getId());
        vehicle.setPlate(update_vehicle.getPlate());
        vehicle.setColor(update_vehicle.getColor());
        vehicle.setBrand(update_vehicle.getBrand());
        //save
        daoVehicle.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        daoVehicle.deleteById(id);

    }





}
