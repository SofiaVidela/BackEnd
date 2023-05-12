
package com.porfolio.svv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String fechaEdu;
    private String linkCertificado;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String descripcionEdu, String fechaEdu, String linkCertificado) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
        this.linkCertificado= linkCertificado;
    }
    
}
