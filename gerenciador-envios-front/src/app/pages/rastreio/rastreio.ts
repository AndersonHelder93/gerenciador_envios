import { Component } from '@angular/core';
import { EnvioService } from '../../services/envioService';
import { Envio } from '../../model/envio';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-rastreio',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './rastreio.html'
})
export class RastreioComponent {

  codigo = '';
  envio?: Envio;

  constructor(private envioService: EnvioService) {}

  buscar() {
    this.envioService.buscarPorCodigo(this.codigo)
      .subscribe(res => this.envio = res);
  }
}
