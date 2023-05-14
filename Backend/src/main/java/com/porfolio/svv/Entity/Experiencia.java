
package com.porfolio.svv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Experiencia {

    //Primary Key+Autogenerado
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    //Variables obligatorias
    @NotNull
    @Size (min =1, max = 50, message = "no cumple con la logitud" )
    private String nombreE;
    @NotNull
    @Size (min =1, max = 250, message = "no cumple con la logitud" )
    private String descripcionE;
    @NotNull
    @Size (min =1, max = 50, message = "no cumple con la logitud" )
    private String fechaE;
    
    //Constructores
    public Experiencia(){
    }

    public Experiencia(String nombreE, String descripcionE, String fechaE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaE = fechaE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }
}