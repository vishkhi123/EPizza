import React, { useState } from 'react'
import "./login.css";
import axios from 'axios';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useHistory } from 'react-router-dom';

const Login = () => {
    const history=useHistory();

    let [customer, setcustomer] = useState({email:"", password:"" })
    let [cust, setcust] = useState({ firstName: "", lastName: "", email: "", password: "", mobileNo: NaN, address:"", pincode: NaN });

    const handleInputChange = (e) => {
        const { id, value } = e.target
        setcustomer({ ...customer, [id]: value })
    }

    const handleSubmit = (event) => {
        

        if (customer.email === "" || customer.password === ""  ) 
        {
            toast.warn('🦄 Wow so easy!', {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
                });
            return;
        }
        // alert("before axios")
        var api=`http://localhost:8080/users/login/${customer.email}/${customer.password}`
        axios.post(api )
            .then(response => {
                console.log(response.data);
                alert("login successfully");
                
                localStorage.setItem("user",JSON.stringify(response.data));
                localStorage.setItem("name",response.data.firstName);
                localStorage.setItem("email",response.data.email);
                toast.success('Success notification!', {
                    position: "top-right",
                    autoClose: 3000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                  });
                history.push("/")
                window.location.reload("/")
                
            })
            .catch(error => {
                console.log(error);
                toast.error("Bad User Credentials")
            });

    }




  return (

    

    <div class="wrapper">
        <div class="logo">
            <img src="https://scontent.fpnq7-2.fna.fbcdn.net/v/t39.30808-6/300374525_439235041557981_998846646059063545_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=6iGKU--J878AX9tlf5P&_nc_ht=scontent.fpnq7-2.fna&oh=00_AfAqF6uV8rhBIgBWnpxc9m_WNjX5c34fQhY90_hdwWPevw&oe=64040CC9" alt=""/>
        </div>
        <div class="text-center mt-4 name">
            Pizza Hub
        </div>
        <form class="p-3 mt-3" method='POST' >
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="text" name="email" id="email" value={customer.email} onChange={(e) => handleInputChange(e)} placeholder="Email"/>
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="password" id="password" value={customer.password} onChange={(e) => handleInputChange(e)} placeholder="Password"/>
            </div>
            {/* <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="conformPassword" id="conformPassword" value={customer.confirmPassword} onChange={(e) => handleInputChange(e)} placeholder="Confirm Password"/>
            </div> */}
            <span onClick={() => handleSubmit()}  class="btn mt-3">Login</span>
        </form>
        <div class="text-center fs-6">
        {/* <button onClick={() => handleSubmit()} type="submit" class="btn btn-primary">Loginlll</button> */}
            <a href="#">Forget password?</a> or <a href="#">Sign up</a>
        </div>
    </div>

    
  )
}

export default Login
