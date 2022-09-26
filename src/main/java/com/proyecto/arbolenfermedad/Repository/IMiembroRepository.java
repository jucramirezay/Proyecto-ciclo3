package com.proyecto.arbolenfermedad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.arbolenfermedad.entity.Miembro;

public interface IMiembroRepository extends JpaRepository<Miembro, Long> {
    @Query("FROM Miembro m WHERE m.cedulamiembro like:title ")
    public List<Miembro> findBycedulaMiembroContaining(@Param("title") int title);

    @Query("FROM Miembro m ORDER BY apellidomiembro")
    public List<Miembro> findAllSortByapellidoMiembro();

}
