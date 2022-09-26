package com.proyecto.arbolenfermedad.service;

import java.util.List;

import com.proyecto.arbolenfermedad.entity.Persona;

public interface IPersonaService {

    //List<Persona> getAllPersonas();

    List<Persona> getPersonaBycedulaPersona(int cedulaPersona);

    Persona savePersona(Persona persona);

    Persona getPersonaById(Long id);

    Persona updatePersona(Persona persona);

    void deletePersonaById(Long Id);
    
}
