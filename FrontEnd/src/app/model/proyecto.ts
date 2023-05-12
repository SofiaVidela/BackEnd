export class Proyecto {
    id? : number;
    nombreP: string;
    descripcionP: string;
    linkFotoP: string;
    linkProyectoP: string;

    constructor(nombreP:string,descripcionP:string, linkFotoP: string, linkProyectoP: string){
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkFotoP = linkFotoP;
        this.linkProyectoP = linkProyectoP;
    }
}
