import React from "react";
import reactLogo from '../assets/react.svg'
import viteLogo from '../../public/vite.svg'

export default function Subheader() {
  return (
    <div className="flex flex-row justify-center my-3">
      <div className="flex flex-row justify-center ">
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>

    </div>
    
   
  );
}
