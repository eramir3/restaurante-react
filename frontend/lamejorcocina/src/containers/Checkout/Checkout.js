import React, { Component } from 'react';

import SmallCard from '../../components/UI/Card/SmallCard/SmallCard';
//import axios from '../../axios-orders';
import axios from 'axios';
import Button from '../../components/UI/Button/Button';
import Input from '../../components/UI/Input/Input';
import Dish from '../../components/Bill/BillDetails/Dish';


const divStyle = {
    padding: '20px'
};

class Checkout extends Component {

    state = {
        counter: 0,
        dishes:  {},
        orderForm: {
            date: {
                elementTitle: 'Fecha',
                elementType: 'date',
                elementConfig: {
                    
                },
                value: ''
            },
            table: {
                elementTitle: 'Mesa',
                elementType: 'select',
                elementConfig: {
                    options: [ ]
                },
                value: '1'
            },
            waiter: {
                elementTitle: 'Camarero',
                elementType: 'select',
                elementConfig: {
                    options: [ ]
                },
                value: '1'
            },
            chef: {
                elementTitle: 'Cocinero',
                elementType: 'select',
                elementConfig: {
                    options: [ ]
                },
                value: '1'
            },
            name: {
                elementTitle: 'Nombre',
                elementType: 'input',
                value: ''
            },
            lastname: {
                elementTitle: 'Primer Apellido',
                elementType: 'input',
                value: ''
            },
            secondLastname: {
                elementTitle: 'Segundo Apellido',
                elementType: 'input',
                value: ''
            },
            description: {
                elementTitle: 'Descripcion',
                elementType: 'textarea',
                value: ''
            },
            dish: {
                elementTitle: 'Plato',
                elementType: 'input',
                value: ''
            },
            import: {
                elementTitle: 'Importe',
                elementType: 'input',
                value: ''
            },
            additionalDishes: [ ]
        }
    }

    componentDidMount() {
        this.loadChefs();
        this.loadWaiters();
        this.loadTables();
    }

    loadChefs() {
        axios.get('http://localhost:8080/cocineros/api/list')
            .then(response => {
                
                let aux = response.data.map(e =>{

                    let completeName = e.nombre.concat(" ", e.apellido1, " ", e.apellido2);
                    return ({
                        value: e.id,
                        displayValue: completeName
                    });
                });
                
                this.setState(prevState => ({
                    ...prevState,
                    orderForm: {
                        ...prevState.orderForm,
                        chef: {
                            ...prevState.orderForm.chef,
                            elementConfig: {
                                ...prevState.orderForm.chef.elementConfig,
                                options: aux
                            }
                        }
                    }
                }));
                
            })
            .catch(error => {
                this.setState({error: true});
            });
    }

    loadWaiters() {
        axios.get('http://localhost:8080/camareros/api/list')
            .then(response => {
                
                let aux = response.data.map(e =>{

                    let completeName = e.nombre.concat(" ", e.apellido1, " ", e.apellido2);
                    return ({
                        value: e.id,
                        displayValue: completeName
                    });
                });
                
                this.setState(prevState => ({
                    ...prevState,
                    orderForm: {
                        ...prevState.orderForm,
                        waiter: {
                            ...prevState.orderForm.waiter,
                            elementConfig: {
                                ...prevState.orderForm.waiter.elementConfig,
                                options: aux
                            }
                        }
                    }
                }));
                
            })
            .catch(error => {
                this.setState({error: true});
            });
    }

    loadTables() {
        axios.get('http://localhost:8080/mesas/api/list')
            .then(response => {
                let aux = response.data.map(e =>{
                    return ({
                        value: e.id,
                        displayValue: e.ubicacion
                    });
                });
                
                this.setState(prevState => ({
                    ...prevState,
                    orderForm: {
                        ...prevState.orderForm,
                        table: {
                            ...prevState.orderForm.table,
                            elementConfig: {
                                ...prevState.orderForm.table.elementConfig,
                                options: aux
                            }
                        }
                    }
                }));
                
            })
            .catch(error => {
                this.setState({error: true});
            });
    }

    addDishHandler = () => {

        let localCount = this.state.counter;
        localCount++;
        let totalDishes = this.state.orderForm.additionalDishes;
        let value = {dish: '', import:''}
        totalDishes.push(value)

        this.setState(prevState => ({
            ...prevState,
            orderForm: {
                ...prevState.orderForm,
                additionalDishes: totalDishes
            }
        ,counter:localCount}));
    }

    removeDishHandler = (id) => {

        let totalDishes = this.state.orderForm.additionalDishes;
        delete totalDishes[id];

        this.setState({
            dishes: totalDishes
        });
    }

