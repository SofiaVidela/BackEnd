import { Component, OnInit } from '@angular/core';
import { HardSkill } from 'src/app/model/hard-skill';
import { persona } from 'src/app/model/persona.model';
import { SoftSkill } from 'src/app/model/soft-skill';
import { HardSkillService } from 'src/app/service/hard-skill.service';
import { PersonaService } from 'src/app/service/persona.service';
import { SoftSkillService } from 'src/app/service/soft-skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  
  Persona:persona=null;
  hSArray: HardSkill[]= [];
  hardSkill: HardSkill = null; 

  constructor(private personaService:PersonaService,private hSService: HardSkillService,
    private tokenService: TokenService) { }

  //Variables boleanas
  isLogged = false;
  isEditHS = false;
  isEditDescriP = false; 

  //Variables del HS
  nombreHS: string ;
  porcentajeHS: number ;
  descripcionHS: string ;


  ngOnInit(): void {
    this.cargarSkills();

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
  cargarSkills(): void {
    this.hSService.lista().subscribe(data => { this.hSArray = data; })
    this.personaService.detail(1).subscribe(data=>{this.Persona = data;})
  }
  onCreateHS(): void {
    const hardSkill = new HardSkill(this.nombreHS, this.porcentajeHS, this.descripcionHS);
    this.hSService.save(hardSkill).subscribe(
      data => {
        alert('Skill agregado');
        this.cargarSkills();
      }, err => {
        alert('Algo salió mal y no se agregó el skill');
      }
    )
  }
  deleteHS(id: number) {
    if (id != undefined) {
      this.hSService.delete(id).subscribe(
        data => {
          this.cargarSkills();
          alert("Skill eliminado");
        }, err => {
          alert("No se pudo borrar");
        }
      )
    }
  }
  editarHS(id: number): void {
    if (id != undefined) {
      this.hSService.detail(id).subscribe(
        data => {
          this.hardSkill = data;
          this.isEditHS = true;
        }, err => {
          this.isEditHS = false;
        });
    }
  }
  editarDescriP(): void {
      this.personaService.detail(1).subscribe(
        data => {
          this.Persona = data;
        }, err => {
        });
    
  }

  onUpdate(): void {
    if (this.isEditHS) {
      this.hSService.update(this.hardSkill.id, this.hardSkill).subscribe(
        data => {
          this.cargarSkills();
          this.isEditHS = false;
          alert("Editado correctamente");
        },
        err => {
          alert("Error al editar");
          this.isEditHS = false;
        });}
  }

  onUpdateIP(): void {
    
    this.personaService.update(1, this.Persona).subscribe(
      data => {
        this.cargarSkills();
        alert("Informacion personal editada");
      },
      err => {
        alert("No se pudo editar la informacion Personal");
      }
    );
  }

}
