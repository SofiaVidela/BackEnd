
package com.porfolio.svv.Service;

import com.porfolio.svv.Entity.Educacion;
import com.porfolio.svv.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired IEducacionRepository iEducacionRepository;
    
    public List<Educacion>list(){
        return iEducacionRepository.findAll();
    }
    public Optional<Educacion>getOne(int id ){
        return iEducacionRepository.findById(id);
    }
    public Optional<Educacion>getByNombreEdu(String nombreEdu){
        return iEducacionRepository.findByNombreEdu(nombreEdu);
    }
    public void save(Educacion educacion){
        iEducacionRepository.save(educacion);
    }
    public void delete(int id){
        iEducacionRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return iEducacionRepository.existsById(id);
    }
    public boolean existsByNombreEdu(String nombreEdu){
       return iEducacionRepository.existsByNombreEdu(nombreEdu);
    }
}
