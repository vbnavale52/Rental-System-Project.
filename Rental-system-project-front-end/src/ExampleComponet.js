import React, { Component } from 'react';

class ExampleComponet extends Component {
        constructor(props){
            super(props);
            this.state={
                firstName:"",
                lastName:"",
    
            }
           this.handleSubmit=this.handleSubmit.bind(this);
          // this.handleSubmit=this.onChange.bind(this);
        }
        handleSubmit(e)
        {
                e.
        }
    render() {
        return (
            <div>
                <label>Enter First Name</label><input value={this.state.firstName} onChange={this.onChange} name="firstName" type="text"/>
                <label>Enter Last Name</label><input value={this.state.lastName} onChange={this.onChange} name="lastName" type="text"/>
                <button onClick={this.handleSubmit}></button>
            </div>
        );
    }
}

export default ExampleComponet;
