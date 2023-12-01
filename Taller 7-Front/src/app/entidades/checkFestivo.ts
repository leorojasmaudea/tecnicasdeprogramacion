export class ListaFestivo {
    constructor(public festivo:number,public fecha:Date){}
}

export class CheckFestivo {
    constructor(public esFestivo:boolean,public mensaje:string){
        
    }
}