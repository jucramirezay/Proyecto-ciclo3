package com.proyecto.arbolenfermedad.service;



import org.springframework.stereotype.Service;



@Service
public class MiembroService implements IMiembroService {

    /*
    private IMiembroRepository miembroRepository;

    public MiembroService(IMiembroRepository miembroRepository) {
        this.miembroRepository = miembroRepository;
    }


    @Override
    public static List<Miembro> getAllMiembros(){
        return miembroRepository.findAllSortByNombreMiembro();
    }

    @Override
    public List<Miembro> getMiembrosByNombreMiembro(String  nombreMiembro){
        return miembroRepository.findByNombreMiembroContaining(nombreMiembro);
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

     */

}
