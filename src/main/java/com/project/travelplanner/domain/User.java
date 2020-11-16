package com.project.travelplanner.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    @NotNull
    private String name;

    @Column(name = "PHONE_NUMBER")
    @NotNull
    private int phoneNumber;

    @Column(name = "ORDER_ID_LIST")
    @NotNull
    private List<Long> orderIdList = new ArrayList<>();
}
