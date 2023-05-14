package com.porfolio.svv.Controller;

import com.porfolio.svv.Dto.dtoSoftSkill;
import com.porfolio.svv.Entity.SoftSkill;
import com.porfolio.svv.Security.Controller.Mensaje;
import com.porfolio.svv.Service.SoftSkillService;
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
@RequestMapping("/sS")
@CrossOrigin(origins = "http://localhost:4200")
public class SoftSkillController {

    @Autowired
    SoftSkillService sSService;

    @GetMapping("/lista")
    public ResponseEntity<List<SoftSkill>> list() {
        List<SoftSkill> list = sSService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkill> getById(@PathVariable("id") int id) {
        if (!sSService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        SoftSkill sS = sSService.getOne(id).get();
        return new ResponseEntity(sS, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!sSService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        sSService.delete(id);

        return new ResponseEntity(new Mensaje("Soft skill eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSoftSkill dtoSS) {
        if (StringUtils.isBlank(dtoSS.getNombreSS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sSService.existsByNombreSS(dtoSS.getNombreSS())) {
            return new ResponseEntity(new Mensaje("Ese skill existe"), HttpStatus.BAD_REQUEST);
        }

        SoftSkill softSkill = new SoftSkill(dtoSS.getNombreSS(), dtoSS.getPorcentajeSS());
        sSService.save(softSkill);

        return new ResponseEntity(new Mensaje("Soft skill agregado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSoftSkill dtoSS) {
        //Validacion de ID
        if (!sSService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Comparacion de nombres
        if (sSService.existsByNombreSS(dtoSS.getNombreSS()) && sSService.getByNombreSS(dtoSS.getNombreSS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese hard skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoSS.getNombreSS())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        SoftSkill softSkill = sSService.getOne(id).get();
        softSkill.setNombreSS(dtoSS.getNombreSS());
        softSkill.setPorcentajeSS(dtoSS.getPorcentajeSS());

        sSService.save(softSkill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
}
