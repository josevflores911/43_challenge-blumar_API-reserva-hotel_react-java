vali,unit,excep,refact
# 43_challenge-blumar_API-reserva-hotel_react-java
# Desafio Back-end Java - Serviço de Check-in em Hotel

Este repositório contém um serviço REST em Java implementado com Spring para realizar o check-in (entrada) dos clientes em um hotel específico, seguindo as regras de negócio definidas.

## Funcionalidades

O serviço oferece as seguintes funcionalidades:

- Receber o nome do cliente responsável pela reserva, o tipo de quarto desejado e a data final da reserva.
- Assumir que a data inicial da reserva é a data atual da requisição.
- Validar a disponibilidade de quartos para permitir ou não a hospedagem.
- Confirmar a reserva retornando informações para o recibo do cliente, incluindo:
  - Número da reserva
  - Nome do cliente
  - Número do quarto
  - Tipo de quarto escolhido
  - Data de check-in (entrada)
  - Data de check-out (saída)
  - Número de noites da hospedagem
  - Valor total da reserva

## Regras de Negócio

O hotel possui a seguinte política de preços:

- Diária do quarto para hospedagem individual:
  - Segunda a quinta-feira: R$100
  - Sexta a domingo: R$120

- Diária do quarto para hospedagem com acompanhante:
  - Segunda a quinta-feira: R$130
  - Sexta a domingo: R$150

- Diária do quarto para hospedagem com criança:
  - Segunda a quinta-feira: R$160
  - Sexta a domingo: R$180

## Execução do Projeto

### Clonar o Repositório:

```bash
git clone https://github.com/seu-usuario/desafio-back-end-java.git
```
Importar o Projeto no IntelliJ IDEA (ou IDE de preferência):
Abra o IntelliJ IDEA e selecione "File" > "Open".
Navegue até o diretório clonado e selecione a pasta do projeto.
Executar o Projeto:
Localize e execute a classe principal DesafioBackEndJavaApplication.java.
O serviço estará disponível em http://localhost:8080.
Estrutura do Projeto
A estrutura do projeto está organizada da seguinte maneira:

src/main/java: Contém os arquivos-fonte do projeto Java.
src/main/resources: Contém os recursos configuracionais, como arquivos application.properties.


<h3>end points</h3>

### GET /clientes/all

lista todos os clientes.

Endpoint: `http://localhost:8080/clientes/all`

---

### GET /reservas/all

lista todos os reservas.

Endpoint: `http://localhost:8080/reservas/all`

---

### POST /reservas

Cria uma reserva.

Endpoint: `http://localhost:8080/reservas`

Request Body:

```json
{
  "cnpjHotel": 123456789,
  "nome": "Maria",
  "cpf": 65489412321,
  "idade": 34,
  "temAcompanhante": true,
  "nomeAcompanhante": "Carlos",
  "cpfAcompanhante": 14654365461,
  "idadeAcompanhante": 18,
  "tipoQuarto": "CASAL",
  "salida": "2024-04-24"
}


```
<h3>diagrama de entidades</h3>
<div style="border: 2px solid #ccc; padding: 10px; display: inline-block;">
  <img src="https://github.com/josevflores911/43_challenge-blumar_API-reserva-hotel_react-java/assets/59713685/9f9c53d3-2e2b-44e4-a8ac-aafde886e037" alt="Image Alt Text" width="400" height="200">
</div>
<hr></hr>

<div style="border: 2px solid #ccc; padding: 10px; display: inline-block;">
  <img src="https://github.com/josevflores911/43_challenge-blumar_API-reserva-hotel_react-java/assets/59713685/fdd3155c-9d2a-4787-aa35-64ea1f60ded3" alt="Image Alt Text" width="400" height="200">
</div>
