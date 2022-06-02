package com.example.gym.Gym.model.service;

import com.example.gym.Gym.model.entity.Gym;
import com.example.gym.Gym.model.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    private final GymRepository gymRepository;

    public GymService(GymRepository gymRepository){this.gymRepository = gymRepository;}
    public List<Gym> listarGym() { return gymRepository.findAll() ;}

    public Gym consultarGym(Long id) {
        return gymRepository.findById(id).orElse(null);
    }

    public Gym añadirGym(Gym nuevoGym) {
        return gymRepository.save(nuevoGym);
    }

    public Gym eliminarGym(Long id) {
        Gym res = gymRepository.findById(id).orElse(null);
        if (res!=null) gymRepository.deleteById(id);
        return res;
    }

    public Gym modificarGym(Gym gymModify) {
        Gym mod = null;
        if (gymRepository.existsById(gymModify.getId())) mod=gymRepository.save(gymModify);
        return mod;
    }
}

