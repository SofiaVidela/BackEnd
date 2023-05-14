
package com.porfolio.svv.Service;

import com.porfolio.svv.Entity.Experiencia;
import com.porfolio.svv.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired IExperienciaRepository iExperienciaRepository;
    public List<Experiencia>list(){
        return iExperienciaRepository.findAll();
    }
    public Optional<Experiencia>getOne(int id ){
        return iExperienciaRepository.findById(id);
    }
    public Optional<Experiencia>getByNombreE(String nombreE){
        return iExperienciaRepository.findByNombreE(nombreE);
    }
    public void save(Experiencia experiencia){
        iExperienciaRepository.save(experiencia);
    }
    public void delete(int id){
        iExperienciaRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return iExperienciaRepository.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
       return iExperienciaRepository.existsByNombreE(nombreE);
    }
}
