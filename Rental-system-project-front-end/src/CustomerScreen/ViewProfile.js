import React, { Link } from "react-router-dom";
import "./ViewProfile.css";
import { Component } from "react";
import imges from "./Images/images.jpg";
class UserProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: "",
            firstName: "",
            lastName: "",
            email: "",
            idNumber: "",
            phoneNumber: "",
            dateOfBirth: "",
            profileImage: "",
            message: "",
            uploadFile: null,
        };
        // this.registerUser = this.registerUser.bind(this);
        //this.changeImageHandler = this.changeImageHandler.bind(this);
        //this.userProfilePicture = this.userProfilePicture.bind(this);
    }
    componentDidMount() {
        this.setState({
            userId: window.localStorage.getItem("user_id"),
            userName: window.localStorage.getItem("user_name"),
            firstName: window.localStorage.getItem("user_fname"),
            lastName: window.localStorage.getItem("user_lname"),
            dateOfBirth: window.localStorage.getItem("user_dob"),
            phoneNumber: window.localStorage.getItem("user_phone"),
            email: window.localStorage.getItem("user_email"),
            idNumber: window.localStorage.getItem("user_idNum"),
            profileImage: window.localStorage.getItem("user_image"),
        })

    }
    /*
        onChange = (event) => {
            this.setState({
                [event.target.name]: event.target.value
            });
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
                idNumber: this.state.idNumber,
                profileImage: this.state.profileImage,
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
                    idNumber: user.idNumber,
                    message: '',
                });*/
    /* user != null && window.localStorage.setItem("user_fname", user.firstName);
user != null && window.localStorage.setItem("user_lname", user.lastName);
user != null && window.localStorage.setItem("user_email", user.email);
user != null && window.localStorage.setItem("user_dob", user.dateOfBirth);
user != null && window.localStorage.setItem("user_phone", user.phoneNumber);
user != null && window.localStorage.setItem("user_image", user.profileImage);
user != null && window.localStorage.setItem("user_idNum", user.idNumber);
if (res.data.result === null) {
alert(res.data.message);
this.setState({
firstName: "",
lastName: "",
dateOfBirth: "",
phoneNumber: "",
email: "",
profileImage: "",
});
this.props.history.push("/user_profile");
} else {
this.props.history.push("/signin");
}
})
};
cancel() {
this.props.history.push('/home')
} */

    render() {
        return (
            <div className="container">
                <div className="main" >

                    <div className="row">
                        <div className="col-md-4 mt-1">
                            <div className="cart text-center sidebar">
                                <div className="card-body">
                                    <div className="mt-3">
                                        <img
                                            src={imges}
                                            alt="profile-img"
                                            className="rounded-circle"
                                            style={{ width: "100%" }}
                                        />
                                    </div>
                                    <div className="mt-3">
                                        <h3>{this.state.userName}</h3>
                                        <h4>{this.state.firstName}</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-8 mt-0">
                            <div className="card-mb-3  content">
                                <h1 className="m-3 pt-3 text-center">Profile Details</h1>
                                <div className="card-body">
                                    <div className="row">
                                        <div className="col-md-3 ">
                                            <h5>First Name </h5>
                                        </div>
                                        <div className="col-md-9 text-secondary">
                                            <h5>{this.state.firstName}</h5>
                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-md-3">
                                            <h5>Last Name </h5>
                                        </div>
                                        <div className="col-md-9 text-secondary">
                                            <h5>{this.state.lastName}</h5>
                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-md-3">
                                            <h5>Email Name </h5>
                                        </div>
                                        <div className="col-md-9 text-secondary">
                                            <h5>{this.state.email}</h5>
                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-md-3">
                                            <h5>Date of Birth </h5>
                                        </div>
                                        <div className="col-md-9 text-secondary">
                                            <h5>{this.state.dateOfBirth}</h5>
                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-md-3">
                                            <h5>ID Number </h5>
                                        </div>
                                        <div className="col-md-9 text-secondary">
                                            <h5>{this.state.idNumber}</h5>
                                        </div>
                                    </div>
                                    <hr/>
                                    <div className="row">
                                        <div className="col-md-3">
                                            <h5>Phone Number </h5>
                                        </div>
                                        <div className="col-md-9 text-secondary">
                                            <h5>{this.state.phoneNumber}</h5>
                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-md-3">
                                            <h5>Address </h5>
                                        </div>
                                        <div className="col-md-9 text-secondary">
                                            <h5>Kothrud, Pune, Maharashtra, 411038 </h5>
                                            <h5>Nandgaon, Nashik, Maharashtra, 423106</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="card-mb-3 content">
                                <h2 className="m-3 pt-3">Bookings Details</h2>
                                <div className="card-body">
                                    <div className="row">
                                        <div className="col-md-3">
                                            <h5>Booking Dates </h5>
                                        </div>
                                        <div className="col-md-9 text-secondary">
                                            <h5>This is all information about booking on our site </h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        );
    }
}
export default UserProfile;