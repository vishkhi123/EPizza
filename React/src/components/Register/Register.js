import React, { useState, setState } from 'react';
import './register.css'
import axios from 'axios';
function Register() {


    let [customer, setcustomer] = useState({ firstName: "", lastName: "", email: "", password: "", mobileNo: NaN, address: "", pincode: NaN });

    const handleInputChange = (e) => {
        const { id, value } = e.target
        setcustomer({ ...customer, [id]: value })
       

    }

    const handleSubmit = () => {


        if (customer.firstName === "" || customer.lastName === "" || customer.email === "" || customer.password === "" || customer.mobileNo === NaN ||
            customer.address === "" || customer.pincode === NaN) {
            alert("Please fill all the fields");
            return;
        }

        axios.post('http://localhost:8080/users',customer)
            .then(response => {
                console.log(JSON.stringify(response.data));
                alert("Regustered SuccessFully")
                
            })
            .catch(error => {
                console.log(error);
            });



    }

    return (
        <div className="form">
            <div className="form-body">
                <div className="username">
                    <label className="form__label" for="firstName">First Name </label>
                    <input className="form__input" type="text" value={customer.firstName} onChange={(e) => handleInputChange(e)} id="firstName" placeholder="First Name" />
                </div>
                <div className="lastname">
                    <label className="form__label" for="lastName">Last Name </label>
                    <input type="text" name="" id="lastName" value={customer.lastName} className="form__input" onChange={(e) => handleInputChange(e)} placeholder="LastName" />
                </div>
                <div className="email">
                    <label className="form__label" for="email">Email </label>
                    <input type="email" id="email" className="form__input" value={customer.email} onChange={(e) => handleInputChange(e)} placeholder="Email" />
                </div>
                <div className="password">
                    <label className="form__label" for="password">Password </label>
                    <input className="form__input" type="password" id="password" value={customer.password} onChange={(e) => handleInputChange(e)} placeholder="Password" />
                </div>
                <div className="mobile-number">
                    <label className="form__label" for="mobileNo">Mobile Number </label>
                    <input className="form__input" type="number" id="mobileNo" value={customer.mobileNo} onChange={(e) => handleInputChange(e)} placeholder="Mobile Number" />
                </div>
                <div className="address">
                    <label className="form__label" for="address">Address</label>
                    <textarea className="form__input" id="address" value={customer.address} onChange={(e) => handleInputChange(e)} placeholder="Address" />
                </div>
                <div className="pincode">
                    <label className="form__label" for="pincode">pincode </label>
                    <input className="form__input" type="number" id="pincode" value={customer.pincode} onChange={(e) => handleInputChange(e)} placeholder="pincode" />
                </div>
            </div>
            <div class="footer">
                <button onClick={() => handleSubmit()} type="submit" class="btn btn-primary">Register</button>
            </div>
        </div>

    )
}

export default Register;
