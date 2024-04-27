import React, { useState } from "react";
import axios from "axios";
import ClientSingleCard from "../components/ClientSingleCard";
import Button from "../components/Button";

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
    <div className="m-[10px] px-[20px] py-[30px]"  >
      <div className=" flex justify-between ">
        <Button onClick={fetchClientDetails}>Buscar Cliente</Button>
        <Button onClick={fetchAllClients}>Buscar Todos</Button>
      </div>
      
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
      

      {error && <p style={{ color: "red" }}>{error}</p>}

      <h2>Detalhes do Cliente</h2>

      <div className="flex flex-wrap">

      { clients.length > 0 &&
        clients.map((client) => (
          <ClientSingleCard client={client} key={client.idClient} />
        ))}

      </div>

      {clients.length === 0 && !error && <p>Nenhum cliente encontrado.</p>}
    </div>
  );
}
