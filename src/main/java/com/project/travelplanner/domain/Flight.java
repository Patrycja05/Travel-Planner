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
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @Column(name = "FLIGHT_ID")
    private Long flightId;

    @Column(name = "FLIGHT_DIRECTION")
    @NotNull
    private String flightDirection;

    @Column(name = "FLIGHT_DATE")
    @NotNull
    private LocalDate flightDate;

    @Column(name = "FLIGHT_TIME")
    @NotNull
    private LocalTime flightTime;

    @Column(name = "FLIGHT_STARTING_POINT")
    @NotNull
    private String flightStartingPoint;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public Flight(Long flightId, String flightDirection, LocalDate flightDate, LocalTime flightTime) {
        this.flightId = flightId;
        this.flightDirection = flightDirection;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
    }
}
