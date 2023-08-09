package com.smartIct.PublicTransport.DTO;

import com.smartIct.PublicTransport.Entity.Station;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class RouteDto {

    private Long id;

    private Long time;

    private Station station;


}
