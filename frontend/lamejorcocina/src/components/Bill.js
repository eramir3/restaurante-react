import React, { Component } from 'react';
import Checkout from '../containers/Checkout/Checkout';

class Bill extends Component {
  
  render() {
    return (
        <div>
          <br></br>
          <h4>Registrar Factura</h4>
          <hr></hr>
          <Checkout/>
        </div>
    );
  }
}

export default Bill;