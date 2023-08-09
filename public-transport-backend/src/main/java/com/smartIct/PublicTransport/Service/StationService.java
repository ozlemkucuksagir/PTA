package com.smartIct.PublicTransport.Service;

import com.smartIct.PublicTransport.DAO.StationDAO;
import com.smartIct.PublicTransport.DTO.StationDto;
import com.smartIct.PublicTransport.Entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    @Autowired
    StationDAO stationDAO;

   public StationService(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }


    public List<Station> getAllStation() {
        return stationDAO.findAll();

    }

    public Station getStationById(Long id) {
        return stationDAO.findById(id).get();
    }

    public void createStation(Station new_station) {
        stationDAO.save(new_station);

    }


    public void createStationDTO(StationDto new_stationDto) {

       Station station= new Station();
       station.setVehicle(new_stationDto.getVehicle());
       station.setId(new_stationDto.getId());
       station.setName(new_stationDto.getName());
        stationDAO.save(station);

    }

    public void updateStation(Station update_station, Long id) {
        //getStationById
        Station station;
        station = stationDAO.findById(id).get();
        //update
        station.setId(update_station.getId());
        station.setName(update_station.getName());
        station.setVehicle(update_station.getVehicle());
        //save
        stationDAO.save(station);
    }
    public void updateStationDTO(StationDto update_stationDto, Long id) {
        //getStationById
        Station station;
        station = stationDAO.findById(id).get();
        //update
        station.setId(update_stationDto.getId());
        station.setName(update_stationDto.getName());
        station.setVehicle(update_stationDto.getVehicle());
        //save
        stationDAO.save(station);
    }

    public void deleteStation(Long id) {

        stationDAO.deleteById(id);
    }
}
