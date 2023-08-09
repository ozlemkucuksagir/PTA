package com.smartIct.PublicTransport.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class RoleDto {



    private Long id;

    private String name;

    private String description;

    private List<Integer> permission;


}
