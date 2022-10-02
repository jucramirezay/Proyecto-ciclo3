package com.proyecto.arbolenfermedad.service;

import java.util.List;

import com.proyecto.arbolenfermedad.entity.Persona;

public interface IPersonaService {


List<Persona> getAllPersona();


List<Persona> getPersonaByNombrePersona(String nombrePersona);

Persona savePersona(Persona persona);

Persona getPersonaById(Long id);

Persona updatePersona(Persona persona);

void deletePersonaById(Long id);
}
