
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
public class HardSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la logitud")
    private String nombreHS;
    @NotNull
    private int porcentajeHS;

    private String descripcionHS;

    public HardSkill() {
    }

    public HardSkill(String nombreHS, int porcentajeHS, String descripcionHS) {

        this.nombreHS = nombreHS;
        this.porcentajeHS = porcentajeHS;
        this.descripcionHS = descripcionHS;
    }
    
    
}
