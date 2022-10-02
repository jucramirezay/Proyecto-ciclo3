package com.proyecto.arbolenfermedad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.proyecto.arbolenfermedad.entity.Persona;

import com.proyecto.arbolenfermedad.service.PersonaService;

@Controller
public class ArbolController {

    @Autowired
    private PersonaService personaService;

    
    /*@Autowired
    private MiembroService miembroService;
    */

    
     public ArbolController(PersonaService personaService ) {
     this.personaService = personaService;
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

    @RequestMapping(value = "/guardarpersona", method = RequestMethod.POST)
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

    @GetMapping("persona/edit/{id}")
    public String editPersonaForm(@PathVariable Long id, Model model){
    Persona pt= personaService.getPersonaById(id);
    model.addAttribute("persona",pt);
    return "edit_person";
    }

    @PostMapping("/persona/{id}")
    public String updatePersona(@PathVariable Long id, 
    @ModelAttribute("persona") Persona persona,Model model) {
    //sacar el esudiante de la b.d. por el id
    Persona existentPerson =personaService.getPersonaById(id);
    // cargarlo
    existentPerson.setId(id);
    existentPerson.setNombrePersona(persona.getNombrePersona());
    existentPerson.setApellidoPersona(persona.getApellidoPersona());
    existentPerson.setCedulaPersona(persona.getCedulaPersona());
    existentPerson.setUsuarioPersona(persona.getUsuarioPersona());
    existentPerson.setPasswordPersona(persona.getPasswordPersona());
    existentPerson.setEnfermedadesPersona(persona.getEnfermedadesPersona());

    personaService.updatePersona(existentPerson);
    return "/perfil";
    }

    @GetMapping("/persona/{id}")
    public String deletePersona(@PathVariable Long id) {
    PersonaService.deletePersonaById(id);
    return "/";        
    }

    



    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    /*
     * @GetMapping("ver_mi_arbol")
     * public String ver_mi_arbol(Model model) {
     * model.addAttribute("ver_mi_arbol", miembroService.getAllMiembro());
     * return "ver_mi_arbol";
     * }
     * 
     * @GetMapping("/ver_mi_arbol")
     * public String listMiembros(Model model) {
     * model.addAttribute("ver_mi_arbol", miembroService.getAllMiembro());
     * return "ver_mi_arbol";
     * }
     * 
     * @GetMapping("/create_member/new")
     * public String createMiembroForm(Model model) {
     * Miembro miembro= new Miembro();
     * model.addAttribute("ver_mi_arbol", miembro);
     * return "create_member";
     * }
     * 
     * @PostMapping("/ver_mi_arbol")
     * public String saveMiembro (@ModelAttribute("ver_mi_arbol") Miembro miembro) {
     * miembroService.saveMiembro(miembro);
     * return "redirect:/ver_mi_arbol";
     * }
     * 
     * @GetMapping("ver_mi_arbol/edit/{id}")
     * public String editMiembroForm(@PathVariable Long id, Model model){
     * Miembro mt= miembroService.getMiembroById(id);
     * model.addAttribute("ver_mi_arbol",mt);
     * 
     * 
     * return "edit_member";
     * }
     * 
     * 
     * // api actualizar un miembro
     * 
     * @PostMapping("/ver_mi_arbol/edit/{id}")
     * public String updateMiembro(@PathVariable Long id,
     * 
     * @ModelAttribute("miembros") Miembro miembro, //no estoy seguro si miembro
     * entre comilla sea la tabla de la bd
     * Model model) {
     * // sacar al miembro de la bd por id
     * Miembro existentMiembro = miembroService.getMiembroById(id);
     * // cargarlo
     * existentMiembro.setId(id);
     * existentMiembro.setNombreMiembro(miembro.getNombreMiembro());
     * existentMiembro.setApellidoMiembro(miembro.getApellidoMiembro());
     * existentMiembro.setCedulaMiembro(miembro.getCedulaMiembro());
     * existentMiembro.setGeneroMiembro(miembro.getGeneroMiembro());
     * existentMiembro.setFechaNacimientoMiembro(miembro.getFechaNacimientoMiembro()
     * );
     * existentMiembro.setFechaDefuncionMiembro(miembro.getFechaDefuncionMiembro());
     * existentMiembro.setParentescoMiembro(miembro.getParentescoMiembro());
     * existentMiembro.setDescendenciaMiembro(miembro.getDescendenciaMiembro());
     * existentMiembro.setEnfermedadUnoMiembro(miembro.getEnfermedadUnoMiembro());
     * existentMiembro.setEnfermedadDosMiembro(miembro.getEnfermedadDosMiembro());
     * existentMiembro.setEnfermedadTresMiembro(miembro.getEnfermedadTresMiembro());
     * 
     * // guardar el miembro actualizado
     * miembroService.updateMiembro(existentMiembro);
     * 
     * return "redirect:/ver_mi_arbol";
     * 
     * }
     * 
     * 
     * // api elimminar miembro
     * 
     * @GetMapping("/ver_mi_arbol/{id}")
     * public String deleteMiembro(@PathVariable Long id) {
     * miembroService.deleteMiembroById(id);
     * return "redirect:/ver_mi_arbol";
     * }
     * 
     * 
     * //PERSONA
     * 
     * @GetMapping("/create_person/new")
     * public String createPersonaForm(Model model) {
     * Persona persona= new Persona();
     * model.addAttribute("create_persona", persona);
     * //model.addAttribute("personaList",personaList);
     * return "create_person";
     * }
     */

}