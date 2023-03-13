import React from 'react'
import { Card } from 'react-bootstrap';
import ShoppingCart from '../ShoppingCart/ShoppingCart';
import "./about.css";

const About = () => {
  return (
    <div className='about'>
      <b>About Us</b>
      <br></br>
      <hr></hr>
      <Card className='mt-5'>
        <div> <img className='img1' src='https://images.unsplash.com/photo-1513104890138-7c749659a591?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8&w=1000&q=80' height={'600px'} width={'400px'} ></img></div>
      <div className='para'>Welcome to our pizza shop! We are a family-owned and operated business, dedicated to providing our customers with the best quality pizza and customer service.

Our dough is made fresh daily using only the finest ingredients, and we use only the freshest vegetables and meats for our toppings. We offer a variety of classic and specialty pizzas, as well as salads, wings, and desserts.

At our pizza shop, we believe in creating a warm and welcoming atmosphere for our customers. Whether you're dining in or taking your order to go, we strive to make your experience with us enjoyable and memorable.

We are committed to providing excellent customer service, and we take pride in our attention to detail. Our friendly staff will ensure that your order is prepared exactly as you want it, and we are always happy to answer any questions you may have.

Thank you for choosing our pizza shop, and we look forward to serving you soon!</div>  
     
   
      </Card>
      </div>
      
  )
}

export default About
