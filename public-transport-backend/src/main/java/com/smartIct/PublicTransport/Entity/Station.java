package com.smartIct.PublicTransport.Entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "station")
public class Station {


    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "vehicle_id") // vehicle_id alanı ile ilişkilendir
    private Vehicle vehicle;
   /* @Column(name = "vehicle_id")
    private Long vehicleId;*/

}
