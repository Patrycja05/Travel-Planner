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
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "USER_ID")
    @NotNull
    private Long userId;

    @Column(name = "ACCOMMODATION_ID")
    @NotNull
    private Long accommodationId;

    @Column(name = "FLIGHT_ID")
    @NotNull
    private Long flightId;
}
