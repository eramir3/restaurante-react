import React, { Component } from 'react';

//import axios from '../../axios-orders';
import axios from 'axios';

class Clients extends Component {

    state = {
        clients: []
    }

    componentDidMount() {
        this.loadClients();
    }

    loadClients() {
        axios.get('http://localhost:8080/clientes/api/listaImporteTotal_rest')
            .then(response => {

               let aux = response.data.map(e =>{
                    return ({
                        id: e.id,
                        name: e.nombre,
                        lastname: e.apellido1,
                        secondLastname: e.apellido2,
                        totalImport: e.importe
                    });
                });
                this.setState({clients: aux});                
            })
            .catch(error => {
                
            });
    }
    
    render() {

        return (
            <div>
                <table className="table table-bordered table-striped">
                    <thead className="thead-dark">
                        <tr>
                            <th>Nombre</th>
                            <th>Primer Apellido</th>
                            <th>Segundo Apellido</th>
                            <th>Importe Total</th>
                        </tr>
                    </thead>
                    {
                        this.state.clients.map(e => {
                            return (
                                <tbody key={e.id}>
                                    <tr>
                                        <td>{e.name}</td>	
                                        <td>{e.lastname}</td>	
                                        <td>{e.secondLastname}</td>
                                        <td>$ <span>{e.totalImport}</span></td>	
                                    </tr>
                                </tbody>
                            );
                        })
                    }		
                </table>
            </div>
        );
    }
}

export default Clients;