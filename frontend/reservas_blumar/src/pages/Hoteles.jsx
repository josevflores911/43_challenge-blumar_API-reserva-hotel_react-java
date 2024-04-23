import React, { useState } from "react";
//import ima from '../images/pirat.png'


export default function Hoteles({ slides }) {

    const [index, setIndex] = useState(0);

    const next = () => {
        setIndex(i=>i+1)
    }

    const previous = () => {
        setIndex(i=>i-1)
    }

    const restart = () => {
        setIndex(0)
    }


  return (
    <div style={{ background: " rgba(7, 6, 7, 0.3)", margin: "10px", padding: "30px 20px", width:'600px', height:'400px'}}>
      
    <div style={{display:"flex",flexDirection:'row',justifyContent:'space-around',margin:'10px',padding:'10px'}}>
        <button style={{padding:'10px',backgroundColor:'tomato'}} onClick={()=>restart()} type="button">Restart</button>
        <button style={{padding:'10px',backgroundColor:'tomato'}} disabled={index===slides.length-1} type="button" onClick={()=>next()}>Next</button>
        <button style={{padding:'10px',backgroundColor:'tomato'}}  disabled={index===0} type="button" onClick={()=>previous()}>Previous</button>
      </div>
      <div>
              <h1>{ slides[index].title}</h1>
              <h2>{slides[index].text}</h2>
        <h2>{slides[index].date}</h2>
        <p>{slides[index].imag}</p>
        <img src={slides[index].imag} alt="" />
      </div>
    </div>
  );
}