import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import Switch from 'react-router-dom/Switch';
import 'bootstrap/dist/css/bootstrap.min.css';

import Layout from './hoc/Layout/Layout';
import Bill from './components/Bill';
import Clients from './components/Client';
import Waiters from './components/Waiter';


class App extends Component {

  render() {
    return (
      <div>
        <Layout>
          <Switch>
              <Route exact  path="/" component={Bill} />
              <Route path='/bill' component={Bill} />
              <Route path='/clients' component={Clients} />
              <Route path='/waiters' component={Waiters} />
          </Switch>
        </Layout>
      </div>
    );
  }
}

export default App;