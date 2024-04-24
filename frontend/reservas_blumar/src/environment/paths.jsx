import Hoteles from "../pages/Hoteles";
import Formulario from "../pages/FormularioReserva"
import { SLIDES } from "../slides";
import Cliente from "../pages/Cliente";
import Reserva from "../pages/Reserva";
import Home from "../pages/Home";

const routesConfig = [
    { path: '/', element: <Home/> },
    { path: '/hoteles', element: <Hoteles slides={SLIDES}/>  },
    { path: '/formulario', element: <Formulario/> },
    { path: '/cliente', element: <Cliente /> },
    { path: '/reserva', element: <Reserva/> }

  ];
  
  export default routesConfig;