import React, { Component } from 'react';
import Waiters from '../containers/WaiterQuery/Waiters';


class Waiter extends Component {
  
  render() {
    return (
        <div>
          <br></br>
          <h2>Camareros</h2>
          <h6>Clientes con gastos mayores a $100,000</h6>
          <hr></hr>
          <Waiters/>
        </div>
    );
  }
}

export default Waiter;