package com.smartIct.PublicTransport.Const.Enums;

import lombok.Getter;

import java.util.Arrays;
@Getter
public enum EnumAuthority {



    USER_CREATE(1, "USER_CREATE"),
    USER_READ(2, "USER_READ"),
    USER_UPDATE(3, "USER_UPDATE"),
    USER_DELETE(4, "USER_DELETE"),


    VEHICLE_CREATE(5, "VEHICLE_CREATE"),
    VEHICLE_READ(6, "VEHICLE_READ"),
    VEHICLE_UPDATE(7, "VEHICLE_UPDATE"),
    VEHICLE_DELETE(8, "VEHICLE_DELETE"),





    STATION_CREATE(9, "STATION_CREATE"),
    STATION_READ(10, "STATION_READ"),
    STATION_UPDATE(11, "STATION_UPDATE"),
    STATION_DELETE(12, "STATION_DELETE"),


    ROUTE_CREATE(13, "ROUTE_CREATE"),
    ROUTE_READ(14, "ROUTE_READ"),
    ROUTE_UPDATE(15, "ROUTE_UPDATE"),
    ROUTE_DELETE(16, "ROUTE_DELETE");



    EnumAuthority(int index, String name) {
        this.index = index;
        this.name = name;
    }

    private final int index;
    private final String name;




}
