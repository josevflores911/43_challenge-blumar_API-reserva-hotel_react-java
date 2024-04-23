
const RoomType = {
    INDIVIDUAL: 'INDIVIDUAL',
    FAMILIAR: 'FAMILIAR',
    CASAL: 'CASAL',
    PRESIDENCIAL: 'PRESIDENCIAL'
  };

export class FormState {
    constructor() {
      this.cnpjHotel = '';
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