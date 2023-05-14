
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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la logitud")
    private String nombreP;
    @NotNull
    private String descripcionP;
    private String linkFotoP;
    private String linkProyectoP;

    public Proyecto() {
    }

    public Proyecto(String nombreP, String descripcionP, String linkFotoP, String linkProyectoP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkFotoP = linkFotoP;
        this.linkProyectoP = linkProyectoP;
    }
    
    
    
}
