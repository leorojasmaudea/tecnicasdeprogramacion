import { Injectable } from '@angular/core';
import { environment } from "src/environments/environment"
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class FestivosServiceService {
  private apiUrl = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  verificarFestivo(year: number, month: number, day: number): Observable<any> {
    const dynamicUrl = `${this.apiUrl}/festivos/verificar/${year}/${month}/${day}`;
    return this.httpClient.get<any>(dynamicUrl);
  }  
  
  obtenerFestivos(year: number): Observable<any> {
    const dynamicUrl = `${this.apiUrl}/festivos/obtener/${year}`;
    return this.httpClient.get<any>(dynamicUrl);
  } 
}
