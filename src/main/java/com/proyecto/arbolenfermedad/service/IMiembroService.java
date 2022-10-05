package com.proyecto.arbolenfermedad.service;


import java.util.List;

import com.proyecto.arbolenfermedad.entity.Miembro;




public interface IMiembroService {
    
    List<Miembro> getAll();

    Miembro saveMiembro(Miembro miembro);
    
    Miembro getMiembroById(Long id);
    
    Miembro updateMiembro(Miembro persona);
    
    void deleteMiembroById(Long id);
}
