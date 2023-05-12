export class persona{
    id?: number;
    nombre: string;
    apellido: string;
    descripcionDM: string;
    subtitulo: string;
    descripcionHS: string;
    descripcionSS: string;
    img: string;

    constructor (nombre: string,apellido: string, img: string, descripcionDM: string,subtitulo:string, descripcionHS: string, descripcionSS: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcionDM = descripcionDM;
        this.subtitulo = subtitulo;
        this.descripcionHS = descripcionHS;
        this.descripcionSS = descripcionSS;
    }
}