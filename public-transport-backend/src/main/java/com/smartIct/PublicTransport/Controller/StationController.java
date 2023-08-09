package com.smartIct.PublicTransport.Controller;

import com.smartIct.PublicTransport.Entity.Station;
import com.smartIct.PublicTransport.Service.StationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {
    StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;


    }


    @GetMapping("/read")
    public List<Station> getALlStation() {
        XController asd = new XController();
        asd.setAsdf("12e123");
        return stationService.getAllStation();


    }

    @GetMapping("/read/{id}")
    public Station getStationById( @PathVariable  Long id) {
        return stationService.getStationById(id);

    }

    @PostMapping("/create")
    public void createStation(@RequestBody Station new_station) {
        stationService.createStation(new_station);
    }

    @PutMapping("/update/{id}")
    public void updateStation(@RequestBody Station new_station, @PathVariable Long id) {

        stationService.updateStation(new_station, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
    }

}
