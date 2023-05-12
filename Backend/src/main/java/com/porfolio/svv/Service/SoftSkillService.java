
package com.porfolio.svv.Service;

import com.porfolio.svv.Entity.SoftSkill;
import com.porfolio.svv.Repository.ISoftSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftSkillService {
    @Autowired ISoftSkillRepository iSHRepository;
    
        public List<SoftSkill>list(){
        return iSHRepository.findAll();
    }
    public Optional<SoftSkill>getOne(int id ){
        return iSHRepository.findById(id);
    }
    public Optional<SoftSkill>getByNombreSS(String nombreSS){
        return iSHRepository.findByNombreSS(nombreSS);
    }
    public void save(SoftSkill softSkill){
        iSHRepository.save(softSkill);
    }
    public void delete(int id){
        iSHRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return iSHRepository.existsById(id);
    }
    public boolean existsByNombreSS(String nombreSS){
       return iSHRepository.existsByNombreSS(nombreSS);
    }
}
