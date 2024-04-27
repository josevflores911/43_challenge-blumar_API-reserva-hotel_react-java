import React, { useState } from "react";
import axios from "axios";
import ClientSingleCard from "../components/ClientSingleCard";

export default function Cliente() {
  const [cpf, setCPF] = useState("");
  const [clients, setClients] = useState([]);
  const [error, setError] = useState(null);

  const fetchClientDetails = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/clientes/${cpf}`);
      setClients([response.data]);
      setError(null);
    } catch (error) {
      console.error("Erro ao buscar detalhes do cliente:", error);
      setError("Erro ao buscar detalhes do cliente");
    }
  };

  const fetchAllClients = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/clientes/all`);
      setClients(response.data);
      setError(null);
    } catch (error) {
      console.error("Erro ao buscar todos os clientes:", error);
      setError("Erro ao buscar todos os clientes");
    }
  };

  const handleCPFChange = (event) => {
    setCPF(event.target.value);
  };

  return (
    <div
      style={{
       
        margin: "10px",
        padding: "30px 20px",
       
       
      }}
    >
      <div>
        <label htmlFor="cpfInput">CPF:</label>
        <input
          type="number"
          id="cpfInput"
          value={cpf}
          onChange={handleCPFChange}
          placeholder="Digite o CPF..."
        />
      </div>
      <div>
        <button style={{ margin: "10px" }} onClick={fetchClientDetails}>
          Buscar Cliente
        </button>
        <button style={{ margin: "10px" }} onClick={fetchAllClients}>
          Buscar Todos
        </button>
      </div>

      {error && <p style={{ color: "red" }}>{error}</p>}

      <h2>Detalhes do Cliente</h2>

      <div className="flex flex-wrap">
      {clients.length > 0 &&
        clients.map((client) => (
          <ClientSingleCard client={client} key={client.idClient} />
        ))}

      </div>

      {clients.length === 0 && !error && <p>Nenhum cliente encontrado.</p>}
    </div>
  );
}
