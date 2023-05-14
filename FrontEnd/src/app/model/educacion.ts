export class Educacion {
    id?: number;
    nombreEdu:string;
    descripcionEdu:string;
    fechaEdu:string;
    linkCertificado?:string;
    
        constructor(nombreEdu:string, descripcionEdu:string, fechaEdu:string, linkCertificado?:string){
            this.nombreEdu=nombreEdu;
            this.descripcionEdu= descripcionEdu;
            this.fechaEdu= fechaEdu;
            this.linkCertificado = linkCertificado;
        }
    }
    