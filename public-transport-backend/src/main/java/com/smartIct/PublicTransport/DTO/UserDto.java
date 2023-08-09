package com.smartIct.PublicTransport.DTO;

import com.smartIct.PublicTransport.Entity.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class UserDto {



    Long id;

    String username;

    String password;


    List<Integer> permission;
     List<UserRole> userRoleList = new ArrayList<>();

    // String permissionString;


  //  RoleDTO roleEntity;


   /* @Transient
    public List<Integer> getIntegerListesi() {
        return Arrays.stream(permissionString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public String convertListToString(List<Integer> integerList) {
        return integerList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
    public void setIntegerListesi(List<Integer> integerListesi) {
        this.permissionString = String.join(",", integerListesi.stream()
                .map(String::valueOf)
                .collect(Collectors.toList()));
    }*/

   // RoleEnum roleEnum;


}
