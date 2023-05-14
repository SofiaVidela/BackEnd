
package com.porfolio.svv.Repository;

import com.porfolio.svv.Entity.HardSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHardSkillRepository extends JpaRepository<HardSkill, Integer> {
    public Optional<HardSkill>findByNombreHS(String nombreHS);
    public boolean existsByNombreHS(String nombreHS);
}
