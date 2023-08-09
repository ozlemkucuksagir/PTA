package com.smartIct.PublicTransport.Entity;

import com.smartIct.PublicTransport.Const.IntegerListConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {


    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "permission")
   // @Convert(converter = IntegerListConverter.class)
    String permission;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<UserRole> userRoleList = new ArrayList<>();

    // String permissionString;

/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    Role roleEntity;*/




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
