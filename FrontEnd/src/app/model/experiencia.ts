export class Experiencia {
id?: number;
nombreE:string;
descripcionE:string;
fechaE:string;

    constructor(nombreE:string, descripcionE:string, fechaE:string){
        this.nombreE=nombreE;
        this.descripcionE= descripcionE;
        this.fechaE= fechaE;
    }
}
