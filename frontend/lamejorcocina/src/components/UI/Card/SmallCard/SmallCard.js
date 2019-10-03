import React from 'react';

import Input from '../../Input/Input';

const divStyle = {
    padding: '20px'
};

const smallCard = (props) => (

    <div className="col-6 mb-4">
        <div className="card" style={divStyle}>
            <div className="row">
                <div className="col-12 mb-4">
                    <h4>{props.elementTitle}</h4>
                </div>
            </div>
            <div className="row">
                <div className="col-12 mb-4">
                    <Input 
                        elementType={props.elementType}
                        elementConfig={props.elementConfig}
                        changed={props.changed} />
                </div>
            </div>
        </div>
    </div>
);

export default smallCard;

