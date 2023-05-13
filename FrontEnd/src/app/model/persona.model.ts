export class persona{
    id?: number;
    nombre: string;
    apellido: string;
    descripcionDM: string;
    subtitulo: string;
    descriPcionHS: string;
    descriPcionSS: string;
    img: string;

    constructor (nombre: string,apellido: string, img: string, descripcionDM: string,subtitulo:string, descriPcionHS: string, descriPcionSS: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcionDM = descripcionDM;
        this.subtitulo = subtitulo;
        this.descriPcionHS = descriPcionHS;
        this.descriPcionSS = descriPcionSS;
    }
}