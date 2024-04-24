import React, { useState } from "react";
import axios from 'axios';



export default function Reserva() {
    const [cpf, setCPF] = useState('');
    const [reservas, setReservas] = useState(null);
    const [error, setError] = useState(null);
  
    const fetchClientDetails = async () => {
      try {
        const response = await axios.get( `http://localhost:8080/reservas/cliente/${cpf}`);
        setReservas(response.data); 
        setError(null); 
      } catch (error) {
        console.error('Erro ao buscar detalhes do cliente:', error);
        setError('Erro ao buscar detalhes do cliente');
      }
    };
  
    const handleCPFChange = (event) => {
      setCPF(event.target.value);
  };
  

    const formatDate = (dateTimeString) => {
      const date = new Date(dateTimeString);
      
      if (isNaN(date)) {
        return ''; 
      }
      return date.toLocaleDateString('en-US');
    };

    return (
        <div  style={{
            background: " rgba(7, 6, 7, 0.3)",
            margin: "10px",
            padding: "30px 20px",
            width: "600px",
            height: "400px",
          }}>
        <label htmlFor="cpfInput">CPF:</label>
        <input
          type="text"
          id="cpfInput"
          value={cpf}
          onChange={handleCPFChange}
          placeholder="Digite o CPF..."
        />
        <button onClick={fetchClientDetails}>Buscar Reservas do Cliente</button>
  
        {error && <p>{error}</p>}
  
        <ul style={{listStyle:'none',display:'flex', flexWrap:'wrap'}}>
          {reservas && reservas.map((reserva) => (
          <div style={{backgroundColor:'white', borderRadius:'15px',padding:'10px',margin:'10px'}}>
            <li key={reserva.idReserva}>
              <p style={{display:'none'}}>ID da Reserva: {reserva.idReserva}</p>
              <p>Data de Entrada: {formatDate(reserva.dataEntrada)}</p>
                <p>Data de Saída: {() => { return new Date(reserva.dataSaida).toLocaleDateString('en-US')}}</p>
              <p>Valor Total da Reserva: {reserva.valorTotalReserva}</p>
              <p>Quantidade de Noites: {reserva.cantidadNoites}</p>
            </li>
          </div>
        ))}
      </ul>
      </div>
    
  );
}