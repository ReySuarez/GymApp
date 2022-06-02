package com.example.gym.Gym.controller;

import com.example.gym.Gym.model.entity.Gym;
import com.example.gym.Gym.model.service.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController {private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = GymController.this.gymService;
    }

    @GetMapping("/gyms")
    public ResponseEntity<Object> listarGyms(){
        List<Gym> res = gymService.listarGym();
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/gym/{id}")
    public ResponseEntity<Gym> consultarGym(@PathVariable Long id)
    {
        Gym res = gymService.consultarGym(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }
    @PostMapping("/gyms")
    public ResponseEntity<Gym> crearGym(@RequestBody Gym nuevo){
        Gym res = gymService.añadirGym(nuevo);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @DeleteMapping("/gym/{id}")
    public ResponseEntity<Gym> eliminarGym(@PathVariable Long id){
        Gym res = gymService.eliminarGym(id);
        return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
    }
    @PutMapping("/gym")
    public ResponseEntity<Gym> modificarGym(@RequestBody Gym gymModify){
        Gym res = gymService.modificarGym(gymModify);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }
}

