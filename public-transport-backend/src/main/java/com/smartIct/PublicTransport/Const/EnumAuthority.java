package com.smartIct.PublicTransport.Const;

import lombok.Getter;

import java.util.Arrays;
@Getter
public enum EnumAuthority {



    USER_CREATE(1, "VEHICLE_READ"),
    USER_READ(2, "VEHICLE_READ"),
    USER_UPDATE(3, "VEHICLE_READ"),
    USER_DELETE(4, "VEHICLE_READ"),


    VEHICLE_CREATE(5, "VEHICLE_READ"),
    VEHICLE_READ(6, "VEHICLE_READ"),
    VEHICLE_UPDATE(7, "VEHICLE_READ"),
    VEHICLE_DELETE(8, "VEHICLE_READ"),





    STATION_CREATE(9, "VEHICLE_READ"),
    STATION_READ(10, "VEHICLE_READ"),
    STATION_UPDATE(11, "VEHICLE_READ"),
    STATION_DELETE(12, "VEHICLE_READ"),


    ROUTE_CREATE(13, "VEHICLE_READ"),
    ROUTE_READ(14, "VEHICLE_READ"),
    ROUTE_UPDATE(15, "VEHICLE_READ"),
    ROUTE_DELETE(16, "VEHICLE_READ");



    EnumAuthority(int index, String name) {
        this.index = index;
        this.name = name;
    }

    private final int index;
    private final String name;




}
