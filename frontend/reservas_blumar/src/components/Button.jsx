import React from 'react';

const Button = ({ disabled, onClick, children, className,...props }) => {
  console.log(disabled)
    return (
      <button
        type={props.type}
            onClick={onClick}
        className={`bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded ${className}`}
        disabled={disabled}
        >
            {children}
        </button>
    );
};

export default Button;