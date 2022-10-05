package com.proyecto.arbolenfermedad.service;



import java.util.List;
import org.springframework.stereotype.Service;

import com.proyecto.arbolenfermedad.Repository.IMiembroRepository;
import com.proyecto.arbolenfermedad.entity.Miembro;


@Service
public class MiembroService implements IMiembroService {

    private IMiembroRepository miembroRepository;

    


    public MiembroService(IMiembroRepository miembroRepository) {
        this.miembroRepository = miembroRepository;
    }

    @Override
    public Miembro saveMiembro (Miembro miembro){
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

    @Override
    public List<Miembro> getAll() {
        return miembroRepository.findAll();
    }


}
