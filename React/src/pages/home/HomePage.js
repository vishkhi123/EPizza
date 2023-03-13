import React, { useState } from 'react'
import About from '../../components/About/About'
import Footer from '../../components/common/footer/Footer'
import Header from '../../components/common/header/Header'
import TabOptions from '../../components/common/tabOptions/TabOptions'
import Contact from '../../components/Contacts/Contact'
import Home from '../../components/Home/Home'
import Login from '../../components/Login/Login'
import Menu from '../../components/Menu/Menu'
import Register from '../../components/Register/Register'
import { BrowserRouter as Router,Switch,Route } from 'react-router-dom'
import Product from '../../components/Product/Product'
import ShoppingCart from '../../components/ShoppingCart/ShoppingCart'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const HomePage = () => {

    const [activeTab,setActiveTab]=useState("Home");

  return (
    <div>
      
      
      <TabOptions activeTab={activeTab} setActiveTab={setActiveTab}></TabOptions>
      {getCorrectScreen(activeTab)}

     
    </div>
  )
}

const getCorrectScreen = (tab) => {

    switch(tab)
    {
        case "Home":
            return <Home></Home>
        case "Menu":
            return <Menu></Menu>
        case "Register":
            return <Register></Register>
        case "Login":
            return <Login></Login>
        case "About":
            return <About></About>
        case "Contact Us":
            return <Contact></Contact>
        
        default:
            return <Home></Home>
    }

}

export default HomePage;
