import "../App.css";
import { Link } from "react-router-dom";
import UserService from "../Services/UserServices";
import React, { Component } from "react";

class UserRegistration extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: "",
            password: "",
            confirmPassword: "",
            message: "",
        };
        this.registerUser = this.registerUser.bind(this);
    }

    onChange = (event) => {
        this.setState({ [event.target.name]: event.target.value });
    }

    registerUser = (e) => {
        e.preventDefault();

        let user = {
            userName: this.state.userName,
            password: this.state.password,
            confirmPassword: this.state.confirmPassword,
        };
        UserService.registerNewUser(user).then((res) => {
            res.data.result != null && alert("SignUp successfully");
            if (res.data.result === null) {
                alert(" Sign up failed..............." + res.data.message);
                this.setState({
                    firstName: "", lastName: "", dateOfBirth: "", phoneNumber: "", email: "", password: "",
                    confirmPassword: ""
                });
                this.props.history.push("/create-account");
            } else {
                alert(res.data.message);
                this.props.history.push("/user_profile");
            }
        })
    };


    cancel() {
        this.props.history.push('/')
    }


    render() {
        return (
            <div>
                <div className="main " style={{ backgroundColor: 'OldLace' }} >
                    <h2 style={{ color: "chocolate" }}>Sign Up New User </h2>
                    <div className="card-body ">
                        <img style={{ width: "190px" }}
                           
                            alt="profile-img"
                            className="profile-img-card"
                        />
                        <br />
                        <div className="form">
                            <div class="row mb-4" >
                                <label className="col-sm-3 col-form-label ">User Name</label>
                                <div className="col-sm-8">
                                    <input
                                        type="text"
                                        className="form-control"
                                        name="userName"
                                        value={this.state.userName}
                                        onChange={this.onChange}
                                        required=""
                                    />

                                </div>
                            </div>

                            <div class="row mb-4">
                                <label className="col-sm-3 col-form-label">Password</label>
                                <div className="col-sm-8">
                                    <input
                                        type="password"
                                        className="form-control"
                                        name="password"
                                        value={this.state.password}
                                        onChange={this.onChange}
                                        required
                                    />
                                </div>
                            </div>

                            <div class="row mb-4">
                                <label className="col-sm-3 col-form-label">Confirm Password</label>
                                <div className="col-sm-8">
                                    <input
                                        type="password"
                                        className="form-control"
                                        name="confirmPassword"
                                        value={this.state.confirmPassword}
                                        onChange={this.onChange}
                                        required
                                    />
                                </div>
                            </div>
                            <div className="mb-3">
                                <button className="btn btn-success float-start" onClick={this.registerUser} >
                                    Register
                     </button>
                                <button className=" btn-danger btn" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px", backgroundColor: "Tomato" }}>Cancel</button>
                                <div className="float-end">
                                    Existing User? <Link to="/sign_in">Login here </Link>
                                </div>
                                <br></br>


                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}
export default UserRegistration;