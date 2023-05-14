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
    private String descriPcionHS;
    private String descriPcionSS;
    private String img;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String descripcionDM, String subtitulo, String descriPcionHS, String descriPcionSS, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcionDM = descripcionDM;
        this.subtitulo= subtitulo;
        this.descriPcionHS = descriPcionHS;
        this.descriPcionSS = descriPcionSS;
        this.img = img;
    }

    
}
