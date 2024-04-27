import React from 'react';
import { useNavigate } from 'react-router-dom';
import TabsContainer from '../components/TabsContainer';
import {headerPath} from '../environment/headerPath'

const Header = () => {
    const navigateTo = useNavigate();

    const handleTabChange = (route) => {
        navigateTo(route);
    };
    
    return <TabsContainer tabs={headerPath} handleTabChange={handleTabChange} />;
};

export default Header;