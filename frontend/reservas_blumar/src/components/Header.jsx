import React from "react";

import { useNavigate, Link } from "react-router-dom";
//useNavigate  useHistory
const Header = ({ handleButtonClick }) => {
  const navigateTo = useNavigate();

  const handleTabChange = (route) => {
   
    navigateTo(route);
  };

  return (
    <div className="header" style={{display:"flex",justifyContent:'space-between',marginBottom:'20px'}}>
      <Link to="/about" onClick={() => handleTabChange("recibo")}>
        <button onClick={(e) => e.preventDefault()}>Recibo</button>
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
