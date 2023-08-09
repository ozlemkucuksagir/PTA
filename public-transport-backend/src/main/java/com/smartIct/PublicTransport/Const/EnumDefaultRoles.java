package com.smartIct.PublicTransport.Const;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter


public enum EnumDefaultRoles {

    STANDART(1, "STANDART", "Standart User", getStandartRoleAuths()),
    ADMIN(2, "ADMIN", "Admin User", getAdminRoleAuths()),
    GUEST(3, "GUEST", "Guest User", getGuestRoleAuths());


    private final int authority;
    private final String name;
    private final String description;
    private final List<Integer> permissions;

    EnumDefaultRoles(int authority, String name, String description, List<Integer> permissions) {
        this.authority = authority;
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }

    // Role sınıfına yetki kontrolü eklemek için yeni bir metot


    public boolean hasPermission(String permission) {
        return this.getPermissions().contains(permission);
    }

    private static List<Integer> getGuestRoleAuths() {
        return Arrays.asList(
                EnumAuthority.VEHICLE_READ.getIndex(),
                EnumAuthority.STATION_READ.getIndex(),
                EnumAuthority.USER_READ.getIndex(),
                EnumAuthority.ROUTE_READ.getIndex()
        );
    }

    private static List<Integer> getStandartRoleAuths() {
        return Arrays.asList(
                EnumAuthority.VEHICLE_READ.getIndex(),
                EnumAuthority.STATION_READ.getIndex(),
                EnumAuthority.USER_READ.getIndex(),
                EnumAuthority.ROUTE_READ.getIndex(),

                EnumAuthority.VEHICLE_CREATE.getIndex(),
                EnumAuthority.STATION_CREATE.getIndex(),
                EnumAuthority.USER_CREATE.getIndex(),
                EnumAuthority.ROUTE_CREATE.getIndex());
    }


    private static List<Integer> getAdminRoleAuths() {
        return Arrays.stream(EnumAuthority.values()).map(f -> f.getIndex()).toList();
    }

}
