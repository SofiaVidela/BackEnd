package com.porfolio.svv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {

    //Primary Key+Autogenerado
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    //Variables obligatorias
    @NotNull
    @Size (min =1, max = 50, message = "no cumple con la logitud" )
    private String nombre;
    @NotNull
    @Size (min =1, max = 50, message = "no cumple con la logitud" )
    private String apellido;
    @NotNull
    private String descripcionDM;
    @NotNull
    private String subtitulo;
    //Variables no obligatorias
    private String descriPcionHS;
    private String descriPcionSS;
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcionDM,String subtitulo, String descriPcionHS, String descriPcionSS, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcionDM = descripcionDM;
        this.subtitulo = subtitulo;
        this.descriPcionHS = descriPcionHS;
        this.descriPcionSS = descriPcionSS;
        this.img = img;
    }   
}