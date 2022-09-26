package com.proyecto.arbolenfermedad.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombrepersona", nullable = false)
    private String nombrePersona;

    @Column(name = "apellidopersona", nullable = false)
    private String apellidoPersona;

    @Column(name = "cedulapersona", nullable = false)
    private String cedulaPersona;

    @Column(name = "generopersona", nullable = false)
    private String generoPersona;

    @Column(name = "fechanacimientopersona", nullable = false)
    private Date fechaNacimientoPersona;

    @Column(name = "emailpersona", nullable = false)
    private String emailPersona;

    @Column(name = "usuariopersona", nullable = false)
    private String usuarioPersona;

    @Column(name = "passwordpersona", nullable = false)
    private String passwordPersona;

    @Column(name = "enfermedadunopersona", nullable = false)
    private String enfermedadUnoPersona;

    @Column(name = "enfermedaddospersona", nullable = false)
    private String enfermedadDosPersona;

    @Column(name = "enfermedadtrespersona", nullable = false)
    private String enfermedadTresPersona;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Miembro> miembros = new HashSet<>();

    public Persona(String nombrePersona, String apellidoPersona, String cedulaPersona, String generoPersona,
            Date fechaNacimientoPersona, String emailPersona, String usuarioPersona, String passwordPersona,
            String enfermedadUnoPersona, String enfermedadDosPersona, String enfermedadTresPersona) {

        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.cedulaPersona = cedulaPersona;
        this.generoPersona = generoPersona;
        this.fechaNacimientoPersona = fechaNacimientoPersona;
        this.emailPersona = emailPersona;
        this.usuarioPersona = usuarioPersona;
        this.passwordPersona = passwordPersona;
        this.enfermedadUnoPersona = enfermedadUnoPersona;
        this.enfermedadDosPersona = enfermedadDosPersona;
        this.enfermedadTresPersona = enfermedadTresPersona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getGeneroPersona() {
        return generoPersona;
    }

    public void setGeneroPersona(String generoPersona) {
        this.generoPersona = generoPersona;
    }

    public Date getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }

    public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public String getUsuarioPersona() {
        return usuarioPersona;
    }

    public void setUsuarioPersona(String usuarioPersona) {
        this.usuarioPersona = usuarioPersona;
    }

    public String getPasswordPersona() {
        return passwordPersona;
    }

    public void setPasswordPersona(String passwordPersona) {
        this.passwordPersona = passwordPersona;
    }

    public String getEnfermedadUnoPersona() {
        return enfermedadUnoPersona;
    }

    public void setEnfermedadUnoPersona(String enfermedadUnoPersona) {
        this.enfermedadUnoPersona = enfermedadUnoPersona;
    }

    public String getEnfermedadDosPersona() {
        return enfermedadDosPersona;
    }

    public void setEnfermedadDosPersona(String enfermedadDosPersona) {
        this.enfermedadDosPersona = enfermedadDosPersona;
    }

    public String getEnfermedadTresPersona() {
        return enfermedadTresPersona;
    }

    public void setEnfermedadTresPersona(String enfermedadTresPersona) {
        this.enfermedadTresPersona = enfermedadTresPersona;
    }

    public Set<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(Set<Miembro> miembros) {
        this.miembros = miembros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.cedulaPersona == null) ? 0 : this.cedulaPersona.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (this.cedulaPersona == null) {
            if (other.cedulaPersona != null)
                return false;
        } else if (!this.cedulaPersona.equals(other.cedulaPersona))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Persona{"
                +
                "nombrePersona=" + nombrePersona +
                "apellidoPersona=" + apellidoPersona +
                "cedulaPersona=" + cedulaPersona +
                "generoPersona=" + generoPersona +
                "fechaNacimientoPersona=" + fechaNacimientoPersona +
                "emailPersona=" + emailPersona +
                "usuarioPersona=" + usuarioPersona +
                "passwordPersona=" + passwordPersona +
                "enfermedadUnoPersona=" + enfermedadUnoPersona +
                "enfermedadDosPersona=" + enfermedadDosPersona +
                "enfermedadTresPersona=" + enfermedadTresPersona +
                '}';

    }

}
