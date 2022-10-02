package com.proyecto.arbolenfermedad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.proyecto.arbolenfermedad.Repository.IPersonaRepository;
import com.proyecto.arbolenfermedad.entity.Persona;

@Service
public class PersonaService {
 
    @Autowired
    private IPersonaRepository personaRepository;



    public List<Persona> listAll(){
        return personaRepository.findAll();
    }


    public void save(Persona persona){
        personaRepository.save(persona);
    }

    
    public Persona get(Long id){
        return personaRepository.findById(id).get();   
    }    

    public void delete(Long id){
        personaRepository.deleteById(id);
    }


    
}
