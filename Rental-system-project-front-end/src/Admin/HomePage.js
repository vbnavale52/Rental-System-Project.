import React, { Component } from 'react'
import "./HomePage.css";
import { Link } from "react-router-dom";
import UserRegistration from '../CustomerScreen/UserRegistration'
import UserProfile from '../CustomerScreen/ViewProfile'
import CategoryPage from './CategoryPage';
import AdminIcon from "./Images/admin.jpg"


export default class HomePage extends Component {
    render() {
        return (
            <div >
                <div className="main ml-0 mr-0" >
                    <div className="row">
                        <div class="container-fluid mt-0">
                            <nav class="navbar navbar-dark bg-dark navbar-expand-lg mt-0  mr-0">
                                <a class="navbar-brand" href="RSYS"></a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarText">
                                    <ul class="navbar-nav mr-auto">
                                        <li className="nav-item">
                                            <Link className="nav-link" to="/admin_home" >
                                                <i class="fa fa-home" aria-hidden="true"></i> Home
                                            </Link>
                                        </li>
                                        <li className="nav-item">
                                            <Link className="nav-link" to="/products" >
                                                <i class="fa fa-list-alt" aria-hidden="true"></i> Categories
                                            </Link>
                                        </li>
                                        <li className="nav-item">
                                            <Link class="nav-link " to="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
                                                <i class="fab fa-product-hunt"></i> Equipments
                                            </Link>
                                        </li>
                                    </ul>
                                </div>
                                <div>
                                    <form class="form-inline my-2 my-lg-0">
                                        <input class="form-control mr-sm-2 md-5" type="search" placeholder="Search" />
                                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                                    </form>
                                </div>
                            </nav>
                        </div>
                    </div>
                    <div className="row ">
                        <div className="col-md-2 mt-1 ">
                            <div className="cart  sidebar ">
                                <div className="card-body ">
                                    <div className="row">
                                        <div className="col md-3 text-center">
                                            <img
                                                src={AdminIcon}
                                                alt="profile-img"
                                                className="rounded-circle"
                                                style={{ width: "50%" }}
                                            />
                                        </div>
                                    </div>
                                    <div className="col text-center">
                                        <h6>Welcome, {window.localStorage.getItem("user_fname")}</h6>
                                    </div>
                                    <br />
                                    <ul className="navbar-nav ml-auto ">
                                        <div className="hori-selector">
                                            <div className="left"></div>
                                            <div className="right"></div>
                                        </div>
                                        <li className="nav-item">
                                            <Link className="nav-link" to="/admin_home" >
                                                <i class="fa fa-home" aria-hidden="true"></i> Home
                                            </Link>
                                        </li>
                                        <li className="nav-item">
                                            <Link className="nav-link" to="/products" >
                                                <i class="fa fa-list-alt" aria-hidden="true"></i> Categories
                                            </Link>
                                        </li>
                                        <li className="nav-item">
                                            <Link class="nav-link dropdown-toggle" to="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
                                                <i class="fab fa-product-hunt"></i> Equipments
                                            </Link>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                                <Link className="dropdown-item bg-primary" to="/admin_home">Equipments list</Link>
                                                <Link className="dropdown-item bg-primary" to="/admin_home">Delivered</Link>
                                                <Link className="dropdown-item bg-primary" to="/admin_home">Recived</Link>
                                            </div>
                                        </li>
                                        <li className="nav-item">
                                            <Link className="nav-link" to="/products" >
                                                <i class="fas fa-users"></i> Users
                                            </Link>
                                        </li>
                                        <li className="nav-item">
                                            <Link className="nav-link" to="/products" >
                                                <i class="fab fa-jedi-order"></i> Orders
                                            </Link>
                                        </li>

                                        <li className="nav-item">
                                            <Link className="nav-link" to="/products" >
                                                <i class="fas fa-sign-out-alt"></i> Sign out
                                            </Link>
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div className="col mt-0">
                            <div className="card-mb-3 mt-0 content">
                                <h1 className="m-3 pt-3 text-center"></h1>
                                <div className="card-body">
                                    <CategoryPage/>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        )
    }
    
}



