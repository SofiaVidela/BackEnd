
package com.porfolio.svv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoHardSkill {
    @NotBlank
    private String nombreHS;
    @NotBlank
    private int porcentajeHS;
    private String descripcionHS;

    public dtoHardSkill() {
    }

    public dtoHardSkill(String nombreHS, int porcentajeHS, String descripcionHS) {
        this.nombreHS = nombreHS;
        this.porcentajeHS = porcentajeHS;
        this.descripcionHS = descripcionHS;
    }
    
}
