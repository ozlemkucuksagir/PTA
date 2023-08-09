package com.smartIct.PublicTransport.Const;
/*
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RoleAuthorityMapper {
    // RoleEnum ve AuthorityEnum arasındaki eşleştirmeyi gerçekleştiren metot
    public static Map<EnumDefaultRoles, List<EnumAuthority>> getRoleAuthorityMap() {
        Map<EnumDefaultRoles, List<EnumAuthority>> roleAuthorityMap = new EnumMap<>(EnumDefaultRoles.class);

        roleAuthorityMap.put(EnumDefaultRoles.STANDART, List.of(EnumAuthority.STANDART_CREAT, EnumAuthority.GUEST_READ));
        roleAuthorityMap.put(EnumDefaultRoles.ADMIN, List.of(
                EnumAuthority.ADMIN_CREAT,
                EnumAuthority.ADMIN_READ,
                EnumAuthority.ADMIN_UPDATE,
                EnumAuthority.ADMIN_DELETE
        ));
        roleAuthorityMap.put(EnumDefaultRoles.GUEST, List.of(EnumAuthority.GUEST_READ));

        return roleAuthorityMap;
    }

    // RoleEnum'e göre ilgili yetkileri elde etmek için kullanılan metot
    public static List<EnumAuthority> getAuthoritiesForRole(EnumDefaultRoles role) {
        Map<EnumDefaultRoles, List<EnumAuthority>> roleAuthorityMap = getRoleAuthorityMap();
        return roleAuthorityMap.getOrDefault(role, List.of());
    }
}
*/