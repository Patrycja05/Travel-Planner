package com.project.travelplanner.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ACCOMMODATION")
public class Accommodation {

    @Id
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

    @Column(name = "DATE")
    @NotNull
    private LocalDate accommodationDate;

    @Column(name = "NUMBER_OF_PEOPLE")
    @NotNull
    private int numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public Accommodation(Long accommodationId, String name, String location, double price, boolean availability) {
        this.accommodationId = accommodationId;
        this.name = name;
        this.location = location;
        this.price = price;
        this.availability = availability;
    }
}
