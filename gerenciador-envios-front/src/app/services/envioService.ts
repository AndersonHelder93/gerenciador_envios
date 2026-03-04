import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Envio } from '../model/envio';

@Injectable({
  providedIn: 'root'
})
export class EnvioService {

  private api = `${environment.apiUrl}/envios`;

  constructor(private http: HttpClient) {}

  criarEnvio(payload: any) {
    return this.http.post(this.api, payload);
  }

  buscarPorCodigo(codigo: string) {
    return this.http.get<Envio>(`${this.api}/${codigo}`);
  }

  atualizarStatus(codigo: string, status: string) {
    return this.http.patch(`${this.api}/${codigo}/status?status=${status}`, {});
  }
}
