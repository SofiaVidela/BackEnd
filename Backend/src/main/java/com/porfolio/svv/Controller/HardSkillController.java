package com.porfolio.svv.Controller;

import com.porfolio.svv.Dto.dtoHardSkill;
import com.porfolio.svv.Entity.HardSkill;
import com.porfolio.svv.Security.Controller.Mensaje;
import com.porfolio.svv.Service.HardSkillService;
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
@RequestMapping("/hS")
@CrossOrigin(origins = "http://localhost:4200")
public class HardSkillController {

    @Autowired
    HardSkillService hSService;

    @GetMapping("/lista")
    public ResponseEntity<List<HardSkill>> list() {
        List<HardSkill> list = hSService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkill> getById(@PathVariable("id") int id) {
        if (!hSService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HardSkill hS = hSService.getOne(id).get();
        return new ResponseEntity(hS, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!hSService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        hSService.delete(id);

        return new ResponseEntity(new Mensaje("Hard skill eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHardSkill dtoHS) {
        if (StringUtils.isBlank(dtoHS.getNombreHS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (hSService.existsByNombreHS(dtoHS.getNombreHS())) {
            return new ResponseEntity(new Mensaje("Ese hard skill existe"), HttpStatus.BAD_REQUEST);
        }

        HardSkill hardSkill = new HardSkill(dtoHS.getNombreHS(), dtoHS.getPorcentajeHS(), dtoHS.getDescripcionHS());
        hSService.save(hardSkill);

        return new ResponseEntity(new Mensaje("Hard skill agregado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHardSkill dtoHS) {
        //Validacion de ID
        if (!hSService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Comparacion de nombres
        if (hSService.existsByNombreHS(dtoHS.getNombreHS()) && hSService.getByNombreHS(dtoHS.getNombreHS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese hard skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoHS.getNombreHS())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        HardSkill hardSkill = hSService.getOne(id).get();
        hardSkill.setNombreHS(dtoHS.getNombreHS());
        hardSkill.setDescripcionHS(dtoHS.getDescripcionHS());
        hardSkill.setPorcentajeHS(dtoHS.getPorcentajeHS());

        hSService.save(hardSkill);
        return new ResponseEntity(new Mensaje("Hard skill actualizada"), HttpStatus.OK);
    }
}
