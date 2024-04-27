import React from 'react';
import { Link } from 'react-router-dom';

const TabsContainer = ({ tabs, handleTabChange,...props }) => {
    return (
        <div className='flex flex-row justify-between mx-10 my-1'>
            {tabs.map(({ path, label, tabName }) => (
                <Link key={tabName} to={path} onClick={() => handleTabChange(tabName)}>
                    <button onClick={(e) => e.preventDefault()}>{label}</button>
                </Link>
            ))}
        </div>
    );
};

export default TabsContainer;
