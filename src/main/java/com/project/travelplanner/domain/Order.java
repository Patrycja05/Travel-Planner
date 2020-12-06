package com.project.travelplanner.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "USER_ID_1")
    @NotNull
    private Long userId;

    @Column(name = "ACCOMMODATION_ID")
    @NotNull
    private Long accommodationId;

    @Column(name = "FLIGHT_ID")
    @NotNull
    private Long flightId;

    @OneToMany(
            targetEntity = Flight.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Flight> flightsList = new ArrayList<>();

    @OneToMany(
            targetEntity = Accommodation.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Accommodation> accommodationsList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Order(Long orderId, Long userId, Long accommodationId, Long flightId) {
        this.orderId = orderId;
        this.userId = userId;
        this.accommodationId = accommodationId;
        this.flightId = flightId;
    }
}
