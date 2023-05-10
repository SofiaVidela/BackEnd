
package com.porfolio.svv.Controller;

import com.porfolio.svv.Dto.dtoExperiencia;
import com.porfolio.svv.Entity.Experiencia;
import com.porfolio.svv.Security.Controller.Mensaje;
import com.porfolio.svv.Service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencialab")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired ExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity <List<Experiencia>>list(){
        List<Experiencia>list =experienciaService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
         @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }  
    @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete (@PathVariable("id")int id){
        //Validamos si existe el ID
        if (!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        experienciaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if (experienciaService.existsByNombreE(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"),HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(),dtoExp.getDescripcionE(),dtoExp.getFechaE());
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"),HttpStatus.OK);
    }
    

   @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update (@PathVariable("id")int id,@RequestBody dtoExperiencia dtoExp){
        //Validacion de existencia de ID
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje ("El Id no existe"),HttpStatus.BAD_REQUEST);
        //Comparacion de nombres de experiencia
        if(experienciaService.existsByNombreE(dtoExp.getNombreE())&& experienciaService.getByNombreE(dtoExp.getNombreE()).get().getId()!=id)
            return new ResponseEntity(new Mensaje ("Esa experincia ya existe"),HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia= experienciaService.getOne(id).get();
        experiencia.setNombreE(dtoExp.getNombreE());
        experiencia.setDescripcionE(dtoExp.getDescripcionE());
        experiencia.setFechaE(dtoExp.getFechaE());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"),HttpStatus.OK);
    }
}
