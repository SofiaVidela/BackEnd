
package com.porfolio.svv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyecto {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    private String linkFotoP;
    private String linkProyectoP;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descripcionP, String linkFotoP, String linkProyectoP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkFotoP = linkFotoP;
        this.linkProyectoP = linkProyectoP;
    }

    
}
