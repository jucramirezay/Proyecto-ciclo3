package com.proyecto.arbolenfermedad.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    public ArbolController(PersonaService personaService, MiembroService miembroService) {
        this.personaService = personaService;
        this.miembroService = miembroService;

    }

    @GetMapping("/")
    public String principal() {
        return "index";
    }

    @GetMapping("/registrarpersona")
    public String mostrarFormularioDeRegistarPersona(Model model) {

        Persona persona = new Persona();

        model.addAttribute("persona", persona);

        return "create_person";
    }

    @GetMapping("/formCrearPersona")
    public String FormularioCrearPersona(Model model) {
        Persona persona = new Persona();
        model.addAttribute("persona", persona);
        return "/crearpersona";
    }

    // esta liena funciona pero al cambie par aprobar la del profesor
    // @RequestMapping (value = "/guardarpersona", method = RequestMethod.POST)

    @PostMapping("/guardarpersona")
    public String guardarPersona(@ModelAttribute("persona") Persona persona) {
        personaService.savePersona(persona);
        return "/perfil";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        List<Persona> listaPersona = personaService.getAll();
        model.addAttribute("listaPersona", listaPersona);
        return "perfil";
    }

    @GetMapping("personaperfil/ver/{id}")
    public String verperfil(@PathVariable Long id, Model model) {
        Persona pt = personaService.getPersonaById(id);
        model.addAttribute("persona", pt);
        return "perfil";
    }

    @GetMapping("persona/edit/{id}")
    public String editPersonaForm(@PathVariable Long id, Model model) {
        Persona pt = personaService.getPersonaById(id);
        model.addAttribute("persona", pt);
        return "edit_person";
    }

    @PostMapping("/persona/{id}")
    public String updatePersona(@PathVariable Long id,
            @ModelAttribute("persona") Persona persona, Model model) {
        // sacar el esudiante de la b.d. por el id
        Persona existentPerson = personaService.getPersonaById(id);
        // cargarlo
        existentPerson.setId(id);
        existentPerson.setNombrePersona(persona.getNombrePersona());
        existentPerson.setApellidoPersona(persona.getApellidoPersona());
        existentPerson.setCedulaPersona(persona.getCedulaPersona());
        existentPerson.setUsuarioPersona(persona.getUsuarioPersona());
        existentPerson.setPasswordPersona(persona.getPasswordPersona());
        existentPerson.setEnfermedadesPersona(persona.getEnfermedadesPersona());

        personaService.updatePersona(existentPerson);
        return "perfil";
    }

    // revisar la priemra linea y el return
    @GetMapping("/{id}")
    public String deletePersona(@PathVariable Long id) {
        personaService.deletePersonaById(id);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    // miembros
    @GetMapping("/registrarmiembro")
    public String mostrarFormularioDeRegistarMiembro(Model model) {

        Miembro miembro = new Miembro();

        model.addAttribute("miembro", miembro);

        return "/create_member";
    }

    
    @GetMapping("/crearmiembro")
    public String ForDeRegistarMiembro(@PathVariable Long id,Model model) {
        Persona exisPers = personaService.getPersonaById(id);

        Miembro miembro = new Miembro();
        model.addAttribute("persona", exisPers);
        model.addAttribute("miembro", miembro);
        return "crearmiembro";
    }

    @PostMapping("/guardarmiembro")
    public String guardarmiembro(@ModelAttribute("miembro") Miembro miembro) {

        Persona persona=new Persona();
        persona.setMiembros(miembro);
        miembro.setPersona(persona);

        Set<Miembro> hsMiembro = new HashSet<Miembro>();
        hsMiembro.add(miembro);

    
        miembroService.saveMiembro(miembro);
        //System.out.println(hsMiembro);

        return "create_member";



}
}