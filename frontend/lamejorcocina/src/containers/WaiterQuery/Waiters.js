import React, { Component } from 'react';

//import axios from '../../axios-orders';
import axios from 'axios';

const divStyle = {
    display: 'block',
    overflow: 'auto',
    space: 'nowrap'
};

class Waiters extends Component {

    state = {
        clients: []
    }

    componentDidMount() {
        this.loadWaiters();
    }

    loadWaiters() {
        axios.get('http://localhost:8080/camareros/api/listaFacturadoTotal_rest')
            .then(response => {
                console.log(response);
                let aux = response.data.map(e =>{
                    return ({
                        id: e.id,
                        name: e.nombre,
                        lastname: e.apellido1,
                        secondLastname: e.apellido2,
                        facturado: e.facturado,
                        enero: e.enero,
                        febrero: e.febrero,
                        marzo: e.marzo,
                        abril: e.abril,
                        mayo: e.mayo,
                        junio: e.junio,
                        julio: e.julio,
                        agosto: e.agosto,
                        septiembre: e.septiembre,
                        octubre: e.octubre,
                        noviembre: e.noviembre,
                        diciembre: e.diciembre
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
                <table className="table table-bordered table-striped" style={divStyle}>
                    <thead className="thead-dark">
                        <tr>
                            <th>Nombre</th>
                            <th>Primer Apellido</th>
                            <th>Segundo Apellido</th>
                            <th>Total Facturado</th>
                            <th>Enero</th>
                            <th>Febrero</th>
                            <th>Marzo</th>
                            <th>Abril</th>
                            <th>Mayo</th>
                            <th>Junio</th>
                            <th>Julio</th>
                            <th>Agosto</th>
                            <th>Septiembre</th>
                            <th>Octubre</th>
                            <th>Noviembre</th>
                            <th>Diciembre</th>
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
                                        <td>$ <span>{e.facturado}</span></td>	
                                        <td>$ <span>{e.enero}</span></td>
                                        <td>$ <span>{e.febrero}</span></td>
                                        <td>$ <span>{e.marzo}</span></td>
                                        <td>$ <span>{e.abril}</span></td>
                                        <td>$ <span>{e.mayo}</span></td>
                                        <td>$ <span>{e.junio}</span></td>
                                        <td>$ <span>{e.julio}</span></td>
                                        <td>$ <span>{e.agosto}</span></td>
                                        <td>$ <span>{e.septiembre}</span></td>
                                        <td>$ <span>{e.octubre}</span></td>
                                        <td>$ <span>{e.noviembre}</span></td>
                                        <td>$ <span>{e.diciembre}</span></td>
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

export default Waiters;