import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {
  ProyArray: Proyecto[] = [];
  proy: Proyecto = null;
  constructor(private proyectoServ: ProyectoService,
    private tokenService: TokenService) { }
    nombreP: string = '';
    descripcionP: string = '';
    linkFotoP: string = '';
    linkProyectoP: string = '';
    isLogged = false;
    isEdit = false;

    ngOnInit(): void {
      this.cargarProyecto();
  
      if (this.tokenService.getToken()) {
        this.isLogged = true;
      } else {
        this.isLogged = false;
      }
    }
    cargarProyecto(): void {

      this.proyectoServ.lista().subscribe(data => { this.ProyArray = data; })
    }
    onCreate(): void {
      const proyecto = new Proyecto(this.nombreP, this.descripcionP, this.linkFotoP, this.linkProyectoP);
      this.proyectoServ.save(proyecto).subscribe(
        data => {
          alert('Proyecto agregado');
          this.cargarProyecto();
        }, err => {
          alert('Algo salió mal y el proyecto no fue agregado');
        }
      )
    }
    delete(id?: number) {
      if (id != undefined) {
        this.proyectoServ.delete(id).subscribe(
          data => {
            this.cargarProyecto();
            alert("Proyecto eliminado");
          }, err => {
            alert("No se pudo borrar el Proyecto");
          }
        )
      }
    }
    editar(id?: number): void {
      if(id != undefined){
      this.proyectoServ.detail(id).subscribe(
        data => {
          this.proy = data;
          this.isEdit = true;
        }, err => {
          this.isEdit = false;
        });}
    }

    onUpdate(): void {
    
      this.proyectoServ.update(this.proy.id, this.proy).subscribe(
        data => {
          this.cargarProyecto();
          this.isEdit = false;
          alert("Proyecto editado");
        },
        err => {
          alert("No se pudo editar el proyecto");
          this.isEdit = false;
        }
      );
    }
}
