package com.proyecto.arbolenfermedad.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.arbolenfermedad.Repository.IPersonaRepository;
import com.proyecto.arbolenfermedad.entity.Persona;

@Service
public class PersonaService implements IPersonaService {

  
    private IPersonaRepository personaRepository;




    public PersonaService(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona savePersona (Persona persona){
        return personaRepository.save(persona);
    }


    @Override
    public Persona getPersonaById(Long id){
        return personaRepository.getReferenceById(id); 
    }   


    @Override
    public Persona updatePersona(Persona persona){
        return personaRepository.save(persona);
    }


    @Override
    public  void deletePersonaById(Long id){
        personaRepository.deleteById(id);
    }

   

    
}
