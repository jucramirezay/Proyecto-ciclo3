package com.proyecto.arbolenfermedad.service;

import java.util.List;

import com.proyecto.arbolenfermedad.entity.Miembro;

public interface IMiembroService {

    List<Miembro> getAllMiembros();

    List<Miembro> getMiembroBycedulaMiembro(int cedula);
    
    Miembro saveMiembro(Miembro miembro);

    Miembro getMiembroById(Long Id);

    Miembro updateMiembro(Miembro miembro);

    void deleteMiembroById(Long id);
}
