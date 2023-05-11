
package com.porfolio.svv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Educacion {
        //Primary Key+Autogenerado
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    //Variables obligatorias
    @NotNull
    @Size (min =1, max = 50, message = "no cumple con la logitud" )
    private String nombreEdu;
    @NotNull
    @Size (min =1, max = 250, message = "no cumple con la logitud" )
    private String descripcionEdu;
    @NotNull
    @Size (min =1, max = 50, message = "no cumple con la logitud" )
    private String fechaEdu;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu, String fechaEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }
    
}
