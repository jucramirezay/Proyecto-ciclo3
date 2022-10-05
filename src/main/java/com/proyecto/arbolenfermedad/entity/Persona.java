package com.proyecto.arbolenfermedad.entity;

//import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "usuariopersona", nullable = false)
    private String usuarioPersona;

    @Column(name = "passwordpersona", nullable = false)
    private String passwordPersona;

    @Column(name = "enfermedadespersona", nullable = true)
    private String enfermedadesPersona;


    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Miembro> miembros = new HashSet<>();

    public Persona() {

    }

    public Persona(String nombrePersona, String apellidoPersona, String cedulaPersona,
            String usuarioPersona, String passwordPersona,
            String enfermedadesPersona) {

        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.cedulaPersona = cedulaPersona;
        this.usuarioPersona = usuarioPersona;
        this.passwordPersona = passwordPersona;
        this.enfermedadesPersona = enfermedadesPersona;

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

    public String getEnfermedadesPersona() {
        return enfermedadesPersona;
    }

    public void setEnfermedadesPersona(String enfermedadesPersona) {
        this.enfermedadesPersona = enfermedadesPersona;
    }

    

    public Set<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(Miembro miembro) {
        this.miembros.add(miembro);
        
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
                "usuarioPersona=" + usuarioPersona +
                "passwordPersona=" + passwordPersona +
                "enfermedadesPersona=" + enfermedadesPersona +
                '}';

    } 
    

}
