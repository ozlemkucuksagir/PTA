package com.smartIct.PublicTransport.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_role")
public class UserRole {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    //@JsonBackReference
    User user;
    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "role_id")
    //@JsonBackReference
    Role role;








}