    billHandler = (event) => {
        event.preventDefault();

        const formData = {};

        for(let formElementIdentifier in this.state.orderForm) {
            formData[formElementIdentifier] = this.state.orderForm[formElementIdentifier].value;
        }

        formData['additionalDishes'] = this.state.orderForm.additionalDishes;
        
        const order = {
            orderData: formData
        }

        axios.post('http://localhost:8080/facturas/api/save_react', order)
            .then(response =>{
                //console.log('lllll ',response);
            })
            .catch(error => {

            });
    }

    inputChangedHandler = (value, inputIdentifier) => {
        
        const updatedOrderForm = {
            ...this.state.orderForm
        }

        const updatedFormElement = {
            ...updatedOrderForm[inputIdentifier]
        };

        updatedFormElement.value = value;
        //updatedFormElement.valid = this.checkValidity(updatedFormElement.value, updatedFormElement.validation);
        //updatedFormElement.touched = true;
        updatedOrderForm[inputIdentifier] = updatedFormElement;

        this.setState({orderForm: updatedOrderForm});
        
    }

    inputChangedHandlerAdditionalDishes = (value, inputIdentifier, type) => {
        
        const updatedOrderForm = [
            ...this.state.orderForm.additionalDishes
        ];

        const updatedFormElement = {
            ...updatedOrderForm[inputIdentifier]
        };

        if(type === 'dish') {
            updatedFormElement.dish = value;
        }
        else {
            updatedFormElement.import = value;
        }

        updatedOrderForm[inputIdentifier] = updatedFormElement;

        this.setState(prevState => ({
            ...prevState,
            orderForm: {
                ...prevState.orderForm,
                additionalDishes: updatedOrderForm
            }
        }));
    }

    render () {
        
        const formElementsArray = [];
        for(let key in this.state.orderForm) {
            if(key === 'date' || key === 'table' || key === 'waiter' || key === 'chef') {
                formElementsArray.push({
                    id: key,
                    config: this.state.orderForm[key]
                });
            }
        }

        let additonalDishes = Object.keys(this.state.orderForm.additionalDishes)
            .map(igKey => {
                return <Dish
                        key={igKey}
                        id={igKey}
                        removed={() => this.removeDishHandler(igKey)}
                        changed={this.inputChangedHandlerAdditionalDishes} >
                    </Dish>;
            })
            .reduce((arr, el) => {
                return arr.concat(el);
            }, []);

        let form = (
            <form onSubmit={this.billHandler}>
                <div className="row" >
                    {formElementsArray.map(formElement => {
        
                        return (
                            <SmallCard
                                key={formElement.id}
                                elementTitle={formElement.config.elementTitle}
                                elementType={formElement.config.elementType} 
                                elementConfig={formElement.config.elementConfig}
                                changed={(event) => this.inputChangedHandler(event.target.value, formElement.id)}>
                            </SmallCard>
                        )
                    })}
                </div>
                <div className="card" style={divStyle}>
                    <div className="row">
                        <div className="col-3 mb-4">
                            <h4>Datos Cliente</h4>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-3 mb-4">
                            <Input 
                                elementType="input"
                                placeholder="Nombre"
                                changed={(event) => this.inputChangedHandler(event.target.value, 'name')} />
                        </div>
                        <div className="col-3 mb-4">
                            <Input 
                                elementType="input"
                                placeholder="Primer Apellido"
                                changed={(event) => this.inputChangedHandler(event.target.value, 'lastname')} />
                        </div>
                        <div className="col-3 mb-4">
                            <Input 
                                elementType="input"
                                placeholder="Segundo Apellido"
                                changed={(event) => this.inputChangedHandler(event.target.value, 'secondLastname')}/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-9 mb-4">
                            <Input 
                                elementType="textarea"
                                placeholder="Descripcion Opcional"
                                changed={(event) => this.inputChangedHandler(event.target.value, 'description')} />
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-3 mb-4">
                            <button 
                                type="button" 
                                className="btn btn-info"
                                onClick={this.addDishHandler} >Agregar Plato</button>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-3 mb-4">
                            <Input 
                                elementType="input"
                                placeholder="Plato"
                                changed={(event) => this.inputChangedHandler(event.target.value, 'dish')} />
                        </div>
                        <div className="col-3 mb-4">
                            <Input 
                                elementType="input"
                                placeholder="Importe"
                                changed={(event) => this.inputChangedHandler(event.target.value, 'import')} />
                        </div>
                    </div>

                    {additonalDishes}

                    <div className="row">
                        <div className="col-6 mb-4">
                            <Button>Registrar Factura</Button>
                        </div>
                    </div>
                </div>
            </form>
        );

        return (
            <div>
                {form}
            </div>
        );
    }
}

export default Checkout;