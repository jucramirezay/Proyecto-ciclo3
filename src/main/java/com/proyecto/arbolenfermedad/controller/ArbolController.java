package com.proyecto.arbolenfermedad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.arbolenfermedad.Repository.IMiembroRepository;
import com.proyecto.arbolenfermedad.Repository.IPersonaRepository;
import com.proyecto.arbolenfermedad.entity.Miembro;
import com.proyecto.arbolenfermedad.entity.Persona;
import com.proyecto.arbolenfermedad.service.MiembroService;
import com.proyecto.arbolenfermedad.service.PersonaService;



@Controller
public class ArbolController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private MiembroService miembroService;

    @Autowired
    private IMiembroRepository miembroRepository;

    @Autowired
    private IPersonaRepository personaRepository;



    public ArbolController(PersonaService personaService, MiembroService miembroService,
            IMiembroRepository miembroRepository, IPersonaRepository personaRepository) {
        this.personaService = personaService;
        this.miembroService = miembroService;
        this.miembroRepository = miembroRepository;
        this.personaRepository = personaRepository;
    }

    @RequestMapping("/")
    public String principal() {
        return "index";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/ver_mi_arbol")
    public String vermiarbol(Model model) {
        model.addAttribute("ver_mi_arbol",miembroService.getAllMiembros());
        return "ver_mi_arbol";
    }

    /* 
    @GetMapping("/create_member")
    public String createMiembroForm(Model model){

        Miembro miembro=new Miembro();
        model.Attribute("Miembro",miembro);
        return "create_member";
    }
    */
    @PostMapping("/persona")
    public String savePersona(@ModelAttribute("persona") Persona persona ){
        personaService.savePersona(persona);
        return("redirect:/ver_mi_arbol");
    }

    @PostMapping("/miembros")
    public String saveMiembro(@ModelAttribute("miembro") Miembro miembro ){
        miembroService.saveMiembro(miembro);
        return("redirect:/ver_mi_arbol");
    }



    

}