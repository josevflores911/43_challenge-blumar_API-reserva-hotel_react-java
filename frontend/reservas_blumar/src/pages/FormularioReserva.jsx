import React, { useState } from "react";
import { FormState } from "../entidades/formState";

const ReservationForm = () => {
  const [formData, setFormData] = useState(new FormState());

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log(formData);

    setFormData(new FormState());
  };

  return (
    <form
      onSubmit={handleSubmit}
    >
      <div style={{
        display: "flex",
        flexDirection: "column",
        background: " rgba(7, 6, 7, 0.3)",
        margin: "10px",
        padding: "30px 20px",
        alignItems: "flex-end"
        , width:'600px', height:'400px'
      }}>
        <label>
          {" "}
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
          {" "}
          Nome do Cliente:
          <input
            type="text"
            name="nome"
            value={formData.nome}
            onChange={handleChange}
          />
        </label>

        <label>
          {" "}
          CPF Ciente:
          <input
            type="number"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>

        <label>
          {" "}
          Idade Cliente Responsavel:
          <input
            type="number"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>

        <label>
          {" "}
          Acompanhante:
          <input
            type="checkbox"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>

        <label>
          {" "}
          Nome Acompanhante:
          <input
            type="number"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>

        <label>
          {" "}
          CPF Acompanhante:
          <input
            type="number"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>

        <label>
          {" "}
          Idade Acompanhante:
          <input
            type="number"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>

        <label>
          {" "}
          Tipo Quarto:
          <input
            type="number"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>

        <label>
          {" "}
          Salida:
          <input
            type="date"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
          />
        </label>
      </div>

      {/* Add more fields as needed */}
      <button type="button">Submit</button>
    </form>
  );
};

export default ReservationForm;
