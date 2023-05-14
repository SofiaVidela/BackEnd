
package com.porfolio.svv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSoftSkill {
    @NotBlank
    private String nombreSS;
    @NotBlank
    private int porcentajeSS;

    public dtoSoftSkill() {
    }

    public dtoSoftSkill(String nombreSS, int porcentajeSS) {
        this.nombreSS = nombreSS;
        this.porcentajeSS = porcentajeSS;
    }
    
}
