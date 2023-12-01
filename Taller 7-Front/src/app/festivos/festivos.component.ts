import { Component } from '@angular/core';
import { MatDatepickerInputEvent} from '@angular/material/datepicker';
import { FestivosServiceService } from '../servicios/festivos-service.service';
import { CheckFestivo, ListaFestivo } from '../entidades/checkFestivo';
import { FormBuilder, FormGroup,FormControl,Validators, } from '@angular/forms';




@Component({
  selector: 'app-festivos',
  templateUrl: './festivos.component.html',
  styleUrls: ['./festivos.component.css']
})


export class FestivosComponent {


  datosFestivos:any[] = [
        //{ festivo: 'dia de los muertos', fecha: "22 23"}
    //{ name: 'Jane Doe', age: 25, job: 'Designer' },
    // ... otros datos
  ];

  columnasFestivos = [
    { prop: 'festivo', name: 'Festivo' },
    { prop: 'fecha', name: 'Fecha' }
    // ... otras columnas
  ];

  datos:any= {};

  constructor(private festivosServiceService : FestivosServiceService,private formBuilder: FormBuilder) {
    this.datos = formBuilder.group({
      añoConsulta: new FormControl("", {validators: Validators.required, updateOn: 'blur'})
  }, {updateOn: 'change'});

// //Obtener los cambios onchange del formulario
//   this.datos.valueChanges.subscribe((total:any) => {
//     alert(total)
// // Lo que desees hacer
//   });

// //Validación de un solo valor del formulario
//   this.datos.get('totalIngresos').valueChanges.subscribe((total:any) => {
//     alert(total)
// // Lo que desees hacer
//   });
  }

  dateChanged(event: MatDatepickerInputEvent<Date>): void {
    let fecha:Date;
    fecha=event.value??new Date;
    
    console.log('Fecha seleccionada:',fecha);
    let dia: number = fecha.getDate();
    let mes: number = fecha.getMonth() + 1; // Nota: los meses comienzan desde 0
    let año: number = fecha.getFullYear();

    this.festivosServiceService.verificarFestivo(año, mes, dia).subscribe((data:CheckFestivo) => {
      alert(data.mensaje);
    });
  }

  consultaFestivos() : void {

    const valorAConsultar=this.datos.get('añoConsulta').value;
    alert(`Consultando el año ${valorAConsultar}`)
    
    this.festivosServiceService.obtenerFestivos(valorAConsultar).subscribe((data:ListaFestivo[]) => {
      const nuevoDato = { festivo: 'Nuevo Usuario', fecha: 28 };
      this.datosFestivos=[]
        
     // this.datosFestivos.push({ festivo: "test", fecha: "22 23" });
      data.forEach((element: ListaFestivo) => {
                
        this.datosFestivos.push({ festivo: element.festivo, fecha: element.fecha });
       // alert(element.festivo)




      });
    });    

  }
}