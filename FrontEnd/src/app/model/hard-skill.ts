export class HardSkill {
    id : number;
    nombreHS: string;
    porcentajeHS: number;
    descripcionHS: string;

    constructor(nombreHS:string,porcentajeHS:number,descripcionHS:string){
        this.nombreHS = nombreHS;
        this.porcentajeHS = porcentajeHS;
        this.descripcionHS = descripcionHS;
    }
}
