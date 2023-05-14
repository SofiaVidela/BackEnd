
package com.porfolio.svv.Repository;

import com.porfolio.svv.Entity.SoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftSkillRepository extends JpaRepository<SoftSkill, Integer> {
    public Optional<SoftSkill>findByNombreSS(String nombreSS);
    public boolean existsByNombreSS(String nombreSS);
}
