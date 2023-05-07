
package com.porfolio.svv.Repository;

import com.porfolio.svv.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia>findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
            
}
