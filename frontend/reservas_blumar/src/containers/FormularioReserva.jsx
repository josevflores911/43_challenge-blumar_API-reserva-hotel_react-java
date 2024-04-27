import React, { useState } from "react";
import axios from "axios";
import { FormState } from "../entidades/formState";
import { RoomType } from "../entidades/roomEnum";
import Button from "../components/Button";


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
      <div   className="flex flex-col m-10 p-8 items-start" >
        <label>
          CNPJ do Hotel:
          <input
            type="number"
            name="cnpjHotel"
            value={formData.cnpjHotel}
            onChange={handleChange}
            disabled
            className="m-3"
          />
        </label>

        <label>
          Nome do Cliente:
          <input
            type="text"
            name="nome"
            value={formData.nome}
            onChange={handleChange}
            className="m-3"
          />
        </label>

        <label>
          CPF Cliente:
          <input
            type="number"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
            className="m-3"
          />
        </label>

        <label>
          Idade Cliente Responsável:
          <input
            type="number"
            name="idade"
            value={formData.idade}
            onChange={handleChange}
            className="m-3"
          />
        </label>

        <label>
          Acompanhante:
          <input
            type="checkbox"
            name="temAcompanhante"
            checked={formData.temAcompanhante}
            onChange={handleChange}
            className="m-3"
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
                className="m-3"
              />
            </label>

            <label>
              CPF Acompanhante:
              <input
                type="number"
                name="cpfAcompanhante"
                value={formData.cpfAcompanhante}
                onChange={handleChange}
                className="m-3"
              />
            </label>

            <label>
              Idade Acompanhante:
              <input
                type="number"
                name="idadeAcompanhante"
                value={formData.idadeAcompanhante}
                onChange={handleChange}
                className="m-3"
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
            className="m-3"
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
            className="m-3"
          />
        </label>

        <Button type="submit">Submit</Button>
        
      </div>
    </form>
  );
};

export default ReservationForm;


