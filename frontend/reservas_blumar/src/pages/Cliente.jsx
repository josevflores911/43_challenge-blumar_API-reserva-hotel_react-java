import React, { useState } from "react";

export default function Cliente() {
    const handleChange = (e) => {
        
        console.log(e);
    };
    
    const handleSubmit = (e) => {
        e.preventDefault();
    
        console.log(e);
    
     
      };
  return (
    <div
      style={{
        background: " rgba(7, 6, 7, 0.3)",
        margin: "10px",
        padding: "30px 20px",
        width: "600px",
        height: "400px",
      }}
    >
      <form onSubmit={handleSubmit}>
        <label>
          {" "}
          Nome do Cliente:
          <input
            type="text"
            name="nome"
            value={"formData.nome"}
            onChange={handleChange}
          />
        </label>

        <button type="button">Submit</button>
      </form>
    </div>
  );
}
