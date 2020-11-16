package com.project.travelplanner.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOMMODATION")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOMMODATION_ID")
    private Long accommodationId;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "LOCATION")
    @NotNull
    private String location;

    @Column(name = "PRICE")
    @NotNull
    private double price;

    @Column(name = "AVAILABILITY")
    @NotNull
    private boolean availability;
}
