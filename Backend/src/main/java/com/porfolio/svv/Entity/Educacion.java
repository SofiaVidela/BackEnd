package com.porfolio.svv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Educacion {
    //Primary Key+Autogenerado

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Variables obligatorias
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la logitud")
    private String nombreEdu;
    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la logitud")
    private String descripcionEdu;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la logitud")
    private String fechaEdu;

    private String linkCertificado;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu, String fechaEdu, String linkCertificado) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
        this.linkCertificado = linkCertificado;
    }
}
