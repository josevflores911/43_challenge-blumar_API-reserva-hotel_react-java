import './App.css'
import { Route, Routes  } from "react-router-dom";
import Header from './components/Header'

import routesConfig from './environment/paths'
import Subheader from './components/Subheader';


function App() {
  return (
    <>
      <Subheader/>
      <Header></Header>
       <div>
          <Routes>
            {routesConfig.map(({ path, element }, index) => (
              <Route key={index} path={path} element={element} />
            ))}
        </Routes>
      </div>
    </>
  )
}

export default App


// npm install -D tailwindcss postcss autoprefixer
// npx tailwindcss init -p

// if you are using CRA (create react app), use process.env.
// if you are using ViteJS, use import.meta.env.

//useNavigate ->  useHistory
//Link -> navlink
//Switch ->Routes