package com.proyecto.arbolenfermedad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.arbolenfermedad.entity.Persona;

public interface IPersonaRepository extends JpaRepository<Persona,Long> {

    @Query("FROM Persona p WHERE  p.cedulapersona like:title")
    List<Persona> findByCedulaPersonaContaining(@Param("title") int title);
}