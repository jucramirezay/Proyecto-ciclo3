package com.proyecto.arbolenfermedad.service;

import java.util.List;

import com.proyecto.arbolenfermedad.Repository.IMiembroRepository;
import com.proyecto.arbolenfermedad.entity.Miembro;

public class MiembroService implements IMiembroService {

    private IMiembroRepository miembroRepository;

    public MiembroService(IMiembroRepository miembroRepository) {
        this.miembroRepository = miembroRepository;
    }

    @Override
    public List<Miembro> getAllMiembros(){
        return miembroRepository.findAllSortByapellidoMiembro();
    }
    
    @Override
    public List<Miembro> getMiembroBycedulaMiembro(int cedulaMiembro){
        return miembroRepository.findBycedulaMiembroContaining(cedulaMiembro);
    }

    @Override
    public Miembro saveMiembro(Miembro miembro){
        return miembroRepository.save(miembro);
    }

    @Override
    public Miembro getMiembroById(Long id){
        return miembroRepository.getReferenceById(id);   
    }

    @Override
    public void deleteMiembroById(Long id){
        miembroRepository.deleteById(id);
    }

    @Override
    public Miembro updateMiembro(Miembro miembro){
        return miembroRepository.save(miembro);
    }
}
