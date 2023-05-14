
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
public class SoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la logitud")
    private String nombreSS;
    @NotNull
    private int porcentajeSS;

    public SoftSkill() {
    }

    
    public SoftSkill(String nombreSS, int porcentajeSS) {
        this.nombreSS = nombreSS;
        this.porcentajeSS = porcentajeSS;
    }

    
}
