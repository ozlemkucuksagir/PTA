package com.smartIct.PublicTransport.DTO;


import com.smartIct.PublicTransport.Entity.Vehicle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StationDto {


    private Long id;

    private String name;

    private Vehicle vehicle;

}
