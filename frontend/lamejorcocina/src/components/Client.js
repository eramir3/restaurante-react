import React, { Component } from 'react';
import Clients from '../containers/ClientQuery/Clients';


class Cliente extends Component {
  
  render() {
    return (
        <div>
          <br></br>
          <h4>Clientes</h4>
          <h6>Clientes con gastos mayores a $100,000</h6>
          <hr></hr>
          <Clients/>
        </div>
    );
  }
}

export default Cliente;