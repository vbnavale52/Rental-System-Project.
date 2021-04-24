import { Link } from "react-router-dom";
import UserService from "../Services/UserServices";
import React, { Component } from "react";

class UserProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstName: "",
            lastName: "",
            email: "",
            phoneNumber: "",
            dateOfBirth: "",
            profileImage: "",
            message: "",
            uploadFile: null,
        };
        this.registerUser = this.registerUser.bind(this);
        this.changeImageHandler = this.changeImageHandler.bind(this);
        this.userProfilePicture = this.userProfilePicture.bind(this);
    }

    onChange = (event) => {
        this.setState({ [event.target.name]: event.target.value });
    }

    changeImageHandler = (event) => {
        this.setState({ uploadFile: event.target.files[0] });
        this.userProfilePicture()
    }
    async userProfilePicture() {
        const formData = new FormData();
        formData.append('file', this.state.uploadFile);
        UserService.fileUpload(formData).then(res => {
            res.data.result != null && this.setState({ profileImage: res.data.result });
            console.log(res.data.result);
            return res.data.result;
        });
    }

    registerUser = (e) => {
        e.preventDefault()
        //this.userProfilePicture();
        let saveUser = {
            userId: window.localStorage.getItem("user_id"),
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            dateOfBirth: this.state.dateOfBirth,
            phoneNumber: this.state.phoneNumber,
            email: this.state.email,
            profileImage:this.state.profileImage ,
        };
        UserService.userProfile(saveUser).then((res) => {
            res.data.result != null && alert("SignUp successfully");
            let user = res.data.result;
            user != null && this.props.history.push('/user_profile');
            user === null && this.setState({ message: 'Invalid Login Credentials', userName: "", password: "" });
            user !== null && this.setState({
                // id : user.id,
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.email,
                dateOfBirth: user.dateOfBirth,
                phoneNumber: user.phoneNumber,
                profileImage: user.profileImage,
                message: '',
            });
            user != null && window.localStorage.setItem("user_fname", user.firstName);
            user != null && window.localStorage.setItem("user_lname", user.lastName);
            user != null && window.localStorage.setItem("user_email", user.email);
            user != null && window.localStorage.setItem("user_dob", user.dateOfBirth);
            user != null && window.localStorage.setItem("user_phone", user.phoneNumber);
            user != null && window.localStorage.setItem("user_image", user.profileImage);
            if (res.data.result === null) {
                alert(res.data.message);
                this.setState({
                    firstName: "", lastName: "", dateOfBirth: "", phoneNumber: "", email: "", profileImage: "",
                });
                this.props.history.push("/user_profile");
            }
            else {
                this.props.history.push("/signin");
            }
        })
    };
    cancel() {
        this.props.history.push('/home')
    }


    render() {
        return (
            <div>
                <div className="main " style={{ backgroundColor: 'OldLace' }} >
                    <h2 style={{ color: "chocolate" }}>Sign Up New User </h2>
                    <div className="card-body ">
                        <img style={{ width: "190px" }}
                            src={window.localStorage.getItem("user_image")}
                            alt="profile-img"
                            className="profile-img-card"
                        />
                        <br />
                        <div className="form">
                            <div className="row mb-3">
                                <label className="col-sm-4 col-form-label">Choose images :</label>
                                <div className="col-sm-8">
                                    <input type="file" onChange={this.changeImageHandler} />
                                </div>
                            </div>
                            <div class="row mb-4" >
                                <label className="col-sm-3 col-form-label ">First Name</label>
                                <div className="col-sm-8">
                                    <input
                                        type="text"
                                        className="form-control"
                                        name="firstName"
                                        value={this.state.firstName}
                                        onChange={this.onChange}
                                        required=""
                                    />

                                </div>
                            </div>

                            <div class="row mb-4">
                                <label className="col-sm-3 col-form-label">Last Name</label>
                                <div className="col-sm-8">
                                    <input
                                        type="text"
                                        className="form-control"
                                        name="lastName"
                                        value={this.state.lastName}
                                        onChange={this.onChange}
                                        required
                                    />

                                </div>
                            </div>
                            <div class="row mb-4">
                                <label className="col-sm-3 col-form-label">Date Of Birth</label>
                                <div className="col-sm-8">
                                    <input
                                        type="date"
                                        className="form-control"
                                        name="dateOfBirth"
                                        value={this.state.dateOfBirth}
                                        onChange={this.onChange}
                                        required
                                    />
                                </div>
                            </div>
                            <div class="row mb-4">
                                <label className="col-sm-3 col-form-label">Phone Number</label>
                                <div className="col-sm-8">
                                    <input
                                        type="text"
                                        className="form-control"
                                        name="phoneNumber"
                                        value={this.state.phoneNumber}
                                        onChange={this.onChange}
                                        required
                                    />
                                </div>
                            </div>

                            <div class="row mb-4">
                                <label className="col-sm-3 col-form-label">Email</label>
                                <div className="col-sm-8">
                                    <input
                                        type="email"
                                        className="form-control"
                                        name="email"
                                        value={this.state.email}
                                        onChange={this.onChange}
                                        required
                                    />

                                </div>
                            </div>

                            <div className="mb-3">
                                <button className="btn btn-success float-start" onClick={this.registerUser} > Register </button>
                                <button className=" btn-danger btn" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px", backgroundColor: "Tomato" }}>Cancel</button>
                                <div className="float-end">
                                    Existing User? <Link to="/login">Login here </Link>
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
export default UserProfile;


