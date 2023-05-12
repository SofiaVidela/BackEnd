package com.porfolio.svv.Service;

import com.porfolio.svv.Entity.HardSkill;
import com.porfolio.svv.Repository.IHardSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HardSkillService {

    @Autowired
    IHardSkillRepository iHSRepository;

    public List<HardSkill> list() {
        return iHSRepository.findAll();
    }

    public Optional<HardSkill> getOne(int id) {
        return iHSRepository.findById(id);
    }

    public Optional<HardSkill> getByNombreHS(String nombreHS) {
        return iHSRepository.findByNombreHS(nombreHS);
    }

    public void save(HardSkill hardSkill) {
        iHSRepository.save(hardSkill);
    }

    public void delete(int id) {
        iHSRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iHSRepository.existsById(id);
    }

    public boolean existsByNombreEdu(String nombreHS) {
        return iHSRepository.existsByNombreHS(nombreHS);
    }
}
