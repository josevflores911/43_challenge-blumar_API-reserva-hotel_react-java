# 43_challenge-blumar_API-reserva-hotel_react-java
servico REST java-spring para realizar o check-in dos clientes en um hotel

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
