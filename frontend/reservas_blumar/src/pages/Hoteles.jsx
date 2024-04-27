import React, { useState } from "react";
import Button from "../components/Button";
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
    <div className="m-[10px] px-[20px] py-[30px]" >
      
      <div className="flex flex-row justify-around m-4 p-4">
        <Button type="button" onClick={()=>restart()}>Restart</Button>
        <Button type="button" disabled={index === slides.length - 1} onClick={() => next()}>Next</Button>
        <Button type="button" disabled={index===0} onClick={()=>previous()}>Previous</Button>
        
        
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