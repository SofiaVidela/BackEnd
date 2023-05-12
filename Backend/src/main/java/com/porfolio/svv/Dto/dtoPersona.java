package com.porfolio.svv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcionDM;
    @NotBlank
    private String subtitulo;

    //Variables no obligatorias
    private String descripcionHS;
    private String descripcionSS;
    private String img;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String descripcionDM, String subtitulo, String descripcionHS, String descripcionSS, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcionDM = descripcionDM;
        this.subtitulo= subtitulo;
        this.descripcionHS = descripcionHS;
        this.descripcionSS = descripcionSS;
        this.img = img;
    }

    
}
