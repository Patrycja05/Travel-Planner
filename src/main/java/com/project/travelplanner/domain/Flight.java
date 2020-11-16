package com.project.travelplanner.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
