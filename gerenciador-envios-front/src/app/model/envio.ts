export interface Envio {
  produtoId: number;
  produtoNome: string;
  remetente: string;
  destinatario: string;
  status: string;
  dataEntrada: string;
  tipoFrete: string;
  valorEnvio: number;
  codRastreio: string;
}
