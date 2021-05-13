import React, { Component } from 'react'

class CategoryPage extends Component {
    constructor(props) {
        super(props)
        this.state = {

        }
        this.viewEquipment=this.viewEquipment.bind(this);
    }

    onChangeCategory = (event) => {
        this.setState({ categoryName: event.target.value });
    }

    viewOldProduct(id, name) {
        window.localStorage.setItem("cat_id", id);
        window.localStorage.setItem("cat_name", name);
        this.props.history.push(`/products-under-category/${id}`);
    }
    viewEquipment()
    {
        this.props.history.push('/home');   
    }
    render() {
        return (
            <div>
             <h5 className="text-center">Category List</h5>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Sr. No</th>
                            <th scope="col">Category Name</th>
                            <th scope="col">Image</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Camera</td>
                            <td><img src="https://all-free-download.com/free-photos/download/digital-slr-camera_188800.html"/></td>
                            <td>
                                <button type="button" class="btn btn-outline-info" onClick={this.viewEquipment} >View</button>
                                <button type="button" class="btn btn-outline-danger" style={{marginLeft:"10px"}}>Remove</button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Camera</td>
                            <td><img src="https://all-free-download.com/free-photos/download/digital-slr-camera_188800.html"/></td>
                            <td>
                                <button type="button" class="btn btn-outline-info" onClick={this.viewEquipment} >View</button>
                                <button type="button" class="btn btn-outline-danger" style={{marginLeft:"10px"}}>Remove</button>
                            </td>
                        </tr>
                    </tbody>
                    {/* <thead className="text-center ">
                                <tr>
                                    <th> Sr. No.</th>
                                    <th> Category Name</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.category.map(
                                        category =>
                                            <tr key={category.id}>
                                                <td className="text-center ">{++i}</td>
                                                <td>{category.categoryName}</td>
                                                <td>
                                                    <button style={{ backgroundColor: "darkcyan", marginLeft: "30px" }} className="btn btn-info" onClick={() => this.viewOldProduct(category.id, category.categoryName)} >View Products</button>
                                                    <button className="btn btn-danger" style={{ backgroundColor: "red", marginLeft: '10px' }} onClick={() => this.removeCategory(category.id)}>Remove</button>
                                                </td>

                                            </tr>
                                    )
                                }
                            </tbody> */}
                </table>
            </div>
        )
    }
}
export default CategoryPage;
