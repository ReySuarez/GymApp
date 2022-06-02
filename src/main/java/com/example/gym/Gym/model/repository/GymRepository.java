package com.example.gym.Gym.model.repository;

import com.example.gym.Gym.model.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym,Long> {
}
