import { RoomType } from "./roomEnum";


export class FormState {
    constructor() {
      this.cnpjHotel = '123456789';
      this.nome = '';
      this.cpf = '';
      this.idade = '';
      this.temAcompanhante = false;
      this.nomeAcompanhante = '';
      this.cpfAcompanhante = '';
      this.idadeAcompanhante = '';
      this.tipoQuarto = RoomType.INDIVIDUAL;
      this.salida = '';
    }
  }