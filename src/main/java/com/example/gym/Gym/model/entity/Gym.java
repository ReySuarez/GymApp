package com.example.gym.Gym.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class Gym {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private int numSalas;
    private double precio;
    private int valoracion;
}
