import React, { useState } from "react";
import axios from "axios";
import { FormState } from "../entidades/formState";
import { RoomType } from "../entidades/roomEnum";


const ReservationForm = () => {
  const [formData, setFormData] = useState(new FormState());

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post( "http://localhost:8080/reservas",formData );
      console.log("Reservation created:", response.data);

     
      setFormData(new FormState());
    } catch (error) {
      console.error("Error creating reservation:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div
        style={{
          display: "flex",
          flexDirection: "column",
          background: "rgba(7, 6, 7, 0.3)",
          margin: "10px",
          padding: "30px 20px",
          alignItems: "flex-end",
          width: "600px",
          height: "400px",
        }}
      >
        <label>
          CNPJ do Hotel:
          <input
            type="number"
            name="cnpjHotel"
            value={formData.cnpjHotel}
            onChange={handleChange}
            disabled
          />
        </label>

        <label>
          Nome do Cliente:
          <input
            type="text"
            name="nome"
            value={formData.nome}
            onChange={handleChange}
          />
        </label>

        <label>
          CPF Cliente:
          <input
            type="number"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>

        <label>
          Idade Cliente Responsável:
          <input
            type="number"
            name="idade"
            value={formData.idade}
            onChange={handleChange}
          />
        </label>

        <label>
          Acompanhante:
          <input
            type="checkbox"
            name="temAcompanhante"
            checked={formData.temAcompanhante}
            onChange={handleChange}
          />
        </label>

        {formData.temAcompanhante && (
          <>
            <label>
              Nome Acompanhante:
              <input
                type="text"
                name="nomeAcompanhante"
                value={formData.nomeAcompanhante}
                onChange={handleChange}
              />
            </label>

            <label>
              CPF Acompanhante:
              <input
                type="number"
                name="cpfAcompanhante"
                value={formData.cpfAcompanhante}
                onChange={handleChange}
              />
            </label>

            <label>
              Idade Acompanhante:
              <input
                type="number"
                name="idadeAcompanhante"
                value={formData.idadeAcompanhante}
                onChange={handleChange}
              />
            </label>
          </>
        )}

        <label>
          Tipo Quarto:
          <select
            name="tipoQuarto"
            value={formData.tipoQuarto}
            onChange={handleChange}
          >
            {Object.values(RoomType).map((type) => (
              <option key={type} value={type}>
                {type}
              </option>
            ))}
          </select>
        </label>

        <label>
          Saída:
          <input
            type="date"
            name="salida"
            value={formData.salida}
            onChange={handleChange}
          />
        </label>

        <button type="submit">Submit</button>
      </div>
    </form>
  );
};

export default ReservationForm;


// if you are using CRA (create react app), use process.env.
// if you are using ViteJS, use import.meta.env.