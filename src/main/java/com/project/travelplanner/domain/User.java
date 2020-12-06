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
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    @NotNull
    private String name;

    @Column(name = "PHONE_NUMBER")
    @NotNull
    private int phoneNumber;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orderList = new ArrayList<>();

    public User(Long id, String name, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
