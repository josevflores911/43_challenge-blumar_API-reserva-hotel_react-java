import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes ,Link } from "react-router-dom";
import Header from './components/Header'
import Formulario from './pages/FormularioReserva'
import Hoteles from './pages/Hoteles'

import routesConfig from './environment/paths'

import { SLIDES } from './slides'

function App() {
 

  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <Header></Header>

      

       <div>
          <Routes>
            {routesConfig.map(({ path, element }, index) => (
              <Route key={index} path={path} element={element} />
            ))}
        </Routes>
      </div>
      

      {/* {<Formulario></Formulario>} */}
      {/* {<Hoteles slides={SLIDES}></Hoteles>} */}
     
    </>
  )
}

export default App
