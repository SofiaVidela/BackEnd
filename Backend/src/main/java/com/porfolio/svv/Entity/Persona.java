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
    private Long id;
    
    //Variables obligatorias
    @NotNull
    @Size (min =1, max = 50, message = "no cumple con la logitud" )
    private String nombre;
    @NotNull
    @Size (min =1, max = 50, message = "no cumple con la logitud" )
    private String apellido;
    
    //Variable no obligatoria
    @Size (min =1, max = 75, message = "no cumple con la logitud" )
    private String img;
}
