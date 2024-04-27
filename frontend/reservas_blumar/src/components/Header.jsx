import React from "react";

import { useNavigate, Link } from "react-router-dom";

const Header = () => {

  const navigateTo = useNavigate();

  const handleTabChange = (route) => {
    navigateTo(route);
  };

  return (
    <div className='flex flex-row justify-between mx-10 my-1' >
      <Link to="/about" onClick={() => handleTabChange("reserva")}>
        <button onClick={(e) => e.preventDefault()}>Reserva</button>
      </Link>
      <Link to="/about" onClick={() => handleTabChange("cliente")}>
        <button onClick={(e) => e.preventDefault()}>Clientes</button>
      </Link>
      <Link to="/about" onClick={() => handleTabChange("hoteles")}>
        <button onClick={(e) => e.preventDefault()}>Hoteles</button>
      </Link>
      <Link to="/about" onClick={() => handleTabChange("formulario")}>
        <button onClick={(e) => e.preventDefault()}>Formulario</button>
      </Link>
    </div>
  );
};

export default Header;

