package com.smartIct.PublicTransport.Controller;

import com.smartIct.PublicTransport.DAO.StationDAO;
import com.smartIct.PublicTransport.Entity.Station;
import com.smartIct.PublicTransport.Entity.Vehicle;
import com.smartIct.PublicTransport.Service.StationService;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class StationControllerTest {
    StationDAO stationDAO;
    Vehicle vehicle = new Vehicle();

    @Test
    void getALlStation() {
        StationDAO stationDAO = mock(StationDAO.class);

        List<Station> expectedStations = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        expectedStations.add(new Station(1L, "bus1", vehicle));//todo düzenle vehicle
        expectedStations.add(new Station(2L, "bus2", vehicle));

        when(stationDAO.findAll()).thenReturn(expectedStations);

        StationService stationService = new StationService(stationDAO);


        List<Station> actualStations = stationService.getAllStation();


        assertThat(actualStations).isEqualTo(expectedStations);
    }

    @Test
    void getStationById() {
        StationDAO stationDAO = mock(StationDAO.class);

        // Create a new Station with the ID you want to test
        long stationId = 111L;
        Station expectedStation = new Station(111L, "bus", vehicle);
        // Setup the mock behavior for findById method
        when(stationDAO.findById(stationId)).thenReturn(java.util.Optional.of(expectedStation));
        StationService stationService = new StationService(stationDAO);
        Station actualStation = stationService.getStationById(stationId);
        assertThat(actualStation).isEqualTo(expectedStation);
        //serviceStation.getStationById(stationId);
    }

    @Test
    void createStation() {
        // Mock DAOStation
        StationDAO stationDAO = mock(StationDAO.class);

        // Create a new Station
        Station newStation = new Station(1L, "bus", vehicle);


        // Create the ServiceStation with the real DAOStation
        StationService stationService = new StationService(stationDAO);
        when(stationDAO.save(any(Station.class))).thenReturn(newStation);
        // Call createStation method and verify that save method is called with the correct Station object
        stationService.createStation(newStation);
        verify(stationDAO).save(newStation);

    }

    @Test
    void updateStation() {
        StationDAO stationDAO = mock(StationDAO.class);
        Long stationID = 111L;
        StationService stationService = new StationService(stationDAO);
        Station current_station = new Station(stationID, "bus", vehicle);
        Station excepted_station = new Station(stationID, "bus", vehicle);
        when(stationDAO.findById(stationID)).thenReturn(Optional.of(excepted_station));
        stationService.updateStation(excepted_station, stationID);
        verify(stationDAO).save(excepted_station);
    }

    @Test
    void deleteStation() {

        StationDAO stationDAO = mock(StationDAO.class);
        Long stationID = 111L;
        StationService stationService = new StationService(stationDAO);
        stationDAO.deleteById(stationID);
        verify(stationDAO).deleteById(stationID);

    }
}