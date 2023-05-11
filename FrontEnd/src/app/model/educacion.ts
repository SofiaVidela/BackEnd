export class Educacion {
    id?: number;
    nombreEdu:string;
    descripcionEdu:string;
    fechaEdu:string;
    
        constructor(nombreEdu:string, descripcionEdu:string, fechaEdu:string){
            this.nombreEdu=nombreEdu;
            this.descripcionEdu= descripcionEdu;
            this.fechaEdu= fechaEdu;
        }
    }
    