import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaService } from 'src/app/service/experiencia-service';
import { TokenService } from 'src/app/service/token.service';


@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  expe: Experiencia[] = [];

 constructor(private experienciaServ: ExperienciaService, private tokenService: TokenService) { }
    //variablesNuevas
  nombreE: string = '';
  descripcionE: string = '';
  fechaE: string = '';
  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
  cargarExperiencia(): void {
    this.experienciaServ.lista().subscribe(data => { this.expe = data; })
  }
  onCreate(): void {
    const experiencia = new Experiencia(this.nombreE, this.descripcionE, this.fechaE);
    this.experienciaServ.save(experiencia).subscribe(
      data => {
        alert('Experiencia agregada');
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
        }, err => {
          alert("No se pudo borrar la experiencia");
        }
      )
    }
  }
}
