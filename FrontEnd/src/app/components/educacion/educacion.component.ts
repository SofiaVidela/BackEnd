import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion-service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  eduArray: Educacion[] = [];
  edu: Educacion = null;

  constructor(private educacionServ: EducacionService,
    private tokenService: TokenService) { }
  //variablesNuevas
  nombreEdu: string = '';
  descripcionEdu: string = '';
  fechaEdu: string = '';
  isLogged = false;
  isEdit = false;
  ngOnInit(): void {
    this.cargarEducacion();

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
  cargarEducacion(): void {

    this.educacionServ.lista().subscribe(data => { this.eduArray = data; })
  }

  onCreate(): void {
    const educacion = new Educacion(this.nombreEdu, this.descripcionEdu, this.fechaEdu);
    this.educacionServ.save(educacion).subscribe(
      data => {
        alert('Educacion agregada');
        this.cargarEducacion();
      }, err => {
        alert('Algo salió mal y la educacion no fue agregada');
      }
    )
  }

  delete(id?: number) {
    if (id != undefined) {
      this.educacionServ.delete(id).subscribe(
        data => {
          this.cargarEducacion();
          alert("Educacion eliminada");
        }, err => {
          alert("No se pudo borrar la educacion");
        }
      )
    }
  }

  editar(id?: number): void {
    if(id != undefined){
    this.educacionServ.detail(id).subscribe(
      data => {
        this.edu = data;
        this.isEdit = true;
      }, err => {
        this.isEdit = false;
      });}
  }
  onUpdate(): void {
    
    this.educacionServ.update(this.edu.id, this.edu).subscribe(
      data => {
        this.cargarEducacion();
        this.isEdit = false;
        alert("Educación editada");
      },
      err => {
        alert("No se pudo editar la educación");
        this.isEdit = false;
      }
    );
  }

}
