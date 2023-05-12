
package com.porfolio.svv.Service;

import com.porfolio.svv.Entity.Proyecto;
import com.porfolio.svv.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired IProyectoRepository iPoyectoRepository;
    
        public List<Proyecto>list(){
        return iPoyectoRepository.findAll();
    }
    public Optional<Proyecto>getOne(int id ){
        return iPoyectoRepository.findById(id);
    }
    public Optional<Proyecto>getByNombreP(String nombreP){
        return iPoyectoRepository.findByNombreP(nombreP);
    }
    public void save(Proyecto proyecto){
        iPoyectoRepository.save(proyecto);
    }
    public void delete(int id){
        iPoyectoRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return iPoyectoRepository.existsById(id);
    }
    public boolean existsByNombreP(String nombreP){
       return iPoyectoRepository.existsByNombreP(nombreP);
    }
    
}
