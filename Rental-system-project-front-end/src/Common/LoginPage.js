
import React, { Component } from 'react'
//import SigninIcon from "./images/login-icon-png.png"
import { Link } from 'react-router-dom';
import Popup from "./PopUp"
import {Modal} from "react-responsive-modal";
import AuthService from "../Services/AuthService";
import UserService from "../Services/UserServices";
class LoginPage extends Component {

  constructor(props) {
    super(props)
    this.state = {
      id: '',
      userName: '',
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      phoneNumber: '',
      profileImage: '',
      dateOfBirth: '',
      userRole: '',
      message: '',
  
    }
    this.authenticateUser = this.authenticateUser.bind(this);
    //  this.getCartSize = this.getCartSize.bind(this);
    // this.updateUserCart = this.updateUserCart.bind(this);
  }

  
  handleReset(e) {
    e.preventDefault();
  
  }
  onChange = (e) =>
    this.setState({ [e.target.name]: e.target.value });
  /*
    getCartSize() {
      setTimeout(() => {
        ApiCustomerService.getCartByUserId(JSON.parse(window.localStorage.getItem("user_id")))
          .then((res) => {
            JSON.stringify(window.localStorage.setItem("cart_size", res.data.result.length));
          });
      }, 1000);*/


  /*
    updateUserCart() {
      let cartUserId = JSON.parse(window.localStorage.getItem("user_id"));
      let cartSize = JSON.parse(window.localStorage.getItem("cart_size"));
      if (cartSize > 0) {
        ApiCustomerService.updateCartUserId(cartUserId);
      }
      this.getCartSize();
    }*/
  authenticateUser = (e) => {
    e.preventDefault();
    let loginRequest = { userName: this.state.userName, password: this.state.password };
    AuthService.authenticateUser(loginRequest)
      .then(res => {
        let user = res.data.result;
        console.log(user);
        user === null && this.setState({ message: 'Invalid Login Credentials', userName: "", password: "" });
        user !== null && this.setState({
          id: user.id,
          userName: user.userName,
          userRole: user.userRole,
          message: '',
        });
        user != null && alert("User Login successfully")
        user != null && this.setState({ message: 'User Login successfully.' });
        user != null && window.localStorage.setItem("status", true);
        user != null && window.localStorage.setItem("user_id", user.id);
        user != null && window.localStorage.setItem("user_name", user.userName);
        user != null && window.localStorage.setItem("user_role", user.userRole);
      });

    UserService.getUserProfile(this.state.id)
      .then(res => {
        let user = res.data.result;
        user == null && this.props.history.push('/user_profile');
        //user === null && this.setState({ message: 'Invalid Login Credentials', userName: "", password: "" }) ;
        user != null && window.localStorage.setItem("user_fname", user.firstName);
        user != null && window.localStorage.setItem("user_lname", user.lastName);
        user != null && window.localStorage.setItem("user_email", user.email);
        user != null && window.localStorage.setItem("user_dob", user.dateOfBirth);
        user != null && window.localStorage.setItem("user_phone", user.phoneNumber);
        user != null && window.localStorage.setItem("user_image", user.profileImage);
      });

    //user != null && user.admin === false && this.updateUserCart();
    /*
    if (user != null && user.admin) {
      user != null && window.localStorage.setItem("user_role", 'ADMIN');
      user != null && user.admin === true && this.props.history.push('/admin');
    }
    else {
      user != null && window.localStorage.setItem("user_role", 'CUSTOMER');
      user != null && user.admin === false && this.props.history.push('/home');
    }
*/




  }
  render() {
 
    return (
      <div>
        <br />
        <br />
        <br />
        <div className="card img-rounded col-md-4 offset-md-4 offset-md-4 " style={{ borderRadius: "25px", backgroundColor: "OldLace" }}>
          <h2 className="text-center card-title"> <b>Sign In </b></h2>
          <br />
          <img style={{ width: "190px" }}
            // src={SigninIcon}
            alt="profile-img"
            className="profile-img-card"
          />
          <br />
          <h5 className="nameColor1 text-center">{this.state.message}</h5>
          <div class="row mb-3">
            <label className="col-sm-4 col-form-label">User Name</label>
            <div className="col-sm-8">
              <input type="text"
                className="form-control"
                name="userName"
                value={this.state.userName}
                onChange={this.onChange}
                required
              />
            </div>
          </div>
          <div class="row mb-3">
            <label className="col-sm-4 col-form-label">Password</label>
            <div className="col-sm-8">
              <input type="password"
                className="form-control"
                name="password"
                value={this.state.password}
                onChange={this.onChange}
                required />
            </div>
          </div>

          <div className="mb-3">
            <button className="btn btn-success float-start" onClick={this.authenticateUser}>
              Login
             </button>
            <div className="float-end" style={{ marginLeft: "10px" }}>
              Click here to <button className="btn btn-primary-outline" onClick={this.handleReset} >
           
              Forgot Password</button>
            </div>
            <div className="float-end">
              New User? <Link to="/create-account">Create Account here</Link>
            </div>
            <br></br>
          </div>
        </div>
      </div>
    );
  }
}
export default LoginPage

