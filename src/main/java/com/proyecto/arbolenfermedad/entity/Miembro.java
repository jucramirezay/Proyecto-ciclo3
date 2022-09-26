package com.proyecto.arbolenfermedad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "miembros")
public class Miembro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombremiembro", nullable = false)
    private String nombreMiembro;

    @Column(name = "apellidomiembro", nullable = false)
    private String apellidoMiembro;

    @Column(name = "cedulaMiembro", nullable = false)
    private String cedulaMiembro;

    @Column(name = "fechanacimientomiembro", nullable = false)
    private Date fechaNacimientoMiembro;

    @Column(name = "fechanadefuncionmiembro", nullable = false)
    private Date fechaDefuncionMiembro;

    @Column(name = "generoMiembro", nullable = false)
    private String generoMiembro;

    @Column(name = "parentescomiembro", nullable = false)
    private String parentescoMiembro;

    @Column(name = "descendenciamiembro", nullable = false)
    private String descendenciaMiembro;

    @Column(name = "enfermedadunomiembro", nullable = false)
    private String enfermedadUnoMiembro;

    @Column(name = "enfermedaddosmiembro", nullable = false)
    private String enfermedadDosMiembro;

    @Column(name = "enfermedadtresmiembro", nullable = false)
    private String enfermedadTresMiembro;

    public Miembro(String nombreMiembro, String apellidoMiembro, String cedulaMiembro, Date fechaNacimientoMiembro,
            Date fechaDefuncionMiembro, String generoMiembro, String parentescoMiembro, String descendenciaMiembro,
            String enfermedadUnoMiembro, String enfermedadDosMiembro, String enfermedadTresMiembro) {
        this.nombreMiembro = nombreMiembro;
        this.apellidoMiembro = apellidoMiembro;
        this.cedulaMiembro = cedulaMiembro;
        this.fechaNacimientoMiembro = fechaNacimientoMiembro;
        this.fechaDefuncionMiembro = fechaDefuncionMiembro;
        this.generoMiembro = generoMiembro;
        this.parentescoMiembro = parentescoMiembro;
        this.descendenciaMiembro = descendenciaMiembro;
        this.enfermedadUnoMiembro = enfermedadUnoMiembro;
        this.enfermedadDosMiembro = enfermedadDosMiembro;
        this.enfermedadTresMiembro = enfermedadTresMiembro;
    }

    @ManyToOne()
    // @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Set<Persona> personas = new HashSet<>();

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

    public String getCedulaMiembro() {
        return cedulaMiembro;
    }

    public void setCedulaMiembro(String cedulaMiembro) {
        this.cedulaMiembro = cedulaMiembro;
    }

    public Date getFechaNacimientoMiembro() {
        return fechaNacimientoMiembro;
    }

    public void setFechaNacimientoMiembro(Date fechaNacimientoMiembro) {
        this.fechaNacimientoMiembro = fechaNacimientoMiembro;
    }

    public Date getFechaDefuncionMiembro() {
        return fechaDefuncionMiembro;
    }

    public void setFechaDefuncionMiembro(Date fechaDefuncionMiembro) {
        this.fechaDefuncionMiembro = fechaDefuncionMiembro;
    }

    public String getGeneroMiembro() {
        return generoMiembro;
    }

    public void setGeneroMiembro(String generoMiembro) {
        this.generoMiembro = generoMiembro;
    }

    public String getParentescoMiembro() {
        return parentescoMiembro;
    }

    public void setParentescoMiembro(String parentescoMiembro) {
        this.parentescoMiembro = parentescoMiembro;
    }

    public String getDescendenciaMiembro() {
        return descendenciaMiembro;
    }

    public void setDescendenciaMiembro(String descendenciaMiembro) {
        this.descendenciaMiembro = descendenciaMiembro;
    }

    public String getEnfermedadUnoMiembro() {
        return enfermedadUnoMiembro;
    }

    public void setEnfermedadUnoMiembro(String enfermedadUnoMiembro) {
        this.enfermedadUnoMiembro = enfermedadUnoMiembro;
    }

    public String getEnfermedadDosMiembro() {
        return enfermedadDosMiembro;
    }

    public void setEnfermedadDosMiembro(String enfermedadDosMiembro) {
        this.enfermedadDosMiembro = enfermedadDosMiembro;
    }

    public String getEnfermedadTresMiembro() {
        return enfermedadTresMiembro;
    }

    public void setEnfermedadTresMiembro(String enfermedadTresMiembro) {
        this.enfermedadTresMiembro = enfermedadTresMiembro;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }



    @Override
    public String toString() {
        return "Miembro{"
                +
                "nombreMiembro=" + nombreMiembro +
                "apellidoMiembro=" + apellidoMiembro +
                "cedulaMiembro=" + cedulaMiembro +
                "generoMiembro=" + generoMiembro +
                "fechaNacimientoMiembro=" + fechaNacimientoMiembro +
                "fechaDefuncionMiembro=" + fechaDefuncionMiembro +
                "parentescoMiembro=" + parentescoMiembro +
                "descendenciaMiembro=" + descendenciaMiembro +
                "enfermedadUnoMiembro=" + enfermedadUnoMiembro +
                "enfermedadDosMiembro=" + enfermedadDosMiembro +
                "enfermedadTresMiembro=" + enfermedadTresMiembro +
                '}';

                
    }

}