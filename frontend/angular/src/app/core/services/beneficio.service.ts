import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Beneficio } from 'src/app/shared/models/beneficio.model';

@Injectable({
  providedIn: 'root'
})
export class BeneficioService {

  private baseUrl = 'http://localhost:8080/beneficios';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Beneficio[]> {
    return this.http.get<Beneficio[]>(this.baseUrl);
  }

  transfer(fromId: number, toId: number, amount: number): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/transfer`, { fromId, toId, amount });
  }
}