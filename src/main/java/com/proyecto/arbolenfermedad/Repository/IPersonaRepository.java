package com.proyecto.arbolenfermedad.Repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.proyecto.arbolenfermedad.entity.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {

    /* 
    @Query("FROM Persona p WHERE p.nombrePersona LIKE:nombrePersona")
    List<Persona> findByNombrePersonaContaining(@Param("nombrePersona") String nombrePersona);
    
    @Query("FROM Persona p WHERE p.id LIKE:id")
    Persona findByIdContaining(@Param("id") Long id);

    */

}
