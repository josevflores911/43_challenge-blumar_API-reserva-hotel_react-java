import "./App.css";
import { Route, Routes } from "react-router-dom";
import Header from "./containers/Header";

import routesConfig from "./environment/paths";
import Subheader from "./containers/Subheader";

import { useNavigate } from 'react-router-dom';
import Button from "./components/Button";

function App() {
  const navigateTo = useNavigate();

  const handleClick = (event) => {
    event.preventDefault(); 
      
        navigateTo("/");
    };
  return (
    <div className="flex font-mono font-semibold">

      {/*  lateral sidebar hoverable */ }
      <div className="flex w-[50px] bg-sky-200 h-screen ">
        <div className="mt-10">

          <Button onClick={handleClick}>go</Button>
        </div>
        
      </div>

      <div className="w-[100%] flex flex-col bg-sky-800" >
        <div className="bg-sky-800">
          <Subheader />
          <Header></Header>
        </div>

        <div className="bg-orange-50">
          <Routes>
            {routesConfig.map(({ path, element }, index) => (
              <Route key={index} path={path} element={element} />
            ))}
          </Routes>
        </div>
        
      </div>
    </div>
  );
}

export default App;

// npm install -D tailwindcss postcss autoprefixer
// npx tailwindcss init -p

// if you are using CRA (create react app), use process.env.
// if you are using ViteJS, use import.meta.env.

//useNavigate ->  useHistory
//Link -> navlink
//Switch ->Routes
