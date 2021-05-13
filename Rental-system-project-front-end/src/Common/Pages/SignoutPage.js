import { Alert } from 'bootstrap';
import React, { Component } from 'react';

class SignoutPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
        }
    }
    componentDidMount() {
        window.localStorage.removeItem("status");
        window.localStorage.removeItem("user_id");
        window.localStorage.removeItem("user_name");
        window.localStorage.removeItem("user_role");
        window.localStorage.removeItem("user_fname");
        window.localStorage.removeItem("user_lname");
        window.localStorage.removeItem("user_email");
        window.localStorage.removeItem("user_dob");
        window.localStorage.removeItem("user_phone");
        window.localStorage.removeItem("user_image");
        alert("Sign ou successfuully ! tacke care.........")
        this.props.history.push('/');
    }
    render() {
        return (
            <div>

            </div>
        );
    }
}

export default SignoutPage;
