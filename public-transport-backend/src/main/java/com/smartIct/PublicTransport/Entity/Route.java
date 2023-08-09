package com.smartIct.PublicTransport.Entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "route")
public class Route {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="time")
    private Long time;
    @ManyToOne
    @JoinColumn(name = "station_id") // vehicle_id alanı ile ilişkilendir
    private Station station;
  /*  @Column(name="station_id")
    private Long stationId;*/


}
