import React from 'react'
import Footer from './components/common/footer/Footer'
import Header from './components/common/header/Header'
import TabOptions from './components/common/tabOptions/TabOptions'
import HomePage from './pages/home/HomePage'
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router,Switch,Route } from 'react-router-dom'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import ShoppingCart from './components/ShoppingCart/ShoppingCart'
import Product from './components/Product/Product'
import Login from './components/Login/Login'
import Profile from './components/ProfileUpdate/Profile';
import ProfileUpdate from './components/ProfileUpdate/ProfileUpdate';
import Payment from './components/Payment/Payment'
import Order from './components/Order/Order'



const App = () => {
  return (
    <div >
      <Header></Header>
   {/* <HomePage></HomePage> */}
   
   <Router>
      <Switch>
      <Route path="/" exact component={HomePage}></Route>
        
        <Route path="/product/:prodname"  component={Product}></Route>
        {/* <Route path="/menu" component={Menu}></Route> */}
        <Route path="/cart" component={ShoppingCart}></Route>
        <Route path="/login" component={Login}></Route>
        <Route path="/home" component={HomePage}></Route>
        <Route path="/profile" component={Profile}></Route>
        <Route path="/paymentdone" component={Order}></Route>
        <Route path="/payment/:totalprice" component={Payment}></Route>
        <Route path="/updateprofile" component={ProfileUpdate}></Route>

      </Switch>
      </Router>
    {/* <TabOptions></TabOptions>
    {/* Different Screen */}
     <Footer></Footer>
    </div>
  )
}

export default App

