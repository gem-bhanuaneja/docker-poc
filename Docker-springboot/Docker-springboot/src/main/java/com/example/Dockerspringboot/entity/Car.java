package com.example.Dockerspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "car_name")
    private String name;

    @Column(name = "car_year")
    private Integer year;

    @Column(name = "car_color")
    private String color;

    @Column(name = "price")
    private Integer price;
}
