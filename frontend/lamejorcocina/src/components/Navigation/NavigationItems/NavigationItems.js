import React from 'react';

import NavigationItem from './NavigationItem/NavigationItem';

const navigationItems = () => (
    
    <div className="collapse navbar-collapse">
        <ul className="navbar-nav mr-auto">
            <NavigationItem link="/" exact>Registrar Factura</NavigationItem>
            <NavigationItem link="/clients">Consulta Clientes</NavigationItem>
            <NavigationItem link="/waiters">Consulta Camareros</NavigationItem>
        </ul>
    </div>
);

export default navigationItems;

