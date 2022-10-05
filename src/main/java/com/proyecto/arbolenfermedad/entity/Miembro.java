package com.proyecto.arbolenfermedad.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "miembros")

public class Miembro implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombremiembro", nullable = false)
    private String nombreMiembro;

    @Column(name = "apellidomiembro", nullable = false)
    private String apellidoMiembro;

    @Column(name = "parentescomiembro", nullable = false)
    private String parentescoMiembro;

    @Column(name = "enfermedadesmiembro", nullable = true)
    private String enfermedadesMiembro;

    
    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JsonProperty(access=Access.WRITE_ONLY)
    @JoinColumn(name = "persona_id",nullable = false)
    private Persona persona;

    public Miembro(){
        
    }

    public Miembro(String nombreMiembro, String apellidoMiembro, String parentescoMiembro,
            String enfermedadesMiembro) {
        this.nombreMiembro = nombreMiembro;
        this.apellidoMiembro = apellidoMiembro;
        this.parentescoMiembro = parentescoMiembro;
        this.enfermedadesMiembro = enfermedadesMiembro;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMiembro() {
        return nombreMiembro;
    }

    public void setNombreMiembro(String nombreMiembro) {
        this.nombreMiembro = nombreMiembro;
    }

    public String getApellidoMiembro() {
        return apellidoMiembro;
    }

    public void setApellidoMiembro(String apellidoMiembro) {
        this.apellidoMiembro = apellidoMiembro;
    }

    public String getParentescoMiembro() {
        return parentescoMiembro;
    }

    public void setParentescoMiembro(String parentescoMiembro) {
        this.parentescoMiembro = parentescoMiembro;
    }

    public String getEnfermedadesMiembro() {
        return enfermedadesMiembro;
    }

    public void setEnfermedadesMiembro(String enfermedadesMiembro) {
        this.enfermedadesMiembro = enfermedadesMiembro;
    }


    /* 
    public Set<Persona> getPersona() {
        return persona;
    }

    public void setPersona(Set<Persona> persona) {
        this.persona = persona;
    }
    */

    public Persona getPersona(){
        return persona;
    }

    public void setPersona(Persona persona){
        this.persona=persona;
    }
 
    @Override
    public String toString() {
        return "Miembro{"
                +
                "nombreMiembro=" + nombreMiembro +
                "apellidoMiembro=" + apellidoMiembro +
                "parentescoMiembro=" + parentescoMiembro +
                "enfermedadesMiembro=" + enfermedadesMiembro +
                '}';

                
    }
    

}