import React, { useState } from "react";
import axios from 'axios';

export default function Cliente() {
    const [cpf, setCPF] = useState('');
    const [client, setClient] = useState(null);
    const [error, setError] = useState(null);
  
    const fetchClientDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/clientes/${cpf}`);
        setClient(response.data); 
        setError(null); 
      } catch (error) {
        console.error('Erro ao buscar detalhes do cliente:', error);
        setError('Erro ao buscar detalhes do cliente');
      }
    };
  
    const handleCPFChange = (event) => {
      setCPF(event.target.value);
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
        <button onClick={fetchClientDetails}>Buscar Detalhes do Cliente</button>
  
        {error && <p>{error}</p>}
  
        {client && (
          <div>
            <h2>Detalhes do Cliente</h2>
            <p>Nome: {client.nome}</p>
            <p>CPF: {client.cpf}</p>
            <p>Idade: {client.idade}</p>
            
          </div>
        )}
      </div>





    
  );
}



// {<div
//     style={{
//       background: " rgba(7, 6, 7, 0.3)",
//       margin: "10px",
//       padding: "30px 20px",
//       width: "600px",
//       height: "400px",
//     }}
//   >
//     <form onSubmit={handleSubmit}>
//       <label>
//         {" "}
//         CPF do Cliente:
//         <input
//           type="text"
//           name="nome"
//           value={"formData.nome"}
//           onChange={handleChange}
//         />
//       </label>

//       <button type="button">Submit</button>
//     </form>

//     {client ? <p>Client: {"client.name"}</p> : <p>No clients available</p>}
//   </div>}