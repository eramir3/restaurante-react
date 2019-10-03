import React, { Component } from 'react';

import Input from '../../UI/Input/Input';


class Dish extends Component {

    inputChangedHandlerDish = (value, id, type) => {
        this.props.changed(value, id, type);
    }

    removeDish = (id) => {
        this.props.removed(id);
    }

    render() {

        let id = this.props.id;

        return (
            <div className="row">
                <div className="col-3 mb-4">
                    <Input 
                        elementType="input"
                        placeholder="Plato" 
                        changed={(event) => this.inputChangedHandlerDish(event.target.value, id, 'dish')} />
                </div>
                <div className="col-3 mb-4">
                    <Input 
                        elementType="input"
                        placeholder="Importe"
                        changed={(event) => this.inputChangedHandlerDish(event.target.value, id, 'import')} />
                </div>
                <div className="col-3 mb-4">
                    <button 
                        type="button" 
                        className="btn btn-danger"
                        onClick={() => this.removeDish(this.props.id)}>
                        Eliminar</button>
                </div>
            </div>
        );
    }
}

export default Dish;