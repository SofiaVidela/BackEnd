import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaService } from 'src/app/service/experiencia-service';
import { TokenService } from 'src/app/service/token.service';


@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  expeArray: Experiencia[] = [];
  expe: Experiencia = null;

  constructor(private experienciaServ: ExperienciaService,
    private tokenService: TokenService) { }

  //variablesNuevas 
  nombreE: string = '';
  descripcionE: string = '';
  fechaE: string = '';
  isLogged = false;
  isEdit = false;

  ngOnInit(): void {
    this.cargarExperiencia();

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
  cargarExperiencia(): void {
    this.experienciaServ.lista().subscribe(data => { this.expeArray = data; })
  }
  onCreate(): void {
    const experiencia = new Experiencia(this.nombreE, this.descripcionE, this.fechaE);
    this.experienciaServ.save(experiencia).subscribe(
      data => {
        alert('Experiencia agregada');
        this.cargarExperiencia();
      }, err => {
        alert('Algo salió mal y la experiencia no fue agregada');
      }
    )
  }
  delete(id?: number) {
    if (id != undefined) {
      this.experienciaServ.delete(id).subscribe(
        data => {
          this.cargarExperiencia();
          alert("Experiencia eliminada");
        }, err => {
          alert("No se pudo borrar la experiencia");
        }
      )
    }
  }
    editar(id?: number): void {
    if(id != undefined){
    this.experienciaServ.detail(id).subscribe(
      data => {
        this.expe = data;
        this.isEdit = true;
      }, err => {
        this.isEdit = false;
      });}
  }
  onUpdate(): void {
    
    this.experienciaServ.update(this.expe.id, this.expe).subscribe(
      data => {
        this.cargarExperiencia();
        this.isEdit = false;
        alert("Experiencia editada");
      },
      err => {
        alert("No se pudo editar la experiencia");
        this.isEdit = false;
      }
    );
  }


}
