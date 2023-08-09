package com.smartIct.PublicTransport.Entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle {
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="plate")
    private String plate;
    @Column(name="color")
    private String color;
    @Column(name="brand")
    private String brand;

}
