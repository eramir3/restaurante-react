import React from 'react';

import NavigationItems from '../NavigationItems/NavigationItems';
import { NavLink } from 'react-router-dom';



const toolbar = (props) => (

    <header className="container">
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <NavLink 
            className="navbar-brand"
            to="/"
            exact={props.exact}>La Mejor Cocina</NavLink>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
        </button>
        <NavigationItems/>
        </nav>
    </header>
);

export default toolbar;